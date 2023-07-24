package com.educacionit.jpa.entidades.herencia2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.TableGenerator;


/*n el de caso de utilizar 'strategy = GenerationType.TABLE' la estrategia va a realizar las asociaciones en una Tabla 
llamada 'per2Gen' y se deberá definir un @TableGenerator.
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona2 {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // En este caso la estrategia va asociar por 'id' directamente.
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "per2Gen") 
//	@TableGenerator(
//					name = "per2Gen",
//					table = "persona2Generador", 
//					allocationSize = 1)
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
