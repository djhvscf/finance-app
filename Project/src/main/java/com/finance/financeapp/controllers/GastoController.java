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
import com.finance.financeapp.contracts.UsersRequest;
import com.finance.financeapp.contracts.UsersResponse;
import com.finance.financeapp.ejb.Gasto;
import com.finance.financeapp.ejb.TipoUsuario;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.pojo.GastoPOJO;
import com.finance.financeapp.services.GastoServiceInterface;
import com.finance.financeapp.utils.PojoUtils;

@Component
@Path("/protected/gastos")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class GastoController {

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

		gastoResponse.setCode(200);
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
	
	@Path("/create")
	@POST
	public GastoResponse create(GastoRequest gastoRequest){	

		GastoResponse us = new GastoResponse();
		Gasto gasto = new Gasto();
		gasto.setMonto(gastoRequest.getGasto().getMonto());		
		gasto.setLugar(gastoRequest.getGasto().getLugar());
		gasto.setDescripcion(gastoRequest.getGasto().getDescripcion());
		
		Boolean state = gastoService.saveGasto(gasto);
		if(state){
			us.setCode(200);
			us.setCodeMessage(correctSaveGasto);
		}
		return us;

	}
}
