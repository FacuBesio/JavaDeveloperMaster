package com.educacionit.jpa.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Domicilio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String calle;
	private int numero;
	
	/*****************************************************************************************************************************/
	// MANY TO MANY: Unidireccional => Opcion1. No existe el atributo Persona persona en la Clase Domicilio, cuando la relacion 
	// es Unidireccional.
	/*****************************************************************************************************************************/
	/*****************************************************************************************************************************/
	// MANY TO MANY: Unidireccional => Opcion2. Idem Resultado. Ademas agrega una Columna en la Tabla domicilio_personas,
	// con valores nulos. No es recomendable esta configuración, es prefrerible la opcion1 si la relación sera Unidireccional.
//	@ManyToMany
//	private Set<Persona> personas = new HashSet<Persona>();
//	
//	public Set<Persona> getListaPersonas() {
//		return personas;
//	}
//	public void setListaPersonas(Set<Persona> listaPersonas) {
//		this.personas = listaPersonas;
//	}
	/*****************************************************************************************************************************/
	// MANY TO MANY: Bidireccional => Opcion1.
	// 
//	@ManyToMany(mappedBy = "listaDomicilios", fetch = FetchType.EAGER)
//	private Set<Persona> personas = new HashSet<Persona>();
//	
//	public Set<Persona> getListaPersonas() {
//		return personas;
//	}
//	public void setListaPersonas(Set<Persona> listaPersonas) {
//		this.personas = listaPersonas;
//	}
	/*****************************************************************************************************************************/
	// MANY TO MANY: Bidireccional => Opcion2.
	// 
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<Persona> personas = new HashSet<Persona>();
//	
//	public Set<Persona> getListaPersonas() {
//		return personas;
//	}
//	public void setListaPersonas(Set<Persona> listaPersonas) {
//		this.personas = listaPersonas;
//	}
	/*****************************************************************************************************************************/
	// MANY TO MANY: Bidireccional => Opcion3.
		 
	@ManyToMany(mappedBy = "listaDomicilios", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Persona> personas = new HashSet<Persona>();
	
	public Set<Persona> getListaPersonas() {
		return personas;
	}
	public void setListaPersonas(Set<Persona> listaPersonas) {
		this.personas = listaPersonas;
	}
		/*****************************************************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	
}
