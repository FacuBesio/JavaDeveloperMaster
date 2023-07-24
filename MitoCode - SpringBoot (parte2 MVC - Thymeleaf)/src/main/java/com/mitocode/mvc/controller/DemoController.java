package com.mitocode.mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.mvc.model.Persona;
//import com.mitocode.service.IPersonaService;
import com.mitocode.mvc.service.IPersonaService;

/* 
Un Controlador es una Clase del modelo MVC cuya funcion particular es redireccionar la petecion del usuario (request)
hacia una l�gica de negocio. Un endpoint es una direcci�n de un backend que se encargar� de dar respuesta a una petici�n.
A trav�s de la anotaci�n @RequestMapping("/ruta") vamos a indicar una ruta de acceso a la Clase, es decir una ruta de
acceso para poder llegar hasta a los endpoints declarados declarados dentro de la Clase. Por lo tanto el 
@RequestMapping("/ruta") se asociar� a las Clases.

La anotaci�n @GetMapping("/endpoint") indica que vamos a acceder a la funci�n que este anexada cuando, desde el Request 
se ingrese esa direccion como endpoint. En decir, cuando enviemos un request (pedido) desde el navegador, Spring va a 
corroborar en las Clases @Controller si el request coincide con alguno de los @GetMapping("/endpoint") 	declarados. En el 
caso de coincidir acceder� al m�todo declarado, en el caso de no encontrar el endpoint arrojar� un error (Whitelabel 
Error Page - 404).

Entonces por ejemplo si tenemos un @RequestMapping("/ruta") sobre nuestra Clase y un  @GetMapping("/endpoint") sobre un 
m�todo de nuestra Clase, estamos indicando que cuando desde el navegador se ingrese 'http://localhost:8080/ruta/endpoint'
se ejecutar� el m�todo.

En el caso de que @GetMapping no tenga un endpoint declarado, estar� haciendo referencia a que el endpoint ser� la misma
ruta ingresada en el @RequestMapping. En el caso de que @RequestMapping no tenga una ruta ingresada se esta haciendo 
referencia a que la ruta ser� directamente 'http://localhost:8080', es decir, cuando se ingrese a la p�gina de ra�z. 

En conclusi�n a trav�s de la anotaci�n @Controller vamos a indicar a Spring en que Clases deber� ir a buscar los  
@RequestMapping	y @GetMapping solicitados desde request. Con @Controller declaramos a la Clase como un controlador, cuya 
funci�n ser� vincular el request del fron-end con nuestras Clases Java. A trav�s de @RequestMapping vamos vincular nuestras 
Clases con el request y con @GetMapping terminaremos vinculando los m�todos de nuestras Clases. 

Con Thymeleaf los archivos html siempre deber�n estar en la carpeta 'templates' generalmente ubicada en la ruta ../src/main/resources/templates.

*/

@Controller
//@RequestMapping("/DemoController")
public class DemoController {
	
	@Autowired
	IPersonaService personaService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "home"; // hace menci�n al nombre de la p�gina a la que se quiere direccionar. 
		
		// @RequestParam 'name' es la variable con el que voy a capturar ese p�rametro. 
		// En el navegador http://localhost:8080/prueba/greeting?name=MitoCode
		//required=false => indica que no es un par�metro obligatorio. 
		// defaultValue="World" => Sino hay un valor ingresado, por defecto se agrega el valor 'World'.
		// Estamos agregando al Modelo un atributo con el nombre de variable 'name' y este podr� ser recuperado en la Vista
		// (front-end) a trav�s del mismo nombre. 
	}
	
	@GetMapping("/save")
	public String save() {
		Persona p = new Persona();
		p.setIdPersona(8);
		p.setNombre("KQB");
		personaService.guardarPersona(p);
		personaService.listaPersonas();
		return "save"; 

	}
	
	@GetMapping("/listaPersonas")
	public String lista(Model model) {
		model.addAttribute("personas", personaService.listaPersonas());
		return "lista"; 

	}

}
