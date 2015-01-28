package com.finance.financeapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.TipoAlquiler;

public interface TipoAlquilerRepository extends CrudRepository<TipoAlquiler,Integer> {

	List<TipoAlquiler> findAll();
	
}
