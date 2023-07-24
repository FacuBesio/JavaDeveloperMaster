package com.educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.jpa.entidades.Persona;

// Tambien generalmente se escribe como PersonaRepository y el paquete educacionit.jpa.dao.

@Repository // Indica que la interface representa un Repositorio.
public interface PersonaDAO extends CrudRepository<Persona, Integer>{
	
	/* 
	A través de interfaz CrudRepository <CLASE, ID> vamos a heredar todos lo métodos de CRUD para operar
	desde Java hacia a la base de datos. Nuestro ORM se encargará de generar el codigo correspondiente
	de forma automática. Simplemente indicando CrudRepository <Entidad, ClavePrimaria>, es decir la Clase Java 
	declarada como Entidad y el tipo de dato del atributo declarado como Clave Primaria. Es importante recordar 
	que no se podràn utlizar tipos de datos primitivo como int, en su lugar habrá que utilizar su equivalente en 
	wrapper Integer. La idea justamente que propone el ORM es concentar todos los métodos básicos mas utilizados
	para operar contra una base de datos, y realizarlos de una forma automatica. 
	CrudRepository es la Interfaces que hereda directamente de Repository y es la mas básica. En esta interfaz
	como su nombre lo indica vamos a entoncontrar los métodos CRUD disponibles para acceder a la base de datos
	desde Java. A su vez tambien existe una Interfaz llamada 'PagingAndSortingRepository' que hereda de 
	CrudRepository y agrega mas funcionadades relacionadas a poder organizar la información que devuelve nuestra
	base de datos al momento de realizar consultas. Y tambien a su vez existe otra Interfaz llamada 'JpaRepository'
	que extiende de 'PagingAndSortingRepository', y está agrega aun mas funcionalidades. Es decir, extender de 
	'JpaRepository' nos asegura tener acceso todas funcionalidades que nos ofrece JPA, es la opcion mas completa.
	Todas las interfaces solamente necesitan que se declare la Entendidad y el tipo de dato de la Clave Primaria
	para su funcionamiento. 
	
	Es decir, indicando entre los <> la Entidad con la que vamos a trabajar y su clave primaria, 
	JPA generará automaticamente todos los métodos de CRUD para poder persistir nuestros objetos Java en la base 
	de datos. 
	Para hacer un poco más ordenado el trabajo y escalable, se suele encapsular los métodos heredados en otra capa 
	llamada Service para su posterior utilizacion desde una aplicación principal. Es decir, en la capa Service se 
	desarrolla un lógica de como consumir los métodos de JPA, y desde la aplicación principal se trabaja 
	directamente con la capa Service. 
	*/


}
