package com.finance.financeapp.contracts;

import java.util.List;

import com.finance.financeapp.pojo.SalarioPOJO;

public class SalarioResponse extends BaseResponse {

	private List<SalarioPOJO> salarios;
	private SalarioPOJO salario;
	
	public SalarioResponse() {
		super();
	}

	/**
	 * @return the salarios
	 */
	public List<SalarioPOJO> getSalarios() {
		return salarios;
	}

	/**
	 * @param salarios the salarios to set
	 */
	public void setSalarios(List<SalarioPOJO> salarios) {
		this.salarios = salarios;
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
