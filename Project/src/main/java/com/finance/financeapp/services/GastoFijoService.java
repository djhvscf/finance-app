package com.finance.financeapp.services;

import java.util.Date;
import java.util.List;

import com.finance.financeapp.contracts.GastoFijoRequest;
import com.finance.financeapp.ejb.GastoFijo;
import com.finance.financeapp.repositories.GastoFijoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GastoFijoService implements GastoFijoServiceInterface {

	@Autowired
	GastoFijoRepository gastoFijoRepository;
	
	@Override
	@Transactional
	public List<GastoFijo> getAll(GastoFijoRequest gastoFijoRequest) {
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(gastoFijoRequest.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(gastoFijoRequest.getSortBy().size() > 0){
			Sort sort = new Sort(direction,gastoFijoRequest.getSortBy());
			pr = new PageRequest(gastoFijoRequest.getPageNumber(),gastoFijoRequest.getPageSize(),sort);
		}else{
			pr = new PageRequest(gastoFijoRequest.getPageNumber(),gastoFijoRequest.getPageSize());
		}
		
		return gastoFijoRepository.findAll(pr);
	}

	@Override
	@Transactional
	public Boolean saveGastoFijo(GastoFijo gastoFijo) {
		Boolean result = true;
		
		if(gastoFijoRepository.save(gastoFijo) == null) {
			result = false;
		}
		return result;
	}

	@Override
	public List<GastoFijo> getByNombre(String nombre) {
		return gastoFijoRepository.findByNombre(nombre);
	}

	@Override
	public List<GastoFijo> getByMonto(double monto) {
		return gastoFijoRepository.findByMonto(monto);
	}

	@Override
	public List<GastoFijo> getByPosibleFechaPago(Date fecha) {
		return gastoFijoRepository.findByPosibleFechaPago(fecha);
	}

	@Override
	public GastoFijo getByIdGastoFijo(int idGastoFijo) {
		return gastoFijoRepository.findOne(idGastoFijo);
	}
}