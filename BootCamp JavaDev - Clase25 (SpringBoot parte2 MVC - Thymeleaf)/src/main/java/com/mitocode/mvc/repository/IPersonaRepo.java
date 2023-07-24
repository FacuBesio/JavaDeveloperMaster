package com.mitocode.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mitocode.mvc.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
/* 
A trav�s de interfaz JpaRepository <CLASE, ID> vamos a heredar todos lo m�todos de CRUD  que JPA gener� 
automaticamente. Es decir, indicando entre los <> la Entidad con la que vamos a trabajar y su clave primaria, 
JPA generar� automaticamente todos los m�todos de CRUD para poder persistir nuestros objetos Java en la base 
de datos. 
Para hacer un poco m�s ordenado el trabajo y escalable, se suele encapsular los m�todos heredados en otra capa 
llamada Service para su posterior utilizacion desde una aplicaci�n principal. Es decir, en la capa Service se 
desarrolla un l�gica de como consumir los m�todos de JPA, y desde la aplicaci�n principal se trabaja 
directamente con la capa Service. 
*/