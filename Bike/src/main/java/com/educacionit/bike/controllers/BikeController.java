package com.educacionit.bike.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Mediante la anotacion @RestController vamos a indicar a Spring que publique la Clase como un Spring Rest Service. 
 A través del @RequestMapping("") vamos a indicar la url en la que va imparctar este Controlador a travï¿½s de Request. Es decir, 
cuando en el Request se ingrese el Endpoint indicado la aplicaciï¿½n ira a la Clase registrada. URI BASE = URL donde va a impactar.
*/
@RestController
@RequestMapping("/api/v1/bikes") //localhost:8080/api/v1/bikes
public class BikeController {

	@GetMapping
	public String holaMundo () {
		return "Hola mundo soy una Api Rest de Spring Boot";
	}
	

	
}
