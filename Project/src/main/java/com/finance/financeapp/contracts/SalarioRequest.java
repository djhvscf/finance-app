package com.finance.financeapp.contracts;

import com.finance.financeapp.pojo.SalarioPOJO;

public class SalarioRequest extends BasePagingRequest {

	private SalarioPOJO salario;
	
	public SalarioRequest() {
		super();
	}

	/**
	 * @return the salario
	 */
	public SalarioPOJO getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(SalarioPOJO salario) {
		this.salario = salario;
	}
}
