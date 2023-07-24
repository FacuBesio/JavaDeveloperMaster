package com.mitocode.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.mvc.model.Persona;
import com.mitocode.mvc.repository.IPersonaRepo;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersonaRepo personaRepo;
	
	@Override
	public void guardarPersona(Persona persona) {
		personaRepo.save(persona);
	}

	@Override
	public List<Persona> listaPersonas() {
		
		return personaRepo.findAll();
	}

	@Override
	public void eliminarPersona(Integer id) {
		personaRepo.deleteById(id);
		
	}

}
