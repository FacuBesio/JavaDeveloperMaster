package com.educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.jpa.entidades.Persona;

// Tambien generalmente se escribe como PersonaRepository y el paquete educacionit.jpa.dao.

@Repository // Indica que la interface representa un Repositorio.
public interface PersonaDAO extends CrudRepository<Persona, Integer>{
	
	/* 
	A trav�s de interfaz CrudRepository <CLASE, ID> vamos a heredar todos lo m�todos de CRUD para operar
	desde Java hacia a la base de datos. Nuestro ORM se encargar� de generar el codigo correspondiente
	de forma autom�tica. Simplemente indicando CrudRepository <Entidad, ClavePrimaria>, es decir la Clase Java 
	declarada como Entidad y el tipo de dato del atributo declarado como Clave Primaria. Es importante recordar 
	que no se podr�n utlizar tipos de datos primitivo como int, en su lugar habr� que utilizar su equivalente en 
	wrapper Integer. La idea justamente que propone el ORM es concentar todos los m�todos b�sicos mas utilizados
	para operar contra una base de datos, y realizarlos de una forma automatica. 
	CrudRepository es la Interfaces que hereda directamente de Repository y es la mas b�sica. En esta interfaz
	como su nombre lo indica vamos a entoncontrar los m�todos CRUD disponibles para acceder a la base de datos
	desde Java. A su vez tambien existe una Interfaz llamada 'PagingAndSortingRepository' que hereda de 
	CrudRepository y agrega mas funcionadades relacionadas a poder organizar la informaci�n que devuelve nuestra
	base de datos al momento de realizar consultas. Y tambien a su vez existe otra Interfaz llamada 'JpaRepository'
	que extiende de 'PagingAndSortingRepository', y est� agrega aun mas funcionalidades. Es decir, extender de 
	'JpaRepository' nos asegura tener acceso todas funcionalidades que nos ofrece JPA, es la opcion mas completa.
	Todas las interfaces solamente necesitan que se declare la Entendidad y el tipo de dato de la Clave Primaria
	para su funcionamiento. 
	
	Es decir, indicando entre los <> la Entidad con la que vamos a trabajar y su clave primaria, 
	JPA generar� automaticamente todos los m�todos de CRUD para poder persistir nuestros objetos Java en la base 
	de datos. 
	Para hacer un poco m�s ordenado el trabajo y escalable, se suele encapsular los m�todos heredados en otra capa 
	llamada Service para su posterior utilizacion desde una aplicaci�n principal. Es decir, en la capa Service se 
	desarrolla un l�gica de como consumir los m�todos de JPA, y desde la aplicaci�n principal se trabaja 
	directamente con la capa Service. 
	*/


}
