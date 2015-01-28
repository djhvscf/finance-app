package com.finance.financeapp.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	@Transient
	private Integer idTipoUsuario;
	
	//RELATIONSHIPS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TipoUsuario_idTipoUsuario")
	private TipoUsuario tipoUsuario;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name="Usuario_has_Alquiler"
		, joinColumns={
			@JoinColumn(name="Usuario_idUsuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Alquiler_idAlquiler")
			}
		)
	private List<Alquiler> alquileres;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String firstname, String lastname,
			String email, String password, TipoUsuario tipoUsuario,
			List<Alquiler> alquileres) {
		super();
		this.idUsuario = idUsuario;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.alquileres = alquileres;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public Integer getIdTipoUsuario() {
		return 0;//this.tipoUsuario.getIdTipoUsuario();
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	
}
