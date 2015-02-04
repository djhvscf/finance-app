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
import com.finance.financeapp.contracts.SalarioRequest;
import com.finance.financeapp.contracts.SalarioResponse;
import com.finance.financeapp.ejb.Salario;
import com.finance.financeapp.pojo.SalarioPOJO;
import com.finance.financeapp.services.SalarioServiceInterface;
import com.finance.financeapp.utils.PojoUtils;

@Component
@Path("/protected/salarios")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class SalarioController extends BaseController{

	private final String getAllCodeMessage = "Se obtuvieron los salarios correctamente";
	private final String correctSaveSalario = "Se guardó el salario correctamente";
	private final String searchFecha = "Fecha";
	
	@Autowired
	SalarioServiceInterface salarioService;
	
	@Path("/getAll")
	@POST
	@Transactional
	public SalarioResponse getAll(SalarioRequest salarioRequest){
		
		salarioRequest.setPageNumber(salarioRequest.getPageNumber() - 1);
		Page<Salario> salarios = null;
		SalarioResponse salarioResponse = new SalarioResponse();
		List<SalarioPOJO> viewSalarios = new ArrayList<SalarioPOJO>();
		List<Salario> salariosList;
		if(!salarioRequest.getSearchTerm().equals("")) {
			if(salarioRequest.getSearchColumn().equals(searchFecha)) {
				salariosList = salarioService.getByFecha(salarioRequest.getSearchTerm());
			} else {
				salariosList = salarioService.getByMonto(Float.parseFloat(salarioRequest.getSearchTerm()));
			}
			
			for (Salario salario : salariosList){
				SalarioPOJO nsalario = new SalarioPOJO();
				PojoUtils.pojoMappingUtility(nsalario,salario);
				viewSalarios.add(nsalario);
			}
		} else {
			salarios = salarioService.getAll(salarioRequest);
			for (Salario salario : salarios.getContent()){
				SalarioPOJO nsalario = new SalarioPOJO();
				PojoUtils.pojoMappingUtility(nsalario,salario);
				viewSalarios.add(nsalario);
			}
			salarioResponse.setTotalElements(salarios.getTotalElements());
			salarioResponse.setTotalPages(salarios.getTotalPages());
		}
		
		salarioResponse.setCode(successCode);
		salarioResponse.setCodeMessage(getAllCodeMessage);

		salarioResponse.setSalarios(viewSalarios);
		return salarioResponse;	
	}
	
	@Path("/save")
	@POST
	public SalarioResponse save(SalarioRequest salarioRequest){	

		SalarioResponse salarioResponse = new SalarioResponse();
		Salario salario= new Salario();
		salario.setIdSalario(salarioRequest.getSalario().getIdSalario());
		salario.setMonto(salarioRequest.getSalario().getMonto());
		salario.setFecha(getDate());
		
		if(salarioService.saveSalario(salario)){
			salarioResponse.setCode(successCode);
			salarioResponse.setCodeMessage(correctSaveSalario);
		}
		return salarioResponse;
	}
}