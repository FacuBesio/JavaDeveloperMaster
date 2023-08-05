package com.eduit.webApi.test;

import com.eduit.webApi.entities.Articulo;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
import com.eduit.webApi.repositories.list.ArticuloRepository;
import com.eduit.webApi.repositories.list.ArticuloRepositoryFactory;

public class TestRepository {

	public static void main(String[] args) {
		
		/* El TestRepository se ejecuta de forma local, no se ejecuta en el Servidor. Por este motivo es que hay que crear 
		 una entidad que se encargue de simular valores para Testear el funcionamiento desde el Servidor. En este caso esa 
		 entidad estara representada por el Servlet 'Articulo Alta'.*/
		I_ArticuloRepository ar = ArticuloRepositoryFactory.getRepository();
		
		ar.save(new Articulo(1, "Articulo1", 10));
		ar.save(new Articulo(2, "Articulo2", 20));
		ar.save(new Articulo(3, "Articulo3", 30));
		ar.save(new Articulo(4, "Articulo4", 40));
		ar.save(new Articulo(5, "Articulo5", 50));
		
		System.out.println("*** getAll(): ***" );
		ar.getAll().forEach(a->System.out.println(a));
		

	}

}
