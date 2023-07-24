package com.educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.educacionit.jpa.entidades.Domicilio;

@Repository
public interface DomicilioDAO extends CrudRepository<Domicilio, Integer>{


}
