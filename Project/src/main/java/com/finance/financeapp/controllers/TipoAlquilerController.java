package com.finance.financeapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finance.financeapp.contracts.TipoAlquilerResponse;
import com.finance.financeapp.ejb.TipoAlquiler;
import com.finance.financeapp.pojo.TipoAlquilerPOJO;
import com.finance.financeapp.services.GeneralServiceInterface;
import com.finance.financeapp.utils.PojoUtils;


/**
 * Handles requests for the application home page.
 */
@Component
@Path("/protected/tipoAlquiler")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class TipoAlquilerController {
	
	@Autowired
	GeneralServiceInterface generalService;
	
	@Path("/getAll")
	@GET
	public TipoAlquilerResponse getAll(){
		
		TipoAlquilerResponse tar = new TipoAlquilerResponse();
		
		List<TipoAlquiler> tipoAlquilerList = generalService.getAllTipoAlquiler();
		List<TipoAlquilerPOJO> tipoAlquilerViewList = new ArrayList<TipoAlquilerPOJO>();
		
		for (TipoAlquiler ta : tipoAlquilerList){
			TipoAlquilerPOJO ntipoAlquiler = new TipoAlquilerPOJO();
			PojoUtils.pojoMappingUtility(ntipoAlquiler,ta);
			tipoAlquilerViewList.add(ntipoAlquiler);
		}
		
		tar.setTipoAlquilerList(tipoAlquilerViewList);
		
		return tar;		
	}
}
