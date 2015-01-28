package com.finance.financeapp.ejb;

import java.io.Serializable;
import java.util.Date;

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
	private double monto;
	private Date posibleFechaPago;
	
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
