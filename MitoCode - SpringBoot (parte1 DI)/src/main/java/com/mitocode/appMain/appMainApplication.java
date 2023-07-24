package com.mitocode.appMain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImp;

/*Spring FrameWork a trav�s del Container nos va a proveer la instancia (Objetos). Por defecto estas intancias ser�n de ambito SINGLETON, 
lo que asegura una �nica instacia de cada Clase impementada. De esta forma por ejemplo en el caso de que haya una x cantidad de usuarios, 
en lugar de que cada usuario haga una nueva instancia de un recurso, Spring se encagaar� de inyectar esta instancia �nica cada vez que 
sea solicitada.
Para trabajar con Inyeccion de Dependencias y el Container de Spring se recomienda lo siguiente: 
A la Clase que se desea que sea manejada por Spring y tenga una instancia en su Container hay que anotarla con los Estereotipos. Es decir, 
a trav�s de los estereotipos vamos a crear nuestros beans en el Container de Spring e indicar sem�nticamente que funci�n estan cumpliendo. 
El objetivo de @Autowired es traer una instancia de una Clase o Interfaz, definida por alg�n estereotipo o definicion de bean en alg�n 
lugar del proyecto.
En el caso de que estemos trabajando con @Autowired orientado a Interfaces y tengamos m�s de una implementaci�n, debemos indicar cual de 
todas las posibles implementaciones deber� seleccionar. A trav�s de @Qualifier o @Primary vamos indicar con cual de todas implementaciones 
Spring deber� instanciar el bean. 
@Qualifier: Se deber� definir un 'id' en la annotation Qualifier (@Qualifier("claseParaImplementar") y colocar el mismo tanto sobre la Clase 
que queremos que sea implementada, como sobre el objeto que se este intentan definir a trav�s de @Autowired orientado a una Interfaz. En el 
caso de querer cambiar la instanciaci�n bastara con cambiar el 'id' del @Qualifier sobre el objeto.
@Primary: Simplemente se deber� colocar la annotation sobre la Clase que desee dejar como predeterminada para instanciar con @Autowired.
En el caso que haya que una Clase defenida con @Primary y posteriormente se utilice un @Qualifier, este va a prevalecer. 
Lo objetos Logger nos van a servir para transmitir informaci�n a trav�s de Spring hacia la consola. 

 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mitocode"}) // Inidicamos en que paquete debe ir a buscar las Clases para crear los Beans)
public class appMainApplication implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(appMainApplication.class); // Se indica hacia donde dirigir el Logger.
	
	@Autowired
	//@Qualifier("personaServiceImp2")
	private IPersonaService personaService;
	
	public static void main(String[] args) {
		SpringApplication.run(appMainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Hola Mundo desde Sprin Boot consola con LOGGER!");
		LOG.warn("Adviertiendo a los Coders");
		//personaService = new PersonaServiceImp(); // Con la annotation @Autowired no es necesario instanciar el Objeto, ya que Spring se encargar�.
		personaService.registrar_service("KQB");
		
		
	}
	
	
	

}
