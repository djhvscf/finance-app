package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.GastoFijoPOJO;

public class GastoFijoResponse extends BaseResponse {

	private List<GastoFijoPOJO> gastosFijos;
	private GastoFijoPOJO gastoFijo;
	
	public GastoFijoResponse() {
		super();
	}

	/**
	 * @return the gastosFijos
	 */
	public List<GastoFijoPOJO> getGastosFijos() {
		return gastosFijos;
	}

	/**
	 * @param gastosFijos the gastosFijos to set
	 */
	public void setGastosFijos(List<GastoFijoPOJO> gastosFijos) {
		this.gastosFijos = gastosFijos;
	}

	/**
	 * @return the gastoFijo
	 */
	public GastoFijoPOJO getGastoFijo() {
		return gastoFijo;
	}

	/**
	 * @param gastoFijo the gastoFijo to set
	 */
	public void setGastoFijo(GastoFijoPOJO gastoFijo) {
		this.gastoFijo = gastoFijo;
	}
	
	
}
