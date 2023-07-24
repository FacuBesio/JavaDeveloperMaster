package com.mitocode.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.mvc.model.Usuario;
import com.mitocode.mvc.repository.IUsuarioRepo;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

	@Override
	public List<Usuario> listaUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	public void eliminarUsuario(Integer id) {
		usuarioRepo.deleteById(id);
	}
	
}
