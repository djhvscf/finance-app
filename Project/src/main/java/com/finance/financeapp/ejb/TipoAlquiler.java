package com.finance.financeapp.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoAlquiler implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoAlquiler;

	private String tipo;
	
	@OneToMany(cascade={CascadeType.ALL},mappedBy="tipoAlquiler")
	private List<Alquiler> alquileres;

	public TipoAlquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoAlquiler(int idTipoAlquiler, String tipo,
			List<Alquiler> alquileres) {
		super();
		this.idTipoAlquiler = idTipoAlquiler;
		this.tipo = tipo;
		this.alquileres = alquileres;
	}

	public int getIdTipoAlquiler() {
		return idTipoAlquiler;
	}

	public void setIdTipoAlquiler(int idTipoAlquiler) {
		this.idTipoAlquiler = idTipoAlquiler;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
}
