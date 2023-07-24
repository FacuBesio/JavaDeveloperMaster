package com.educacionit.jpa.entidades.herencia2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Empleado2 extends Persona2 {
	private Double sueldo;
	private String legajo;
	
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

}
