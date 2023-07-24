package ar.com.eduit.curso.java.connectors;

import java.sql.Connection; // siempre de 'java.sql' 
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	private static String base_de_datos= "jdbc_parte2_colegio";
	private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url= "jdbc:mysql://localhost:3306/" + base_de_datos;
    private static String user = "root"; 
    private static String password = "";
    
    
	private static Connection conn = null;
	
	
	private Connector () {}; // Constructor privado para evitar que se creen Objetos de la Clase. 
    
	
/*
	 M�todo que va a devovler bajo un entorno controlado. Nuestro Objeto 'conn' es la �nica forma de acceder a la Conexi�n. 
	 Ya que no se puede crear Objetos de la Clase, el M�todo 'conexion_bbdd ()' ser� la �nica forma de acceder a la Conexi�n y 
	 nos vamos a asegurar de que la Conexi�n se cree un sola vez para no agotar puertos de conexi�n. (Singletone)
	 Con la palabra reservada 'synchronized' evito que dos procesos entren a la vez. Entra primero uno y despues el otro, se 
	 brinda mas estabilidad. 
	 Realizando todos estos procedimientos previos antes de crear una nueva Conexion se evita estar abriendo multiples 
	 conexiones, o abriendo y cerrando constamente la misma conexi�n. Si la conexi�n no tiene valor Nulo o ya esta creada 
     y no se cerro, continua con la misma conexi�n ya generada. Se evita el abrir y cerrar, se gana tiempo y recursos. 
 */
	public synchronized static Connection conexion_bbdd (){
	
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
		}
		
		return conn;
	}


	public static String getBase_de_datos() {
		return base_de_datos;
	}


	public static void setBase_de_datos(String base_de_datos) {
		Connector.base_de_datos = base_de_datos;
	}
	
	

}
