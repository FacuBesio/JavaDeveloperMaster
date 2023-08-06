package com.proyectDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectDemo.model.Usuario;


public interface IUsuarioLoginRepository extends JpaRepository<Usuario, Integer>{

}
