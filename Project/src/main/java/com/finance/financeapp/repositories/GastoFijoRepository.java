package com.finance.financeapp.repositories;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.GastoFijo;

public interface GastoFijoRepository extends CrudRepository<GastoFijo, Integer> {

	public static final int PAGE_SIZE = 5;
	
	List<GastoFijo> findAll(Pageable pageable);
	List<GastoFijo> findByNombre(String nombre);
	List<GastoFijo> findByMonto(double monto);
	List<GastoFijo> findByPosibleFechaPago(Date posibleFechaPago);
	GastoFijo findOne(Integer idGastoFijo);
}