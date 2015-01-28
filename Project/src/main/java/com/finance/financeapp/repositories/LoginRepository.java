package com.finance.financeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.Usuario;

public interface LoginRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Usuario findByEmailAndPassword(String email, String password);
}
