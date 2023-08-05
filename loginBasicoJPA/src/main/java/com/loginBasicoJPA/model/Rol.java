package com.loginBasicoJPA.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id_rol")
	private int id;
	private String nombreRol;
	private String descripcion;
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuario;
	
	
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Rol() {
	}

	public Rol(int id, String nombreRol, String descripcion, List<Usuario> listaUsuario) {
		this.id = id;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
		this.listaUsuario = listaUsuario;
	}

	@Override
	public String toString() {
		return nombreRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
