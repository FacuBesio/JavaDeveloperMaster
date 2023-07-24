package com.educacionit.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.educacionit.jpa.dao.PersonaDAO;
import com.educacionit.jpa.dao.ProductoDAO;
import com.educacionit.jpa.dao.TelefonoDAO;
import com.educacionit.jpa.dao.DomicilioDAO;
import com.educacionit.jpa.entidades.Telefono;
import com.educacionit.jpa.entidades.Domicilio;
import com.educacionit.jpa.entidades.Persona;


@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	DomicilioDAO domicilioDao;
	@Autowired
	PersonaDAO personaDao;
	@Autowired
	ProductoDAO productoDao;
	@Autowired
	TelefonoDAO telefonoDao;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	  @Override
	  public void run(String... args) throws Exception {
		  
		  //. ONE TO ONE (UNIDIRECCIONAL)
//		  Telefono telefono1 = new Telefono();
//		  telefono1.setNumero(1133224455);
//		  telefono1.setTipo("Celular");
//		  
//		  Persona persona1 = new Persona();
//		  persona1.setApellido("Garcia");
//		  persona1.setNombre("Carlos");
//		  persona1.setEdad(33);
//		  persona1.setTelefono(telefono1);
//		  
//		  /* En este caso se guardará en la Tabla personas el registro 'persona1' con sus valores correspondientes
//		  y en la Columna Telefono se va a indicar como valor el id del 'telefono1' que será guardado como un 
//		  registro en la Tabla telefonos.*/
//		  personaDao.save(persona1);
//		  
//		  /* Como la relación es unidireccional se podrá guardar un 'telefono2' como registro en la Tabla telefono sin 
//		  que este asocidado a ninguna persona.*/
//		  Telefono telefono2 = new Telefono();
//		  telefono2.setNumero(1133224455);
//		  telefono2.setTipo("telefono2_Prueba");
//		  telefonoDao.save(telefono2);
		  
		//. ONE TO ONE (BIDIRECCIONAL)
//		  Telefono telefono1 = new Telefono();
//		  telefono1.setNumero(1133224455);
//		  telefono1.setTipo("Celular1");
//		  
//		  Persona persona1 = new Persona();
//		  persona1.setApellido("Garcia1");
//		  persona1.setNombre("Carlos1");
//		  persona1.setEdad(33);
//		  persona1.setTelefono(telefono1);
//		  personaDao.save(persona1);
//		  
//		  /*La diferencia con el modelo anterior es que ambas Tablas estan relacionadas. En este caso, si puedo 
//		   acceder a la Persona a través del Telefono porque es una relación Bidireccional. En el caso anterior
//		   podiamos accer del Telefono a través de la persona, pero no al revés.*/
//		  Telefono telefonoretorno = telefonoDao.findById(1).get();
//		  System.out.println("******* telefonoretorno ----> "+ telefonoretorno.getPersona());
		  
/*********************************************************************************************************************************/		  
		//. ONE TO MANY / MANY TO ONE 
//		  Persona persona1 = new Persona();
//		  persona1.setApellido("Garcia1");
//		  persona1.setNombre("Carlos1");
//		  persona1.setEdad(33);
//		  
//		  Set<Telefono> listaTelefono = new HashSet<Telefono>();
//		  Telefono telefono1 = new Telefono();
//		  telefono1.setNumero(1111224455);
//		  telefono1.setTipo("Celular");
//		  Telefono telefono2 = new Telefono();
//		  telefono2.setNumero(2122224455);
//		  telefono2.setTipo("Fijo");
//		  Telefono telefono3 = new Telefono();
//		  telefono3.setNumero(0133334455);
//		  telefono3.setTipo("Movil");
//		  
//		  listaTelefono.add(telefono1);
//		  listaTelefono.add(telefono2);
//		  listaTelefono.add(telefono3);
//		  
//		  persona1.setListaTelefonos(listaTelefono);
//		  
//		  personaDao.save(persona1);
//		  
//		  System.out.println("********* Lista Telefonos - telefonoDao *********");
//		  telefonoDao.findAll().forEach((t)-> System.out.println(t.getNumero()));
//		  
//		  System.out.println("********* Lista Telefonos - personaRetorno *********");
//		  Persona personaRetorno = personaDao.findById(1).get();
//		  personaRetorno.getListaTelefonos().forEach((t)-> System.out.println(t.getNumero()));
//		  
//		  System.out.println("********* Bidireccional *********");
//		  Telefono telefonoretorno = telefonoDao.findById(1).get();
//		  System.out.println("******* telefonoretorno ----> "+ telefonoretorno.getNumero());
//		  System.out.println("******* telefonoretorno ----> "+ telefonoretorno.getPersona());

/*********************************************************************************************************************************/		  
			//. MANY TO MANY:
		  Persona persona1 = new Persona();
		  persona1.setApellido("Garcia1");
		  persona1.setNombre("Carlos1");
		  persona1.setEdad(33);
		  
		  Set<Domicilio> listaDomicilios = new HashSet<Domicilio>();
		  Domicilio domicilio1 = new Domicilio();
		  domicilio1.setCalle("calle 1");
		  domicilio1.setNumero(111);
		  Domicilio domicilio2 = new Domicilio();
		  domicilio2.setCalle("calle 2");
		  domicilio2.setNumero(222);
		  Domicilio domicilio3 = new Domicilio();
		  domicilio3.setCalle("calle 3");
		  domicilio3.setNumero(333);
		  
		  listaDomicilios.add(domicilio1);
		  listaDomicilios.add(domicilio2);
		  listaDomicilios.add(domicilio3);
		  
		  persona1.setListaDomicilios(listaDomicilios);
		  
		  personaDao.save(persona1);
		  System.out.println("********* Lista Domicilios - domicilioDao *********");
		  domicilioDao.findAll().forEach((d)-> System.out.println(d.getCalle()));
		  
		  System.out.println("********* Lista Telefonos - personaRetorno1 *********");
		  Persona personaRetorno = personaDao.findById(1).get();
		  personaRetorno.getListaDomicilios().forEach((d)-> System.out.println(d.getCalle()));
		  // En un Many to Many Unidireccional, no se podrá cargar el mismo Domicilio a más de una persona, 
		  //solamente la persona podrá tener muchos domicilios, pero no viceversa. 
		  
		  System.out.println("********* Bidireccional *********");
		  Domicilio domicilioRetorno = domicilioDao.findById(1).get();
		  System.out.println("******* domicilioRetorno ----> "+ domicilioRetorno.getCalle());
		  domicilioRetorno.getListaPersonas().forEach((p)-> System.out.println("******* domicilioRetorno ----> " + p.getApellido()));
		  
//		  Persona persona2 = new Persona();
//		  persona2.setApellido("Garcia2");
//		  persona2.setNombre("Carlos2");
//		  persona2.setEdad(22);
//		  
//		  persona2.setListaDomicilios(listaDomicilios);
//		  personaDao.save(persona2);
//		  System.out.println("********* Lista Domicilios - domicilioDao *********");
//		  domicilioDao.findAll().forEach((d)-> System.out.println(d.getCalle()));

		  
		  
	  }

}
