package com.educacionit.jpa.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// La base de datos se declara en el archivo 'application.properties' generalmente ubicado en la carpeta .../src/main/resources.
@Entity // Indica que esta Clase reprenseta una entidad en la base de datos. Es decir, esta Clase representa una Tabla en la BBDD.
public class Producto {

	@Id // Indica cual es clave primaria de la entidad. Es decir, que atributo deberá conciderar como Clave Primaria.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indica la estrategia de generación de Id. En este caso, automatica incremental.
	private Integer id;
	private String descripcion;
	private Double precio;
	private Date fechaAlta;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
