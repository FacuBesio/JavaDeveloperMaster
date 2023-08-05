package com.loginBasicoJPA.services;

import java.util.List;
import java.util.Optional;

import com.loginBasicoJPA.model.Usuario;

public interface IUsuarioLoginService {

	Usuario create(Usuario usuario);
	Optional <Usuario> get(Integer id);
	void update(Usuario producto);
	void delete(Integer id);
	List<Usuario> findAll();
}
