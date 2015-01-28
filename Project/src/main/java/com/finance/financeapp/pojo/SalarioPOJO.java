package com.finance.financeapp.pojo;

import java.util.Date;

public class SalarioPOJO {

	private int idSalario;
	private Date fecha;
	private double monto;
	
	public SalarioPOJO() {
		super();
	}

	/**
	 * @return the idSalario
	 */
	public int getIdSalario() {
		return idSalario;
	}

	/**
	 * @param idSalario the idSalario to set
	 */
	public void setIdSalario(int idSalario) {
		this.idSalario = idSalario;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
}
