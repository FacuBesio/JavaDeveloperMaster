package com.proyectDemo.services;

import java.util.List;
import java.util.Optional;

import com.proyectDemo.model.Usuario;

public interface IUsuarioLoginService {

	Usuario create(Usuario usuario);
	Optional <Usuario> get(Integer id);
	void update(Usuario producto);
	void delete(Integer id);
	List<Usuario> findAll();
}
