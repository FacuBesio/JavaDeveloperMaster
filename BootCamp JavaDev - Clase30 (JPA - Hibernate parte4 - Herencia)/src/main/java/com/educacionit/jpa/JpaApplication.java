package com.educacionit.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.educacionit.jpa.dao.Persona1DAO;
import com.educacionit.jpa.dao.Persona2DAO;
import com.educacionit.jpa.dao.Empleado3DAO;
import com.educacionit.jpa.dao.Cliente3DAO;
import com.educacionit.jpa.dao.Empleado4DAO;
import com.educacionit.jpa.dao.Cliente4DAO;
import com.educacionit.jpa.entidades.herencia1.Cliente1;
import com.educacionit.jpa.entidades.herencia1.Empleado1;
import com.educacionit.jpa.entidades.herencia2.Cliente2;
import com.educacionit.jpa.entidades.herencia2.Empleado2;
import com.educacionit.jpa.entidades.herencia3.Cliente3;
import com.educacionit.jpa.entidades.herencia3.Empleado3;
import com.educacionit.jpa.entidades.herencia4.Cliente4;
import com.educacionit.jpa.entidades.herencia4.Empleado4;

import jakarta.persistence.MappedSuperclass;


@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	private Persona1DAO persona1Dao;
		
	@Autowired
	private Persona2DAO persona2Dao;
	
	@Autowired
	private Empleado3DAO empleado3Dao;
	@Autowired
	private Cliente3DAO cliente3Dao;
	
	@Autowired
	private Empleado4DAO empleado4Dao;
	@Autowired
	private Cliente4DAO cliente4Dao;

	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		//• SINGLE-TABLE Inheritance:
		Cliente1 clienteA = new Cliente1(); 
		clienteA.setApellido("Garcia");
		clienteA.setNombre("Carlos");
		clienteA.setNumeroCliente(4L);
		clienteA.setCantidadDeCompras(2);
		
		persona1Dao.save(clienteA);
		
		Empleado1 empleadoA = new Empleado1(); 
		empleadoA.setApellido("Cristian");
		empleadoA.setNombre("Alvarez");
		empleadoA.setLegajo("008");
		empleadoA.setSueldo(250000.00);
				
		persona1Dao.save(empleadoA);
		
		System.out.println("*************************************** SINGLE-TABLE ***************************************");
		Cliente1 cliente1Retorno = (Cliente1)persona1Dao.findById(1).get();
		System.out.println(". cliente1Retorno: " 
		+ cliente1Retorno.getApellido()+ ", " + cliente1Retorno.getNombre()+ " - NroCliente:"
		+ cliente1Retorno.getNumeroCliente() + " , Cantidad de Compras: " + cliente1Retorno.getCantidadDeCompras());
		
		Empleado1 empleado1Retorno = (Empleado1)persona1Dao.findById(2).get();
		System.out.println(". empleado1Retorno: " 
		+ empleado1Retorno.getApellido()+ ", " + empleado1Retorno.getNombre()+ " - NroLegajo:"
		+ empleado1Retorno.getLegajo() + " , Sueldo: " + empleado1Retorno.getSueldo());
		System.out.println("********************************************************************************************");
		
		//• JOINED:
		Cliente2 clienteB = new Cliente2(); 
		clienteB.setApellido("Garcia");
		clienteB.setNombre("Carlos");
		clienteB.setNumeroCliente(4L);
		clienteB.setCantidadDeCompras(2);
		
		persona2Dao.save(clienteB);
		
		Empleado2 empleadoB = new Empleado2(); 
		empleadoB.setApellido("Cristian");
		empleadoB.setNombre("Alvarez");
		empleadoB.setLegajo("008");
		empleadoB.setSueldo(250000.00);
				
		persona2Dao.save(empleadoB);
		
		// Prueba para ver el si se guarda con Id 3, en la Tabla de Cliente.
		Cliente2 clienteB2 = new Cliente2(); 
		clienteB2.setApellido("Spinetta");
		clienteB2.setNombre("Luis");
		clienteB2.setNumeroCliente(4L);
		clienteB2.setCantidadDeCompras(2);
		
		persona2Dao.save(clienteB2);
		
		System.out.println("****************************************** JOINED ******************************************");
		Cliente2 cliente2Retorno = (Cliente2)persona2Dao.findById(1).get();
		System.out.println(". cliente2Retorno: " 
		+ cliente2Retorno.getApellido()+ ", " + cliente2Retorno.getNombre()+ " - NroCliente:"
		+ cliente2Retorno.getNumeroCliente() + " , Cantidad de Compras: " + cliente2Retorno.getCantidadDeCompras());
		
		Empleado2 empleado2Retorno = (Empleado2)persona2Dao.findById(2).get();
		System.out.println(". empleado2Retorno: " 
		+ empleado2Retorno.getApellido()+ ", " + empleado2Retorno.getNombre()+ " - NroLegajo:"
		+ empleado2Retorno.getLegajo() + " , Sueldo: " + empleado2Retorno.getSueldo());
		System.out.println("********************************************************************************************");
		
		//• TABLE_PER_CLASS:
		Cliente3 clienteC = new Cliente3(); 
		clienteC.setApellido("Garcia");
		clienteC.setNombre("Carlos");
		clienteC.setNumeroCliente(4L);
		clienteC.setCantidadDeCompras(2);
		
		cliente3Dao.save(clienteC);
		
		Empleado3 empleadoC = new Empleado3(); 
		empleadoC.setApellido("Cristian");
		empleadoC.setNombre("Alvarez");
		empleadoC.setLegajo("008");
		empleadoC.setSueldo(250000.00);
		
		empleado3Dao.save(empleadoC);
		
		// Prueba para ver el si se guarda con Id 3, en la Tabla de Cliente.
		Cliente3 clienteC2 = new Cliente3(); 
		clienteC2.setApellido("Spinetta");
		clienteC2.setNombre("Luis");
		clienteC2.setNumeroCliente(4L);
		clienteC2.setCantidadDeCompras(2);
		
		cliente3Dao.save(clienteC2);
		
		System.out.println("************************************* TABLE_PER_CLASS **************************************");
		Cliente3 cliente3Retorno = cliente3Dao.findById(1).get();
		System.out.println(". cliente3Retorno: " 
		+ cliente3Retorno.getApellido()+ ", " + cliente3Retorno.getNombre()+ " - NroCliente:"
		+ cliente3Retorno.getNumeroCliente() + " , Cantidad de Compras: " + cliente3Retorno.getCantidadDeCompras());
		
		Empleado3 empleado3Retorno = empleado3Dao.findById(2).get();
		System.out.println(". empleado3Retorno: " 
		+ empleado3Retorno.getApellido()+ ", " + empleado3Retorno.getNombre()+ " - NroLegajo:"
		+ empleado3Retorno.getLegajo() + " , Sueldo: " + empleado3Retorno.getSueldo());
		System.out.println("********************************************************************************************");
	
	
		//• @MappedSuperclass:
		Cliente4 clienteD = new Cliente4(); 
		clienteD.setApellido("Garcia");
		clienteD.setNombre("Carlos");
		clienteD.setNumeroCliente(4L);
		clienteD.setCantidadDeCompras(2);
		
		cliente4Dao.save(clienteD);
		
		Empleado4 empleadoD = new Empleado4(); 
		empleadoD.setApellido("Cristian");
		empleadoD.setNombre("Alvarez");
		empleadoD.setLegajo("008");
		empleadoD.setSueldo(250000.00);
		
		empleado4Dao.save(empleadoD);
		
		// Prueba para ver el si se guarda con Id 3, en la Tabla de Cliente. En caso le genera un 'id' a cada Tabla,
		// por lo que en este caso el 'clienteD2' será guardado con un id = 2, y no a 3 como anteriormente.
		Cliente4 clienteD2 = new Cliente4(); 
		clienteD2.setApellido("Spinetta");
		clienteD2.setNombre("Luis");
		clienteD2.setNumeroCliente(4L);
		clienteD2.setCantidadDeCompras(2);
		
		cliente4Dao.save(clienteD2);
		
		System.out.println("************************************ @MappedSuperclass *************************************");
		Cliente4 cliente4Retorno = cliente4Dao.findById(1).get();
		System.out.println(". cliente4Retorno: " 
		+ cliente4Retorno.getApellido()+ ", " + cliente4Retorno.getNombre()+ " - NroCliente:"
		+ cliente4Retorno.getNumeroCliente() + " , Cantidad de Compras: " + cliente4Retorno.getCantidadDeCompras());
		
		// En este caso empleadoD fue guardado con id = 1. 
		Empleado4 empleado4Retorno = empleado4Dao.findById(1).get();
		System.out.println(". empleado4Retorno: " 
		+ empleado4Retorno.getApellido()+ ", " + empleado4Retorno.getNombre()+ " - NroLegajo:"
		+ empleado4Retorno.getLegajo() + " , Sueldo: " + empleado4Retorno.getSueldo());
		System.out.println("********************************************************************************************");
		
		
		
		
	}

}
