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

import com.finance.financeapp.contracts.GastoFijoRequest;
import com.finance.financeapp.contracts.GastoFijoResponse;
import com.finance.financeapp.ejb.GastoFijo;
import com.finance.financeapp.pojo.GastoFijoPOJO;
import com.finance.financeapp.services.GastoFijoServiceInterface;
import com.finance.financeapp.utils.PojoUtils;

@Component
@Path("/protected/gastosFijos")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class GastoFijoController extends BaseController{

	private final String getAllCodeMessage = "Se obtuvieron los gastos fijos correctamente";
	private final String correctSaveGasto = "Se guardó el gasto fijo correctamente";
	
	@Autowired
	GastoFijoServiceInterface gastoFijoService;
	
	@Path("/getAll")
	@POST
	@Transactional
	public GastoFijoResponse getAll(GastoFijoRequest gastoFijoRequest){
		
		gastoFijoRequest.setPageNumber(gastoFijoRequest.getPageNumber() - 1);
		Page<GastoFijo> gastosFijos = gastoFijoService.getAll(gastoFijoRequest);

		GastoFijoResponse gastoFijoResponse = new GastoFijoResponse();

		gastoFijoResponse.setCode(successCode);
		gastoFijoResponse.setCodeMessage(getAllCodeMessage);
		gastoFijoResponse.setTotalElements(gastosFijos.getTotalElements());
		gastoFijoResponse.setTotalPages(gastosFijos.getTotalPages());

		List<GastoFijoPOJO> viewGastosFijos = new ArrayList<GastoFijoPOJO>();
		for (GastoFijo gasto : gastosFijos.getContent()){
			GastoFijoPOJO ngastoFijo = new GastoFijoPOJO();
			PojoUtils.pojoMappingUtility(ngastoFijo,gasto);
			viewGastosFijos.add(ngastoFijo);
		}

		gastoFijoResponse.setGastosFijos(viewGastosFijos);
		return gastoFijoResponse;	
	}
	
	@Path("/save")
	@POST
	public GastoFijoResponse save(GastoFijoRequest gastoFijoRequest){	

		GastoFijoResponse gastoFijoResponse = new GastoFijoResponse();
		GastoFijo gastoFijo = new GastoFijo();
		gastoFijo.setIdGastoFijo(gastoFijoRequest.getGastoFijo().getIdGastoFijo());
		gastoFijo.setMonto(gastoFijoRequest.getGastoFijo().getMonto());		
		gastoFijo.setNombre(gastoFijoRequest.getGastoFijo().getNombre());
		gastoFijo.setPosibleFechaPago(gastoFijoRequest.getGastoFijo().getPosibleFechaPago());
		
		if(gastoFijoService.saveGastoFijo(gastoFijo)){
			gastoFijoResponse.setCode(successCode);
			gastoFijoResponse.setCodeMessage(correctSaveGasto);
		}
		return gastoFijoResponse;
	}
}