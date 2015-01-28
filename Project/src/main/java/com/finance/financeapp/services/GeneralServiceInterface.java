package com.finance.financeapp.services;

import java.util.List;

import com.finance.financeapp.ejb.TipoAlquiler;
import com.finance.financeapp.ejb.TipoUsuario;
import com.finance.financeapp.ejb.Usuario;

public interface GeneralServiceInterface {

	List<TipoUsuario> getAllTipoUsuario();
	TipoUsuario getTipoUsuarioById(Integer idTipoUsuario);
	List<TipoAlquiler> getAllTipoAlquiler();
	TipoAlquiler getTipoAlquilerById(Integer idTipoAlquiler);
	Usuario getUsuarioById(Integer idUser);
}
