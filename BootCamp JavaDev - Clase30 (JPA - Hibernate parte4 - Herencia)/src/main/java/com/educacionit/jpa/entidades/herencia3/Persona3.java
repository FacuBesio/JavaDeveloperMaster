package com.educacionit.jpa.entidades.herencia3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.TableGenerator;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Para esta estrategia es importante recordar que la Clase Padre de ser abstracta.
public abstract class Persona3 {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "per3Gen")
	@TableGenerator(
					name = "per3Gen",
					table = "persona3Generador", 
					allocationSize = 1)
	private Integer id;
	private String nombre;
	private String apellido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
