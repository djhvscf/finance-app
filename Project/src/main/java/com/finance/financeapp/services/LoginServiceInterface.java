package com.finance.financeapp.services;

import com.finance.financeapp.contracts.LoginRequest;
import com.finance.financeapp.ejb.Usuario;

public interface LoginServiceInterface {

	Usuario checkUser(LoginRequest lr);

}
