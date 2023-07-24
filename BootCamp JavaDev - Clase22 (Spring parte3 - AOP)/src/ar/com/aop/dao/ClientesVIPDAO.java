package ar.com.aop.dao;

import org.springframework.stereotype.Component;

@Component("clienteVIPDAO")
public class ClientesVIPDAO {
	
	// Esta Clase posee un m�todo (insertaCliente()) con el mismo nombre que el declarado en el @Before, por lo tanto ejecur� el aspecto.
	public void insertarCliente() {
		//.. aqui estaria el c�digo de insercion correspondiente para ingresar el Cliente en la DB...
		System.out.println("Se INSERTO el cliente en la Base de Datos correctamente.");
	}
	
	
	
	public void insertarClienteVIP() {
		//.. aqui estaria el c�digo de insercion correspondiente para ingresar el Cliente en la DB...
		System.out.println("Se INSERTO el cliente VIP en la Base de Datos correctamente.");
	}
	
	
	public void insertarClienteVIPGolden(){
		//.. aqui estaria el c�digo de insercion correspondiente para ingresar el Cliente en la DB...
		System.out.println("insertaClienteVIPConError() se INSERTO el cliente VIP Golden en la base de datos correctamente.");
	}
	
	
}
