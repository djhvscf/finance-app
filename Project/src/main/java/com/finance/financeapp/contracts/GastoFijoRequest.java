package com.finance.financeapp.contracts;

import com.finance.financeapp.pojo.GastoFijoPOJO;

public class GastoFijoRequest extends BasePagingRequest {

	private GastoFijoPOJO gastoFijo;
	
	public GastoFijoRequest() {
		super();
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
