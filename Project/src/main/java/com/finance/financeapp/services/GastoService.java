package com.finance.financeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.GastoRequest;
import com.finance.financeapp.ejb.Gasto;
import com.finance.financeapp.repositories.GastoRepository;

@Service
public class GastoService implements GastoServiceInterface {

	@Autowired
	GastoRepository gastoRepository;
	
	@Override
	@Transactional
	public Page<Gasto> getAll(GastoRequest gastoRequest) {
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(gastoRequest.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(gastoRequest.getSortBy().size() > 0){
			Sort sort = new Sort(direction,gastoRequest.getSortBy());
			pr = new PageRequest(gastoRequest.getPageNumber(),gastoRequest.getPageSize(),sort);
		}else{
			pr = new PageRequest(gastoRequest.getPageNumber(),gastoRequest.getPageSize());
		}
		
		return gastoRepository.findAll(pr);
	}

	@Override
	@Transactional
	public Boolean saveGasto(Gasto gasto) {
		Boolean result = true;
		if(gastoRepository.save(gasto) == null){
			result = false;
		}
		return result;
	}

	@Override
	public List<Gasto> getByMonto(double monto) {
		return gastoRepository.findByMonto(monto);
	}

	@Override
	public List<Gasto> getByLugar(String lugar) {
		return gastoRepository.findByLugarContaining(lugar);
	}

	@Override
	public List<Gasto> getByFecha(String fecha) {
		return gastoRepository.findByFecha(fecha);
	}

	@Override
	public Gasto getByIdGasto(int idGasto) {
		return gastoRepository.findOne(idGasto);
	}
}
