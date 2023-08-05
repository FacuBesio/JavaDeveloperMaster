package com.eduit.webApi.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.eduit.webApi.jdbc.connectors.Connector;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
import com.eduit.webApi.repositories.jdbc.ArticuloRepositoryJdbc;
import com.eduit.webApi.repositories.list.ArticuloRepositoryFactory;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ArticulosAll
 */
public class ArticuloAll extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.setContentType("application/json;charset=UTF-8"); // --> DEFINO '.json' COMO FORMATO DE RESPUESTA DEL RESPONSE <--
    	try (PrintWriter out = response.getWriter()){ 
    		
    		// Opcion 1 con List:
//    		I_ArticuloRepository ar = ArticuloRepositoryFactory.getRepository();
    		
    		// Opcion 2 con JDBC & SQL: Se cambia de implementacion mediante Polimorfismo.
    		I_ArticuloRepository ar = new ArticuloRepositoryJdbc(Connector.getConnection());
    		
    		    		// ar.getAll(); => Esta consulta la necesito trasladar a un formato '.json' para poder enviarla por el Response. 
    		// Para traspasar Java a .json utlizaremos las librerias de 'GSON' un framework de Google.
    		Gson gson = new Gson();
    		out.println(gson.toJson(ar.getAll())); // De esta forma se enviara la consulta renderizada en formato .json por el Response.
    		
    		
    	}catch (Exception e) {
			System.out.println("**************************** ERROR ****************************");
			System.out.println(e);
			System.out.println("***************************************************************");
		}
    }
    
 	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request,response);
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
