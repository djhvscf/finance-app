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
	private final String correctSaveSalario = "Se guard� el salario correctamente";
	
	@Autowired
	SalarioServiceInterface salarioService;
	
	@Path("/getAll")
	@POST
	@Transactional
	public SalarioResponse getAll(SalarioRequest salarioRequest){
		
		salarioRequest.setPageNumber(salarioRequest.getPageNumber() - 1);
		Page<Salario> salarios = salarioService.getAll(salarioRequest);

		SalarioResponse salarioResponse = new SalarioResponse();

		salarioResponse.setCode(successCode);
		salarioResponse.setCodeMessage(getAllCodeMessage);
		salarioResponse.setTotalElements(salarios.getTotalElements());
		salarioResponse.setTotalPages(salarios.getTotalPages());

		List<SalarioPOJO> viewSalarios = new ArrayList<SalarioPOJO>();
		for (Salario salario : salarios.getContent()){
			SalarioPOJO nsalario = new SalarioPOJO();
			PojoUtils.pojoMappingUtility(nsalario,salario);
			viewSalarios.add(nsalario);
		}

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