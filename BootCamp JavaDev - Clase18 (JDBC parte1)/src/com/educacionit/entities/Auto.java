/*
 � VO:
   ��
 Al utilizar este tipo de Clases aplicamos el patron Value Object, anteriormente conocido como DTO (Data transfer Obejct). En 
 En este modelo representamos las Tablas de la Base de Datos mediante Entidades (Clases). Es decir, que cada Tabla de la Base 
 de Datos tendra su Entendidad que la respresente en Java.  
 El objetivo de este Patron es transportar la informaci�n. Ayuda a evitar que se envien una gran cantidad de parametros cuando queremos
 realizar una registro o una actualizaci�n.
 
 
 
 *
 B�sicamente con la informaci�n de la Base de Datos, se crea un Objeto en
 Java y se opera con el mismo con todas las cualidades de trabajar en Objetos. Una vez finalizado el proceso, se guarda en la Base de 
 Datos toda la informaci�n necesaria para volver a crear ese Objeto cuando sea necesario, y se destruye el Objeto a nivel Memoria. 
 *
 
  DAO
  
  Cuando utilizamos estas Clases estamos aplicando un patron Data Access 
Object. B�sicamente este patron consiste en centralizar los procesos de
acceso a la Base de Datos evitando inconsistencias y posibles problem�ticas
cuando esto se realiza a lo largo de la app. 
Con este patron independizamos la l�gica de negocio de la l�gica de acceso a datos, 
obteniendo mayor organizaci�n y flexibilidad en nuestro sistema
  */

package com.educacionit.entities;

public class Auto {
	

	private int id_auto; //id_auto INT NOT NULL AUTO_INCREMENT,		
	private String marca; //marca VARCHAR (50),
	private String modelo;//modelo VARCHAR (50),
	private String color; //color VARCHAR (50),
	private String patente; //patente VARCHAR (50) NOT NULL,
	
	
	public Auto() {
	}
	
	public Auto(String marca, String modelo, String color, String patente) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.patente = patente;
	}
	
	public Auto(int id_auto, String marca, String modelo, String color, String patente) {
		this.id_auto = id_auto;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.patente = patente;
	}
	
	
	@Override
	public String toString() {
		return "Auto [id_auto=" + id_auto + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", patente=" + patente + "]";
	}

	public int getId_auto() {
		return id_auto;
	}

	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	
}
