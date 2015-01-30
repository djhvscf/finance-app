package com.finance.financeapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.Salario;

public interface SalarioRepository extends CrudRepository<Salario,Integer> {

	public static final int PAGE_SIZE = 5;
	
	Page<Salario> findAll(Pageable pageable);
	List<Salario> findByMonto (double monto);
	List<Salario> findByFecha (Date fecha);
	
	Salario findOne(Integer idSalario);
}
