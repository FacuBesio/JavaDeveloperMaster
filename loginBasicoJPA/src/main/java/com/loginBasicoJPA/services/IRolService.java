package com.loginBasicoJPA.services;

import java.util.List;
import java.util.Optional;

import com.loginBasicoJPA.model.Rol;

public interface IRolService {

	Rol create(Rol rol);
	Optional <Rol> get(Integer id);
	void update(Rol rol);
	void delete(Integer id);
	List<Rol> findAll();
}
