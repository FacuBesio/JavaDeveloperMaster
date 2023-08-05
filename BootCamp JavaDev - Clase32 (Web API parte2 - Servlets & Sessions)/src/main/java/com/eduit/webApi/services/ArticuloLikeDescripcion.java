package com.eduit.webApi.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
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
    		
    		String descripcion = request.getParameter("descripcion");
    		out.println(new Gson().toJson(ArticuloRepositoryFactory.getRepository().getLikeDescripcion(descripcion)));
    		
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
