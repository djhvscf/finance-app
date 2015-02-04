package com.finance.financeapp.pojo;


public class GastoFijoPOJO {

	private int idGastoFijo;
	private String nombre;
	private float monto;
	private String posibleFechaPago;
	
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
	public float getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}

	/**
	 * @return the posibleFechaPago
	 */
	public String getPosibleFechaPago() {
		return posibleFechaPago;
	}

	/**
	 * @param posibleFechaPago the posibleFechaPago to set
	 */
	public void setPosibleFechaPago(String posibleFechaPago) {
		this.posibleFechaPago = posibleFechaPago;
	}
	
}
