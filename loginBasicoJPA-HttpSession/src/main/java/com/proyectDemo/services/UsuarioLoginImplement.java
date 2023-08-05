package com.proyectDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectDemo.model.Usuario;
import com.proyectDemo.repository.IUsuarioLoginRepository;

@Service
public class UsuarioLoginImplement implements IUsuarioLoginService{

	@Autowired
	IUsuarioLoginRepository usuarioLoginRepo;	
	
	
	@Override
	public Usuario create(Usuario usuario) {
		return usuarioLoginRepo.save(usuario);
	}

	@Override
	public Optional<Usuario> get(Integer id) {
		return usuarioLoginRepo.findById(id);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioLoginRepo.save(usuario);
		
	}

	@Override
	public void delete(Integer id) {
		usuarioLoginRepo.deleteById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioLoginRepo.findAll();
	}


	
	
}
