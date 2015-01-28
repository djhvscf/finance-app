package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.TipoUsuarioPOJO;

public class TipoUsuarioResponse extends BaseResponse{
	
	private List<TipoUsuarioPOJO> tipoUsuarioList;

	public TipoUsuarioResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<TipoUsuarioPOJO> getTipoUsuarioList() {
		return tipoUsuarioList;
	}

	public void setTipoUsuarioList(List<TipoUsuarioPOJO> tipoUsuarioList) {
		this.tipoUsuarioList = tipoUsuarioList;
	}
	
}
