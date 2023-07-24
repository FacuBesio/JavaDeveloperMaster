package com.educacionit.jpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.educacionit.jpa.entidades.Producto;
import com.educacionit.jpa.entidades.Persona;
import com.educacionit.jpa.dao.PersonaDAO;
import com.educacionit.jpa.dao.ProductoDAO;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	ProductoDAO productoDao;
	
	@Autowired
	PersonaDAO personaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	  public void run(String... args) throws Exception {
		
		  Producto producto = new Producto();
		  producto.setDescripcion("Producto1");
		  producto.setFechaAlta(new Date());
		  producto.setPrecio(20.4);
		  
		  productoDao.save(producto);
		  productoDao.findAll().forEach((p)->System.out.println(p.getDescripcion() + p.getPrecio()));
		  
		  Persona persona = new Persona();
		  persona.setApellido("Garcia");
		  persona.setNombre("Carlos");
		  persona.setEdad(30);
		 	  
		  personaDao.save(persona);
		  personaDao.findAll().forEach((p)->System.out.println(p.getApellido() + p.getNombre() + p.getEdad()));
	  }

}
