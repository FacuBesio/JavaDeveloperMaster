package com.educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.jpa.entidades.Persona;
@Repository
public interface PersonaDAO extends CrudRepository<Persona, Integer>{


}
