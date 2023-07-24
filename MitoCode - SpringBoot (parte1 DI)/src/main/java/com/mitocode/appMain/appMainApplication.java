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

/*Spring FrameWork a través del Container nos va a proveer la instancia (Objetos). Por defecto estas intancias serán de ambito SINGLETON, 
lo que asegura una única instacia de cada Clase impementada. De esta forma por ejemplo en el caso de que haya una x cantidad de usuarios, 
en lugar de que cada usuario haga una nueva instancia de un recurso, Spring se encagaará de inyectar esta instancia única cada vez que 
sea solicitada.
Para trabajar con Inyeccion de Dependencias y el Container de Spring se recomienda lo siguiente: 
A la Clase que se desea que sea manejada por Spring y tenga una instancia en su Container hay que anotarla con los Estereotipos. Es decir, 
a través de los estereotipos vamos a crear nuestros beans en el Container de Spring e indicar semánticamente que función estan cumpliendo. 
El objetivo de @Autowired es traer una instancia de una Clase o Interfaz, definida por algún estereotipo o definicion de bean en algún 
lugar del proyecto.
En el caso de que estemos trabajando con @Autowired orientado a Interfaces y tengamos más de una implementación, debemos indicar cual de 
todas las posibles implementaciones deberá seleccionar. A través de @Qualifier o @Primary vamos indicar con cual de todas implementaciones 
Spring deberá instanciar el bean. 
@Qualifier: Se deberá definir un 'id' en la annotation Qualifier (@Qualifier("claseParaImplementar") y colocar el mismo tanto sobre la Clase 
que queremos que sea implementada, como sobre el objeto que se este intentan definir a través de @Autowired orientado a una Interfaz. En el 
caso de querer cambiar la instanciación bastara con cambiar el 'id' del @Qualifier sobre el objeto.
@Primary: Simplemente se deberá colocar la annotation sobre la Clase que desee dejar como predeterminada para instanciar con @Autowired.
En el caso que haya que una Clase defenida con @Primary y posteriormente se utilice un @Qualifier, este va a prevalecer. 
Lo objetos Logger nos van a servir para transmitir información a través de Spring hacia la consola. 

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
		//personaService = new PersonaServiceImp(); // Con la annotation @Autowired no es necesario instanciar el Objeto, ya que Spring se encargará.
		personaService.registrar_service("KQB");
		
		
	}
	
	
	

}
