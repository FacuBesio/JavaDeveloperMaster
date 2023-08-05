package com.loginBasicoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginBasicoJPA.model.Usuario;


public interface IUsuarioLoginRepository extends JpaRepository<Usuario, Integer>{

}
