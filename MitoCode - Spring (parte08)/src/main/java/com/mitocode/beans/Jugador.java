package com.mitocode.beans;
import com.mitocode.interfaces.IEquipo;

public class Jugador {
	
	private int numero;
	private String nombre;
	private IEquipo equipo;
	
	public Jugador() {
	}

	public Jugador(int numero, String nombre, IEquipo equipo) {
		this.numero = numero;
		this.nombre = nombre;
		this.equipo = equipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public IEquipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}


	
	
}
