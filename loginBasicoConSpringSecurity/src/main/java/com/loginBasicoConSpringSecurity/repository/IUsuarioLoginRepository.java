package com.loginBasicoConSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginBasicoConSpringSecurity.model.Usuario;


public interface IUsuarioLoginRepository extends JpaRepository<Usuario, Integer>{

}
