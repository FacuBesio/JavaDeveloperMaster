package ar.com.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.aop.dao.ClienteDao;
import ar.com.aop.dao.ClientesVIPDAO;

public class AppMain {

	public static void main(String[] args) {
				
		//. Establecer archivo de Configuración:
		// Le indicamos al Constructor de 'AnnotationConfigApplicationContext' cual es la Clase que posee la Configuración (@Config).
		AnnotationConfigApplicationContext contexto =  new AnnotationConfigApplicationContext(AppConfig.class);
				
		//. Obtener el Bean del Contenedor de Spring:
		ClienteDao cliente = contexto.getBean("clienteDAO", ClienteDao.class);
		
		//. Utilizamos el Bean:
		System.out.println("*************************cliente.insertarCliente()****************************");
		cliente.insertarCliente(); // Este ese el nombre del método que debe coincidir con la anotacion @Before.
		System.out.println("*******************************************************************************");

		ClientesVIPDAO clienteVIP = contexto.getBean("clienteVIPDAO", ClientesVIPDAO.class);
		
		System.out.println("*************************clienteVIP.insertarCliente()****************************");
		clienteVIP.insertarCliente(); // No importa la clase a la que pertenezca el método, siempre se ejecutara como un Aspecto.
		System.out.println("*******************************************************************************");
		
		System.out.println("*************************clienteVIP.insertarClienteVIP()****************************");
		clienteVIP.insertarClienteVIP(); // Pertenece al grupo de métodos declarados como Aspecto con la firma 'insertar*()'
		System.out.println("*******************************************************************************");
				
			
		System.out.println("*************************clienteVIP.insertarClienteVIPGolden()****************************");
		try {
			clienteVIP.insertarClienteVIPGolden();
		} catch (Exception e) {
			System.out.println("Se capturo una exception: " + e);
		} 
		System.out.println("*******************************************************************************");
		
		System.out.println("*************************cliente.insertarClienteConError****************************");
		try {
			cliente.insertarClienteConError();
		} catch (Exception e) {
			System.out.println("Se capturo una exception: " + e);
		} 
		System.out.println("*******************************************************************************");
		
		//. Cerramos el Contexto:
		contexto.close();
	}

}
