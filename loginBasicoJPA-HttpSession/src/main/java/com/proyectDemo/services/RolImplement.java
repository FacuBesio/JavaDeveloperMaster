package com.proyectDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectDemo.model.Role;
import com.proyectDemo.repository.IRolRepository;

@Service
public class RolImplement implements IRolService{

	@Autowired
	IRolRepository rolRepo;	
	
	
	@Override
	public Role create(Role rol) {
		return rolRepo.save(rol);
	}

	@Override
	public Optional<Role> get(Integer id) {
		return rolRepo.findById(id);
	}

	@Override
	public void update(Role rol) {
		rolRepo.save(rol);
		
	}

	@Override
	public void delete(Integer id) {
		rolRepo.deleteById(id);
	}

	@Override
	public List<Role> findAll() {
		return rolRepo.findAll();
	}
}
