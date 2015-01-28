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
public class TipoUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoUsuario;

	private String tipo;
	
	@OneToMany(cascade={CascadeType.ALL},mappedBy="tipoUsuario")
	private List<Usuario> usuarios;

	public TipoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoUsuario(int idTipoUsuario, String tipo, List<Usuario> usuarios) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.tipo = tipo;
		this.usuarios = usuarios;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
