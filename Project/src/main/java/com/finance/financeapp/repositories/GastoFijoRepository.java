package com.finance.financeapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.GastoFijo;

public interface GastoFijoRepository extends CrudRepository<GastoFijo, Integer> {

	public static final int PAGE_SIZE = 5;
	
	Page<GastoFijo> findAll(Pageable pageable);
	List<GastoFijo> findByNombre(String nombre);
	List<GastoFijo> findByMonto(double monto);
	List<GastoFijo> findByPosibleFechaPago(String posibleFechaPago);
	GastoFijo findOne(Integer idGastoFijo);
}