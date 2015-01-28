package com.finance.financeapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario,Integer> {

	List<TipoUsuario> findAll();
	
}
