package com.finance.financeapp.services;

import org.springframework.data.domain.Page;

import com.finance.financeapp.contracts.UsersRequest;
import com.finance.financeapp.ejb.Usuario;

public interface UsersServiceInterface {

	Page<Usuario> getAll(UsersRequest ur);

	Boolean saveUser(Usuario user);

	Usuario getSessionUser(int idUser);

}
