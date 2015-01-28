package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.UsuarioPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UsuarioPOJO> usuarios;
	private UsuarioPOJO usuario;

	public UsersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioPOJO getUsuario()
	{
		return usuario;
	}
	
	public void setUsuario(UsuarioPOJO user)
	{
		this.usuario = user;
	}

}
