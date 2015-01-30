package com.finance.financeapp.pojo;


public class SalarioPOJO {

	private int idSalario;
	private String fecha;
	private Float monto;
	
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
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the monto
	 */
	public Float getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Float monto) {
		this.monto = monto;
	}
}
