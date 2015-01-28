package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.TipoAlquilerPOJO;

public class TipoAlquilerResponse extends BaseResponse{
	
	private List<TipoAlquilerPOJO> tipoAlquilerList;

	public TipoAlquilerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<TipoAlquilerPOJO> getTipoAlquilerList() {
		return tipoAlquilerList;
	}

	public void setTipoAlquilerList(List<TipoAlquilerPOJO> tipoAlquilerList) {
		this.tipoAlquilerList = tipoAlquilerList;
	}
	
}
