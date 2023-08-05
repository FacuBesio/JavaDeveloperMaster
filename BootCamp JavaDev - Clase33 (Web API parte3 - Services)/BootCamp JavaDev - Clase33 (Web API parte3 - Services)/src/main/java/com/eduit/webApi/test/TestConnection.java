package com.eduit.webApi.test;

import java.sql.Connection;
import java.sql.ResultSet;

import com.eduit.webApi.jdbc.connectors.Connector;

public class TestConnection {
	
	public static void main(String[] args) {
		try (Connection conn= Connector.getConnection();
			 ResultSet rs= conn.createStatement().executeQuery("select version()")){
				if(rs.next()) {
					System.out.println("Se conecto exitosamente: "+rs.getString(1));
				}else {
					System.out.println("***** No se pudo conectar con la Base de Datos ****** ");
				}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
