package com.finance.financeapp.pojo;

import java.util.Date;

public class GastoFijoPOJO {

	private int idGastoFijo;
	private String nombre;
	private double monto;
	private Date posibleFechaPago;
	
	public GastoFijoPOJO() {
		super();
	}

	/**
	 * @return the idGastoFijo
	 */
	public int getIdGastoFijo() {
		return idGastoFijo;
	}

	/**
	 * @param idGastoFijo the idGastoFijo to set
	 */
	public void setIdGastoFijo(int idGastoFijo) {
		this.idGastoFijo = idGastoFijo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the posibleFechaPago
	 */
	public Date getPosibleFechaPago() {
		return posibleFechaPago;
	}

	/**
	 * @param posibleFechaPago the posibleFechaPago to set
	 */
	public void setPosibleFechaPago(Date posibleFechaPago) {
		this.posibleFechaPago = posibleFechaPago;
	}
	
}
