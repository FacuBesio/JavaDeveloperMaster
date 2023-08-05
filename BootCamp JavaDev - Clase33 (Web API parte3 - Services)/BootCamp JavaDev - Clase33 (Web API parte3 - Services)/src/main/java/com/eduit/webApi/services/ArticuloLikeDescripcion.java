package com.eduit.webApi.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.eduit.webApi.jdbc.connectors.Connector;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
import com.eduit.webApi.repositories.jdbc.ArticuloRepositoryJdbc;
import com.eduit.webApi.repositories.list.ArticuloRepositoryFactory;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticuloLikeDescripcion
 */
public class ArticuloLikeDescripcion extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.setContentType("application/json;charset=UTF-8"); // --> DEFINO '.json' COMO FORMATO DE RESPUESTA DEL RESPONSE <--
    	try (PrintWriter out = response.getWriter()){ 
    		
    		// Opcion 1 con List:
//			I_ArticuloRepository ar = ArticuloRepositoryFactory.getRepository();
			
			// Opcion 2 con JDBC & SQL: Se cambia de implementacion mediante Polimorfismo.
    		I_ArticuloRepository ar = new ArticuloRepositoryJdbc(Connector.getConnection());
    		
    		
    		String descripcion = request.getParameter("descripcion");
    		out.println(new Gson().toJson(ar.getLikeDescripcion(descripcion)));
    		
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
