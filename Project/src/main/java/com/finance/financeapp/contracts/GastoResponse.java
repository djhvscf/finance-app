package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.GastoPOJO;

public class GastoResponse extends BaseResponse {

	private List<GastoPOJO> gastos;
	private GastoPOJO gasto;
	
	public GastoResponse() {
		super();
	}

	/**
	 * @return the gastos
	 */
	public List<GastoPOJO> getGastos() {
		return gastos;
	}

	/**
	 * @param gastos the gastos to set
	 */
	public void setGastos(List<GastoPOJO> gastos) {
		this.gastos = gastos;
	}

	/**
	 * @return the gasto
	 */
	public GastoPOJO getGasto() {
		return gasto;
	}

	/**
	 * @param gasto the gasto to set
	 */
	public void setGasto(GastoPOJO gasto) {
		this.gasto = gasto;
	}
}
