package com.educacionit.jpa.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private int edad;

	/*********************************************************************************************************************
	 . ONE TO ONE - UNIDIRECCIONAL: 
	 Asocia solo una Entidad con la otra. En este caso asocia Persona a Telefono, pero no viceversa.
	 Implica que no puede existir una Persona sin Telefono asociado, pero puede existir un Telefono sin Persona. Cuando 
	 guarde una Persona, si o si se va a guardar un valor de telefono. Es decir, que cada vez que se genere un nuevo de 
	 registro de una Persona en la Tabla, se va a generar un nuevo registro en la Tabla de Telefonos y se asociara el id de 
	 dicho telefono a la tabla Personas. En este caso, puede existe un Id de Telefono que no este asociado a ninguna Persona, 
	 pero no puede existir una Persona que no tenga un Id de Telefono asociado como valor.
	 */
//	@OneToOne(cascade = CascadeType.ALL)
//	private Telefono telefono;

//	public Telefono getTelefono() {
//	return telefono;
//	}
//
//	public void setTelefono(Telefono telefono) {
//	this.telefono = telefono;
//	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************
	 . ONE TO ONE - BIDIRECCIONAL: 
	 En este caso va a ser muy similar al anterior con la diferencia que al ser una relación Bidieccional, no podrá existir un
	 Telefono que no este asociado a una Persona. Es decir, cada id de Telefono generado estará asociado a una Persona
	 y viceversa. 	 
	 Se indica que el registro de Telefono que se guarde asociado en la Tabla Persona, tambien debera estar asociado en la 
	 Tabla Telefonos a la Tabla 'persona'. 
	 */
//	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
//	private Telefono telefono;

//	public Telefono getTelefono() {
//	return telefono;
//	}
//
//	public void setTelefono(Telefono telefono) {
//	this.telefono = telefono;
//	}
	/**************************************************************************************************************************/
	/*************************************************************************************************************************
	 . ONE TO MANY / MANY TO ONE - UNIDIRECCIONAL:
	 Se indica que la Persona podra poseer de uno a muchos telefonos. Es decir, los los telefonos se van a asociar a un 
	 id_persona, para poder determinar todos los telefonos que posee un Persona, pero no se van asociar Personas a un 
	 id_telefono porque la relación es Unidireccional.
	 En este caso el ORM se encargara de generar un tabla adicional donde relacionará los id_telefono al id_persona 
	 correspondiente. Es decir, visualmente la información no va a figurar ni en la Tabla Persona ni en la Tabla Telefono,
	 pero al momento de necesitar la información el ORM utilizará la tabla adiconal generada donde relaciona los id.
	*/
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Telefono> listaTelefonos = new HashSet<Telefono>();
//	
//	public Set<Telefono> getListaTelefonos() {
//		return listaTelefonos;
//	}
//
//	public void setListaTelefonos(Set<Telefono> listaTelefonos) {
//		this.listaTelefonos = listaTelefonos;
//	}

	/**************************************************************************************************************************/
	/*************************************************************************************************************************
	 . ONE TO MANY / MANY TO ONE - BIDIRECCIONAL:
	 En este caso el ORM va a generar directamente una nueva columna 'persona_id' en la Tabla Telefonos donde
	 hara la asociacion de Telefonos con 'persona_id' correspondiente, y no	va a generar una Tabla adiconal. 
	En este caso, si puedo acceder a la Persona a través del Telefono porque es una relación Bidireccional.
	*/
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "persona_id")
	private Set<Telefono> listaTelefonos = new HashSet<Telefono>();
	
	public Set<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(Set<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	/**************************************************************************************************************************/
	/*************************************************************************************************************************
	 . MANY TO MANY - UNIDIRECCIONAL:
	 En un Many to Many Unidireccional, no se podrá cargar el mismo Domicilio a más de una persona, solamente la persona podrá 
	 tener muchos domicilios, pero no viceversa. En este caso el ORM generá una tabla 'MANY_TO_MANY', donde indicará la relación
	 entre los 'FK_PER' y 'FK_DOM'.
	*/
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "MANY_TO_MANY", joinColumns = @JoinColumn(name= "FK_PER", nullable = false),
//	inverseJoinColumns = @JoinColumn(name= "FK_DOM", nullable = false))
//	private Set<Domicilio> listaDomicilios = new HashSet<Domicilio>();
//	
//	public Set<Domicilio> getListaDomicilios() {
//		return listaDomicilios;
//	}
//
//	public void setListaDomicilios(Set<Domicilio> listaDomicilios) {
//		this.listaDomicilios = listaDomicilios;
//	}

	/**************************************************************************************************************************/
	/*************************************************************************************************************************
	 . MANY TO MANY - BIDIRECCIONAL:
	 En este caso el ORM no va a generar una tabla intermedia, 
	*/
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Domicilio> listaDomicilios = new HashSet<Domicilio>();
	
	public Set<Domicilio> getListaDomicilios() {
		return listaDomicilios;
	}

	public void setListaDomicilios(Set<Domicilio> listaDomicilios) {
		this.listaDomicilios = listaDomicilios;
	}

	/**************************************************************************************************************************/


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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", listaTelefonos=" + listaTelefonos + "]";
	}
	
	

}
