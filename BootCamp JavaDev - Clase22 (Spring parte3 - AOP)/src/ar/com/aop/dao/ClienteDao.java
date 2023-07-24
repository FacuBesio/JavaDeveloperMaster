package ar.com.aop.dao;

import org.springframework.stereotype.Component;

@Component("clienteDAO")
public class ClienteDao {
	/* Antes de ejecutar este m�todo por detr�s y de manera autom�tica se deberia ejecutar el Aspecto que comprueba que 
	el User esta logueado y que el Login es el correcto (con los roles necesarios para insertar un cliente).
	*/
	public void insertarCliente() {
		
		//.. aqui estaria el c�digo de insercion correspondiente para ingresar el Cliente en la DB...
		System.out.println("Se INSERTO el Cliente en la Base de Datos correctamente.");
	}
	
	public void insertarClienteConError() throws Exception {
		//.. aqui estaria el c�digo de insercion correspondiente para ingresar el Cliente en la DB...
		System.out.println("insertarClienteConError()");
		throw new Exception();
	}
}
