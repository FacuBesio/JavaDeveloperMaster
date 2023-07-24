package com.mitocode.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mitocode.repository.IPersonaRepo;

//Desde el Service creamos a una capa de la instancia de la capa repository, que es la capa que se encarga de acceder a los a datos. 
// APP => SERVICE => REPOSITORY

@Service
@Primary
public class PersonaServiceImp implements IPersonaService {
	@Autowired
	IPersonaRepo personaRepository;
	
	@Override
	public void registrar_service(String nombre) {
		//personaRepository = new PersonaRepoImp(); // Con la annotation @Autowired no es necesario instanciar el Objeto, ya que Spring se encargará.
		personaRepository.registrar(nombre);
		
	}

}
