package com.mitocode.mvc.service;

import java.util.List;
import com.mitocode.mvc.model.Usuario;

public interface IUsuarioService {

	Usuario guardarUsuario(Usuario usuario);
	List<Usuario> listaUsuarios();
	void eliminarUsuario(Integer id);
}
