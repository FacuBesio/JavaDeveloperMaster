package com.mitocode.beans2;

public class Persona2 {
	
	private int id;
	private String nombre;
	private String apodo;
	private Pais pais;
	
	
	
	public Persona2() {
	
	}

	public Persona2(int id, String nombre, String apodo, Pais pais) {
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.pais = pais;
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

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
