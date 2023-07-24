package com.mitocode.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mitocode.mvc.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
/* 
A través de interfaz JpaRepository <CLASE, ID> vamos a heredar todos lo métodos de CRUD  que JPA generá 
automaticamente. Es decir, indicando entre los <> la Entidad con la que vamos a trabajar y su clave primaria, 
JPA generará automaticamente todos los métodos de CRUD para poder persistir nuestros objetos Java en la base 
de datos. 
Para hacer un poco más ordenado el trabajo y escalable, se suele encapsular los métodos heredados en otra capa 
llamada Service para su posterior utilizacion desde una aplicación principal. Es decir, en la capa Service se 
desarrolla un lógica de como consumir los métodos de JPA, y desde la aplicación principal se trabaja 
directamente con la capa Service. 
*/