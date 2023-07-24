package com.mitocode.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mitocode.mvc.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}
