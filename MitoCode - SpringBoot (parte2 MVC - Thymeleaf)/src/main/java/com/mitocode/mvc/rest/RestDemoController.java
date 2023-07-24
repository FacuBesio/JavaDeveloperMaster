package com.mitocode.mvc.rest;

/*
REST es un estilo de arquitectura de software. Es decir, tenemos servicios REST que son componente de software orientados a 
esta arquitectura. REST significa 'representational state transfer' o transferencia de estado representacional. 
Es una arquitectura de software donde nosotros vamos a poder compartir a trav�s del protocolo HTTP respuestas bajo cualquier 
notaci�n (xml, json, etc.).
Un Servico REST siempre debe estar bajo el protocolo HTTP en las operaciones b�sicas como GET, POST, PUT, DELETE. Los m�todos 
GET deben ser para la obtenci�n de datos, los m�todos POST para la inserci�n de datos, los m�todos PUT para una actualizaci�n
total de datos y los m�todos DELETE para eliminar datos. 


 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mitocode.mvc.model.Persona;
import com.mitocode.mvc.service.IPersonaService;

@RestController
//@RequestMapping("/RestDemoController")
public class RestDemoController {
	
	@Autowired
	IPersonaService personaService;
	
	@GetMapping
	public List <Persona> lista() {
		return personaService.listaPersonas(); 
	}
	
	@PostMapping
	public void insertar(@RequestBody Persona persona) { 
		personaService.guardarPersona(persona); 
		
		/* Con @RequestBody le estamos indicando a Spring que a trav�s del Request se enviar� un objeto 'json' que 
		 ser� coincidente con un objeto Persona. Es decir, estamos indicando que el objeto Persona persona que 
		 espera el m�todo para su ejecuci�n deber� ir a buscarlo al Request, donde habr� un objeto del tipo json que 
		 ser� coincidente con la Clase Persona. El objeto json ser� convertido a un objeto Java para ser inyectado 
		 como en par�metro en el m�todo.*/
	}

	@PutMapping
	public void modificar(@RequestBody Persona persona) { 
		personaService.guardarPersona(persona); 
		/* En este caso se vuelve a utilizar el m�todo guardarPersona(), ya que a trav�s de JPA si se ingresa 
		 una Clase con una Clave Primaria existente (idPersona en este caso), se tomar� como una actualizaci�n.
		 La �ltima inserci�n pisara los datos del objeto que ya existente, conservando obviamente el 'id'.*/
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {  
		personaService.eliminarPersona(id); 
		/* Con @PathVariable le estamos indicando a Spring que a trav�s del Request se enviar� una variable llamada "id"
		 que ser� el par�metro Integer id que m�todo esta esperando. */
		
		
	}
	
}
