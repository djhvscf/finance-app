package com.finance.financeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.LoginRequest;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.repositories.LoginRepository;

@Service
public class LoginService implements LoginServiceInterface{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	@Transactional
	public Usuario checkUser(LoginRequest lr) {
		return loginRepository.findByEmailAndPassword(lr.getEmail(), lr.getPassword());
	}		
}