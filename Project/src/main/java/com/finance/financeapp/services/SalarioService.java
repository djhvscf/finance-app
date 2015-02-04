package com.finance.financeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.SalarioRequest;
import com.finance.financeapp.ejb.Salario;
import com.finance.financeapp.repositories.SalarioRepository;

@Service
public class SalarioService implements SalarioServiceInterface {

	@Autowired
	SalarioRepository salarioRepository;
	
	@Override
	@Transactional
	public Page<Salario> getAll(SalarioRequest salarioRequest) {
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(salarioRequest.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}

		if(salarioRequest.getSortBy().size() > 0){
			Sort sort = new Sort(direction,salarioRequest.getSortBy());
			pr = new PageRequest(salarioRequest.getPageNumber(),salarioRequest.getPageSize(),sort);
		}else{
			pr = new PageRequest(salarioRequest.getPageNumber(),salarioRequest.getPageSize());
		}
		
		return salarioRepository.findAll(pr);
	}

	@Override
	@Transactional
	public Boolean saveSalario(Salario salario) {
		Boolean result = true;
		
		if(salarioRepository.save(salario) == null){
			result = false;
		}
		
		return result;
	}

	@Override
	public List<Salario> getByFecha(String fecha) {
		return salarioRepository.findByFecha(fecha);
	}

	@Override
	public List<Salario> getByMonto(Float monto) {
		return salarioRepository.findByMontoBetween(monto, monto);
	}

	@Override
	public Salario getByIdSalario(int idSalario) {
		return salarioRepository.findOne(idSalario);
	}

}
