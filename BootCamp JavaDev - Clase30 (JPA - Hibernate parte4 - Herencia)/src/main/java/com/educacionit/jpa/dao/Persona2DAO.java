package com.educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.educacionit.jpa.entidades.herencia2.Persona2;

@Repository
public interface Persona2DAO extends CrudRepository<Persona2, Integer>{
}
