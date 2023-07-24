package com.educacionit.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.educacionit.jpa.entidades.Telefono;
import com.educacionit.jpa.dao.PersonaDAO;
import com.educacionit.jpa.dao.PersonaDAOImpl;
import com.educacionit.jpa.entidades.Domicilio;
import com.educacionit.jpa.entidades.Persona;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	private PersonaDAO personaDao;
	
	@Autowired
	private PersonaDAOImpl personaDaoImpl;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//PERSONAS:
		Persona persona1 = new Persona();
		persona1.setApellido("Garcia");
		persona1.setNombre("Carlos");
		persona1.setEdad(33);
		
		Persona persona2 = new Persona();
		persona2.setApellido("Alvarez");
		persona2.setNombre("Cristian");
		persona2.setEdad(33);
		
		Persona persona3 = new Persona();
		persona3.setApellido("Garcia2");
		persona3.setNombre("Carlos");
		persona3.setEdad(22);
		
		//TELEFONOS:
		List<Telefono> listaTelefono = new ArrayList<Telefono>();
		Telefono telefono1 = new Telefono();
		telefono1.setNumero(1111224455);
		telefono1.setTipo("Celular");
		Telefono telefono2 = new Telefono();
		telefono2.setNumero(2122224455);
		telefono2.setTipo("Fijo");
		Telefono telefono3 = new Telefono();
		telefono3.setNumero(0133334455);
		telefono3.setTipo("Movil");
		
		persona1.addTelefono(telefono1);
		persona1.addTelefono(telefono2);
		persona1.addTelefono(telefono3);
		
		//DOMICILIOS:
		List<Domicilio> listaDomicilios = new ArrayList<Domicilio>();
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

		persona1.setDomicilios(listaDomicilios);
		
		
		
		personaDao.save(persona1);
		personaDao.save(persona2);
		personaDao.save(persona3);
		
		//. findByName_A():
		personaDao.findByName_A("Carlos").forEach((p)->System.out.println("******** findByName_A ******: "+p.getApellido()+", "+p.getNombre()));
		
		//. findByName_B(): Recordar que este método en el caso de que haya mas de un resultado arrojara un error, por este motivo
		//  se tomo el 'id' como Parametro.
		System.out.println("******** findById_B(1) ******: "+personaDao.findById_B(1).getApellido()); 
		
		//. findByPhone():
		personaDao.findByPhone(2122224455).forEach((p)->System.out.println("******** findByPhone(2122224455) ******: "+p.getApellido()+", "+p.getNombre()));
		
		//. findByNombreYEdad(): JPQL
		personaDao.findByNombreYEdad("Carlos", 22).forEach((p)->System.out.println("******** findByNombreYEdad(): JPQL ******: "
																+p.getApellido()+", "+p.getNombre() + " " + p.getEdad()));
		
		//. findByNombreYEdad_B(): HQL
		personaDao.findByNombreYEdad_B("Carlos", 33).forEach((p)->System.out.println("******** findByNombreYEdad_B(): HQL ******: "
															    +p.getApellido()+", "+p.getNombre() + " " + p.getEdad()));
		
		//. findByNombreYEdad_C(): nativo
		personaDao.findByNombreYEdad_C("Carlos", 22).forEach((p)->System.out.println("******** findByNombreYEdad_C(): nativo ******: "
																+p.getApellido()+", "+p.getNombre() + " " + p.getEdad()));
		
		//. Query methods: Spring Data JPA repository CRUD
		personaDao.findByNombreAndEdad("Carlos", 22).forEach((p)->System.out.println("******** JPA repository CRUD - findByNombreAndEdad ******: "
																+p.getApellido()+", "+p.getNombre() + " " + p.getEdad()));
		// PAGE => Orden en las consultas.
		//EJEMPLO 1:
		System.out.println("###### PAGE ######: ");
		// Se define como va a ser la paginacion y luego sera pasada como parametro al método.
		int numeroDePagina = 0;
		int cantidadDeElementos = 2;				// Cantidad de Elementos por página.
		Pageable page = PageRequest.of(numeroDePagina, cantidadDeElementos, Sort.by("edad").ascending());
		
		System.out.println("****** findAllUsersWithPagination() ******: ");
		System.out.println(". Page 0:");
		personaDao.findAllUsersWithPagination(page).forEach((p)->System.out.println(p.getApellido()+", "+p.getNombre() + " " + p.getEdad()));
		
		System.out.println(". Page 1:");
		numeroDePagina = 1;
		cantidadDeElementos = 2;				
		page = PageRequest.of(numeroDePagina, cantidadDeElementos, Sort.by("edad").ascending());
		personaDao.findAllUsersWithPagination(page).forEach((p)->System.out.println(p.getApellido()+", "+p.getNombre() 
																					+ " " + p.getEdad()));
		System.out.println("*************************************************************** ");
		
		//EJEMPLO 2:
		System.out.println("****** Ejemplo de Page con findAll() ******: ");
		personaDao.findAll(page).forEach((p)->System.out.println(p.getApellido()+", "+p.getNombre() 
																 + " " + p.getEdad()));
		System.out.println("*************************************************************** ");
		
		//EJEMPLO 2:
		System.out.println("****** Ejemplo de Page con usuarioConUltimoApellidoAlfabeticamente() ******: ");
		numeroDePagina = 0;
		cantidadDeElementos = 1;				// Cantidad de Elementos por página.
		Pageable pageB = PageRequest.of(numeroDePagina, cantidadDeElementos, Sort.by("apellido").descending());
		personaDao.usuarioConUltimoApellidoAlfabeticamente(pageB).forEach((p)->System.out.println(p.getApellido()+", "
																		  		+p.getNombre() + " " + p.getEdad()));
		System.out.println("*************************************************************** ");
		
		
		// PersonaDaoImpl:
		personaDaoImpl.cuantasPersonasHay();
		personaDaoImpl.todosLosNombres();
		personaDaoImpl.primerApellido();
		personaDaoImpl.primerosDosNombres();
		
				
	}	

}
