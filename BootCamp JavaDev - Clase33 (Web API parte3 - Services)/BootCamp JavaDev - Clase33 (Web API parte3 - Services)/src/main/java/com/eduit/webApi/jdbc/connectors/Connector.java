package com.eduit.webApi.jdbc.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	// Todos los Objetos seran estaticos para simular una conexion SingleTon
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://localhost:3306/negocioWeb";
	private static String user = "root";
	private static String pass = "";
	private static Connection conn=null;
	
	private Connector() {}; //Constructor privador para evitar cualquier intanciacion por fuera de la Clase. 
	
	public static synchronized Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,pass);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
		
	}

}
