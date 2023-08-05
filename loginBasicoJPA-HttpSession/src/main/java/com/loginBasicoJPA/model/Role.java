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
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id_rol")
	private int id;
	private String nombreRole;
	private String descripcion;
	@OneToMany(mappedBy = "role")
	private List<Usuario> listaUsuario;
	
	
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Role() {
	}

	public Role(int id, String nombreRole, String descripcion, List<Usuario> listaUsuario) {
		this.id = id;
		this.nombreRole = nombreRole;
		this.descripcion = descripcion;
		this.listaUsuario = listaUsuario;
	}



	@Override
	public String toString() {
		return nombreRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRole() {
		return nombreRole;
	}

	public void setNombreRole(String nombreRole) {
		this.nombreRole = nombreRole;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
