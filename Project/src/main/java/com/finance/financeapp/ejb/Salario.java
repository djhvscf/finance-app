package com.finance.financeapp.ejb;

import java.io.Serializable;
import java.util.Date;

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
	
	private Date fecha;
	private double monto;
	
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
