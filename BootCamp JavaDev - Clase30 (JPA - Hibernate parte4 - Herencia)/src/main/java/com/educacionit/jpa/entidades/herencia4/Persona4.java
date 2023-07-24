package com.educacionit.jpa.entidades.herencia4;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
/* Es muy similar a TABLE_PER_CLASS con la diferencia, que colocando solamente la anotacion @MappedSuperclass, 
no es necesario ingresar las anotaciones @Entity ni @Inheritance. Como en la estrategia TABLE_PER_CLASS, 
la Clase debe ser abstracta. En este caso los id generados en cada Tabla tendra cada uno su sencuencia
independiente, a difenrencia de los casos anteriores donde la secuencia de los id generados era compartido
por ambas Tablas.  */
@MappedSuperclass
public abstract class Persona4 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
