package com.loginBasicoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginBasicoJPA.model.Rol;
import com.loginBasicoJPA.repository.IRolRepository;

@Service
public class RolImplement implements IRolService{

	@Autowired
	IRolRepository rolRepo;	
	
	
	@Override
	public Rol create(Rol rol) {
		return rolRepo.save(rol);
	}

	@Override
	public Optional<Rol> get(Integer id) {
		return rolRepo.findById(id);
	}

	@Override
	public void update(Rol rol) {
		rolRepo.save(rol);
		
	}

	@Override
	public void delete(Integer id) {
		rolRepo.deleteById(id);
	}

	@Override
	public List<Rol> findAll() {
		return rolRepo.findAll();
	}
}
