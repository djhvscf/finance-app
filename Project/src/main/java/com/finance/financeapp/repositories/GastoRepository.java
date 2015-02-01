package com.finance.financeapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.Gasto;

public interface GastoRepository extends CrudRepository<Gasto,Integer>  {

	public static final int PAGE_SIZE = 5;
	
	Page<Gasto> findAll(Pageable pageable);
	List<Gasto> findByMonto(double monto);
	List<Gasto> findByLugarContaining(String lugar);
	List<Gasto> findByFecha(String fecha);
	Gasto findOne(Integer idGasto);
}