package com.educacionit.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.bike.models.Bike;
import com.educacionit.bike.repositories.BikeRepository;

/* Mediante la anotacion @RestController vamos a indicar a Spring que publique la Clase como un Spring Rest Service. 
 A través del @RequestMapping("") vamos a indicar la url en la que va imparctar este Controlador a través de Request. Es decir, 
cuando en el Request se ingrese la url indicada la aplicación ira a la Clase registrada. URI BASE = URL donde va a impactar.
*/
@RestController
@RequestMapping("/api/v1") //localhost:8080/api/v1/bikes
public class BikeController {
	// A través de BikeRepository vamos a realizar todas las operaciones elementales contra la Table de Bike en la BBDD a través de JPA.
	@Autowired
	private BikeRepository bk;
	
	@GetMapping
	public String holaMundo () {
		return "Hola mundo soy una Api Rest de Spring Boot";
	}
	
	@GetMapping("/bikes")
	public List<Bike> lista() {
		return bk.findAll();
	}
	
	// Este recurso retorna una Bike mediante el id recibido en la url a través de request.
	@GetMapping("/{id}") // http://localhost:8888/api/v1/bikes/${id}	
	@ResponseStatus(HttpStatus.OK)
	public Bike getBike(@PathVariable("id")Long id) {
//		Bike bc = new Bike();
//		bc.setName("Prueba");
		System.out.println("********** Recibimos por path variable el id : " + id + "***************" );
		return bk.getOne(id);
	}
	
	//este metodo recibe en el body de la peticion http un 
	//JSON (Java Script Object Notation) que sera persistido en el SQlite
	@PostMapping
	public void create(@RequestBody Bike bike) {
		bk.save(bike);
	}

}
