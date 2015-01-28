package com.finance.financeapp.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Alquiler implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlquiler;
	
	private String name;
	private String description;
	private String image;
	
	//RELATIONSHIPS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TipoAlquiler_idTipoAlquiler")
	private TipoAlquiler tipoAlquiler;
	
	@ManyToMany(mappedBy="alquileres")
	private List<Usuario> usuarios;

	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public TipoAlquiler getTipoAlquiler() {
		return tipoAlquiler;
	}

	public void setTipoAlquiler(TipoAlquiler tipoAlquiler) {
		this.tipoAlquiler = tipoAlquiler;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
