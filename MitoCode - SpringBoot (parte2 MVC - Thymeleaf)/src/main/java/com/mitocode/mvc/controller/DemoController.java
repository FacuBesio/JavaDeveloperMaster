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
hacia una lógica de negocio. Un endpoint es una dirección de un backend que se encargará de dar respuesta a una petición.
A través de la anotación @RequestMapping("/ruta") vamos a indicar una ruta de acceso a la Clase, es decir una ruta de
acceso para poder llegar hasta a los endpoints declarados declarados dentro de la Clase. Por lo tanto el 
@RequestMapping("/ruta") se asociará a las Clases.

La anotación @GetMapping("/endpoint") indica que vamos a acceder a la función que este anexada cuando, desde el Request 
se ingrese esa direccion como endpoint. En decir, cuando enviemos un request (pedido) desde el navegador, Spring va a 
corroborar en las Clases @Controller si el request coincide con alguno de los @GetMapping("/endpoint") 	declarados. En el 
caso de coincidir accederá al método declarado, en el caso de no encontrar el endpoint arrojará un error (Whitelabel 
Error Page - 404).

Entonces por ejemplo si tenemos un @RequestMapping("/ruta") sobre nuestra Clase y un  @GetMapping("/endpoint") sobre un 
método de nuestra Clase, estamos indicando que cuando desde el navegador se ingrese 'http://localhost:8080/ruta/endpoint'
se ejecutará el método.

En el caso de que @GetMapping no tenga un endpoint declarado, estará haciendo referencia a que el endpoint será la misma
ruta ingresada en el @RequestMapping. En el caso de que @RequestMapping no tenga una ruta ingresada se esta haciendo 
referencia a que la ruta será directamente 'http://localhost:8080', es decir, cuando se ingrese a la página de raíz. 

En conclusión a través de la anotación @Controller vamos a indicar a Spring en que Clases deberá ir a buscar los  
@RequestMapping	y @GetMapping solicitados desde request. Con @Controller declaramos a la Clase como un controlador, cuya 
función será vincular el request del fron-end con nuestras Clases Java. A través de @RequestMapping vamos vincular nuestras 
Clases con el request y con @GetMapping terminaremos vinculando los métodos de nuestras Clases. 

Con Thymeleaf los archivos html siempre deberán estar en la carpeta 'templates' generalmente ubicada en la ruta ../src/main/resources/templates.

*/

@Controller
//@RequestMapping("/DemoController")
public class DemoController {
	
	@Autowired
	IPersonaService personaService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "home"; // hace mención al nombre de la página a la que se quiere direccionar. 
		
		// @RequestParam 'name' es la variable con el que voy a capturar ese párametro. 
		// En el navegador http://localhost:8080/prueba/greeting?name=MitoCode
		//required=false => indica que no es un parámetro obligatorio. 
		// defaultValue="World" => Sino hay un valor ingresado, por defecto se agrega el valor 'World'.
		// Estamos agregando al Modelo un atributo con el nombre de variable 'name' y este podrá ser recuperado en la Vista
		// (front-end) a través del mismo nombre. 
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
