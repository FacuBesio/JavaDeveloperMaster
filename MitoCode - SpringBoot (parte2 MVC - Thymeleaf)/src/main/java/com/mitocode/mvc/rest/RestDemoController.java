package com.mitocode.mvc.rest;

/*
REST es un estilo de arquitectura de software. Es decir, tenemos servicios REST que son componente de software orientados a 
esta arquitectura. REST significa 'representational state transfer' o transferencia de estado representacional. 
Es una arquitectura de software donde nosotros vamos a poder compartir a través del protocolo HTTP respuestas bajo cualquier 
notación (xml, json, etc.).
Un Servico REST siempre debe estar bajo el protocolo HTTP en las operaciones básicas como GET, POST, PUT, DELETE. Los métodos 
GET deben ser para la obtención de datos, los métodos POST para la inserción de datos, los métodos PUT para una actualización
total de datos y los métodos DELETE para eliminar datos. 


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
		
		/* Con @RequestBody le estamos indicando a Spring que a través del Request se enviará un objeto 'json' que 
		 será coincidente con un objeto Persona. Es decir, estamos indicando que el objeto Persona persona que 
		 espera el método para su ejecución deberá ir a buscarlo al Request, donde habrá un objeto del tipo json que 
		 será coincidente con la Clase Persona. El objeto json será convertido a un objeto Java para ser inyectado 
		 como en parámetro en el método.*/
	}

	@PutMapping
	public void modificar(@RequestBody Persona persona) { 
		personaService.guardarPersona(persona); 
		/* En este caso se vuelve a utilizar el método guardarPersona(), ya que a través de JPA si se ingresa 
		 una Clase con una Clave Primaria existente (idPersona en este caso), se tomará como una actualización.
		 La última inserción pisara los datos del objeto que ya existente, conservando obviamente el 'id'.*/
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {  
		personaService.eliminarPersona(id); 
		/* Con @PathVariable le estamos indicando a Spring que a través del Request se enviará una variable llamada "id"
		 que será el parámetro Integer id que método esta esperando. */
		
		
	}
	
}
