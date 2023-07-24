package com.educacionit.jpa.entidades;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private int numero;

	// ONE TO ONE Unidireccinal => No existe el atributo Persona persona en la Clase Telefono, cuando la relacion es Unidireccional.
	
	/*****************************************************************************************************************************/
	// ONE TO ONE Bidireccional:
//	@OneToOne(mappedBy="telefono")
//	private Persona persona;
//	
//	public Persona getPersona() {
//		return persona;
//	}
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
	/*****************************************************************************************************************************/
	// ONE TO MANY / MANY TO ONE: Unidireccional => Opcion1. En este caso que no exista el atributo Persona persona en la Clase Telefono, 
	// el ORM se encargara de generar un tabla adicional donde relacionará los id_telefono al id_persona correspondiente.
	// 
	/*****************************************************************************************************************************/
	// ONE TO MANY / MANY TO ONE: Uniidireccional => Opcion2. Idem Resultado. Ademas agrega una Columna en la Tabla Telefono,
	// con valores nulos. No es recomendable esta configuración, es prefrerible la opcion1 si la relación sera Unidireccional.
//	@ManyToOne
//	private Persona persona;
//	
//	public Persona getPersona() {
//		return persona;
//	}
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
	/*****************************************************************************************************************************/
	// ONE TO MANY / MANY TO ONE: Bidireccional => 
	@ManyToOne
	@JoinColumn(name = "persona_id") 
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/*****************************************************************************************************************************/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	

}
