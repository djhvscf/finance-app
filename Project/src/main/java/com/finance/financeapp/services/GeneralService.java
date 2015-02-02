package com.finance.financeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.repositories.UsersRepository;

@Service
public class GeneralService implements GeneralServiceInterface{		

	@Autowired
	UsersRepository userRepository;
	
	@Override
	public Usuario getUsuarioById(Integer idUser) {
		return userRepository.findOne(idUser);
	}	
}