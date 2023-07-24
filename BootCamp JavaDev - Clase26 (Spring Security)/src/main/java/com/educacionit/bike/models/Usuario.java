package com.educacionit.bike.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/* Esta Tabla representará a los usuarios y sus respectivas claves. */
@Entity
public class Usuario {
	
	@Id
	private int id;
	private String nombre;
	private String clave;
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
