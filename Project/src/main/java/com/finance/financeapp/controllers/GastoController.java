package com.finance.financeapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.GastoRequest;
import com.finance.financeapp.contracts.GastoResponse;
import com.finance.financeapp.ejb.Gasto;
import com.finance.financeapp.pojo.GastoPOJO;
import com.finance.financeapp.services.GastoServiceInterface;
import com.finance.financeapp.utils.PojoUtils;

@Component
@Path("/protected/gastos")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class GastoController extends BaseController{

	private final String getAllCodeMessage = "Se obtuvieron los gastos correctamente";
	private final String correctSaveGasto = "Se guardó el gasto correctamente";
	
	@Autowired
	GastoServiceInterface gastoService;
	
	@Path("/getAll")
	@POST
	@Transactional
	public GastoResponse getAll(GastoRequest gastoRequest){
		
		gastoRequest.setPageNumber(gastoRequest.getPageNumber() - 1);
		Page<Gasto> gastos = gastoService.getAll(gastoRequest);

		GastoResponse gastoResponse = new GastoResponse();

		gastoResponse.setCode(successCode);
		gastoResponse.setCodeMessage(getAllCodeMessage);
		gastoResponse.setTotalElements(gastos.getTotalElements());
		gastoResponse.setTotalPages(gastos.getTotalPages());

		List<GastoPOJO> viewGastos = new ArrayList<GastoPOJO>();
		for (Gasto gasto : gastos.getContent()){
			GastoPOJO ngasto = new GastoPOJO();
			PojoUtils.pojoMappingUtility(ngasto,gasto);
			viewGastos.add(ngasto);
		}

		gastoResponse.setGastos(viewGastos);
		return gastoResponse;	
	}
	
	@Path("/save")
	@POST
	public GastoResponse save(GastoRequest gastoRequest){	

		GastoResponse gastoResponse = new GastoResponse();
		Gasto gasto = new Gasto();
		gasto.setIdGasto(gastoRequest.getGasto().getIdGasto());
		gasto.setMonto(gastoRequest.getGasto().getMonto());		
		gasto.setLugar(gastoRequest.getGasto().getLugar());
		gasto.setDescripcion(gastoRequest.getGasto().getDescripcion());
		gasto.setFecha(getDate());
		
		if(gastoService.saveGasto(gasto)){
			gastoResponse.setCode(successCode);
			gastoResponse.setCodeMessage(correctSaveGasto);
		}
		return gastoResponse;
	}
}