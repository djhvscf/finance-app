package com.finance.financeapp.pojo;


public class GastoPOJO {
	
	private int idGasto;
	private String lugar;
	private double monto;
	private String descripcion;
	private String fecha;

	public GastoPOJO() {
		super();
	}

	/**
	 * @return the idGasto
	 */
	public int getIdGasto() {
		return idGasto;
	}

	/**
	 * @param idGasto the idGasto to set
	 */
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
}
