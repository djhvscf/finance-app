package com.finance.financeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.financeapp.ejb.TipoAlquiler;
import com.finance.financeapp.ejb.TipoUsuario;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.repositories.GeneralRepository;
import com.finance.financeapp.repositories.TipoAlquilerRepository;
import com.finance.financeapp.repositories.TipoUsuarioRepository;
import com.finance.financeapp.repositories.UsersRepository;

@Service
public class GeneralService implements GeneralServiceInterface{		
	
	@Autowired
	GeneralRepository generalRepository;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	TipoAlquilerRepository tipoAlquilerRepository;

	@Autowired
	UsersRepository userRepository;
	
	@Override
	public List<TipoUsuario> getAllTipoUsuario() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public TipoUsuario getTipoUsuarioById(Integer idTipoUsuario) {
		return tipoUsuarioRepository.findOne(idTipoUsuario);
	}

	@Override
	public List<TipoAlquiler> getAllTipoAlquiler() {
		return tipoAlquilerRepository.findAll();
	}
	
	@Override
	public TipoAlquiler getTipoAlquilerById(Integer idTipoAlquiler) {
		return tipoAlquilerRepository.findOne(idTipoAlquiler);
	}

	@Override
	public Usuario getUsuarioById(Integer idUser) {
		return userRepository.findOne(idUser);
	}

	/*@Override
	public Usuario getUsuarioById(Integer idUser) {
		return usersRepository.findOne(idUser);
	}*/
	
}