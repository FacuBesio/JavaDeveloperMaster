package com.educacionit.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 En esta Clase tendremos la cadena de conexi�n con la que trabajara nuestra app, en esta se definara la Base de Datos(BDD), el user, 
 la password, el url y el driver a utilizar para establecer la Conexi�n. Por defecto en Mysql el usuario es 'root' y la password vac�a.    
  */
public class ConexionBaseDatos {
		
	static String base_datos = "clase01"; // Se ingresa el nombre de la Base de Datos.
	static String user = "root"; // user.
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + base_datos; // En lugar de localhost, puede ir un ip: 152.0.0.28
	static String driver = "com.mysql.cj.jdbc.Driver";
	
	// Creamos un objeto del tipo Connection para recirbir la Conexi�n. 
	Connection conn = null; 
	
	
	//Se crea la Conexi�n, en este caso a trav�s del constructor.
	public ConexionBaseDatos() {
		
		try {
			// Indicamos donde se encuentra el Driver
			Class.forName(driver);
			
			// Obtenemos la Conexi�n
			conn = DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
				System.out.println("La Conexi�n a la Base de Datos "+ base_datos +" fue exitosa!");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// M�todo que devuelve la Conexi�n
	public Connection getConnection() {
		return conn; 
	}
	
	// M�todo que desconecta la Conexi�n
	public void desconectar_Connection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		conn = null; 
		System.out.println("Se logro cerrar la Conexi�n correctamente.");
	}
	
	
	
	
	
}
