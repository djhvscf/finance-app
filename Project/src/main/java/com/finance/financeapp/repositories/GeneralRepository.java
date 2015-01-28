package com.finance.financeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.TipoUsuario;

public interface GeneralRepository extends CrudRepository<TipoUsuario,Integer> {
	
	public static final int PAGE_SIZE = 5;
}
