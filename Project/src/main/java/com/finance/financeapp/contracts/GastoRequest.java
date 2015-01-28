package com.finance.financeapp.contracts;

import com.finance.financeapp.pojo.GastoPOJO;

public class GastoRequest extends BasePagingRequest {

	private GastoPOJO gasto;
	
	public GastoRequest() {
		super();
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
