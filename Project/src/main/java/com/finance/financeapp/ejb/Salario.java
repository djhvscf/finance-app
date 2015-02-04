package com.finance.financeapp.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int idSalario;
	
	private String fecha;
	private float monto;
	
	public Salario() {
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
	public float getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}
}
