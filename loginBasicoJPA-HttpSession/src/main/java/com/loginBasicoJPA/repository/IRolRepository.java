package com.loginBasicoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginBasicoJPA.model.Role;


public interface IRolRepository extends JpaRepository<Role, Integer>{

}
