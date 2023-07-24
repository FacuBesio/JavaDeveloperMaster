package com.mitocode.mvc.service;

import java.util.List;

import com.mitocode.mvc.model.Persona;

public interface IPersonaService {
	
	void guardarPersona(Persona persona);
	List<Persona> listaPersonas();
	void eliminarPersona(Integer id);

}
