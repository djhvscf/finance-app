package com.finance.financeapp.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GastoFijo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int idGastoFijo;
	
	private String nombre;
	private float monto;
	private String posibleFechaPago;
	
	public GastoFijo(){
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
