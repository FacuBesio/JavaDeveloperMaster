package com.eduit.webApi.test;

import com.eduit.webApi.entities.Articulo;
import com.eduit.webApi.jdbc.connectors.Connector;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
import com.eduit.webApi.repositories.jdbc.ArticuloRepositoryJdbc;
import com.eduit.webApi.repositories.list.ArticuloRepositoryFactory;

public class TestRepository {

	public static void main(String[] args) {
		
		/* El TestRepository se ejecuta de forma local, no se ejecuta en el Servidor. Por este motivo es que hay que crear 
		 una entidad que se encargue de simular valores para Testear el funcionamiento desde el Servidor. En este caso esa 
		 entidad estara representada por el Servlet 'Articulo Alta'.*/
//		I_ArticuloRepository ar = ArticuloRepositoryFactory.getRepository();
		
		
		// JDBC - SQL:  
		// Polimorfimos, simplemente cambiando la implementacion se la interfaz, se logra cambiar de tecnologia, sin afectar al resto.
		I_ArticuloRepository ar = new ArticuloRepositoryJdbc(Connector.getConnection());
		
		// *** save(): ***
		ar.save(new Articulo(1, "ParlanteBT", 10));
		ar.save(new Articulo(2, "Articulo2", 20));
		ar.save(new Articulo(3, "ParlanteMonitor", 30));
		ar.save(new Articulo(4, "Articulo4", 40));
		ar.save(new Articulo(5, "Ariculares", 50));
		
		System.out.println("*** getAll(): ***" );
		ar.getAll().forEach(a->System.out.println(a));
		
		System.out.println("");
		System.out.println("*** getLikeDescripcion(): ***" );
		ar.getLikeDescripcion("lan").forEach(a->System.out.println(a));
		
		System.out.println("");
		System.out.println("*** getById(): '2' ***" );
		System.out.println(ar.getById(2));
		
		System.out.println("");
		System.out.println("*** remove(): 'Articulo2' ***" );
		ar.remove(ar.getById(2));
		System.out.println("*** getAll(): ***" );
		ar.getAll().forEach(a->System.out.println(a));
		
		

	}

}
