package com.eduit.webApi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Session1
 */

public class Session_Get extends HttpServlet {

	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    	response.setContentType("text/html;charset=UTF-8"); 
	    	try (PrintWriter out = response.getWriter()){ 
	    		out.println("<!DOCTYPE html><html lang=es><head><title> Servlet Test2 - Clase 01 </title></head>");
	  			out.println("<body>");
	  			out.println("<h1>Session01 - Clase 01</h1>");
	  			out.println("</body>");
	    		out.println("</html>");
	    		System.out.println("*****************************************");
	    		System.out.println("*********** Testeando Consola ***********");
	    		System.out.println("*****************************************");
	    		
	    		//• HTTP SESSIONS: getAttribute()
	    		/*
	    		El Servidor a través de HttpSession me va a proveer de un lugar en memoria reservado para las Sessions, donde 
	    		va a guardar información temporal. Como una suerte de 'base de datos' temporal en memoria.
	    		Este objeto HttpSession tiene un espacio en memoria reservado para recibir valores clave- valor en un Map, que 
	    		es donde se guardara la información. 
	    		Se le pide la Session relacionada al Request y sus valores (clave, valor) a través de getAttribute().
	    		*/ 
	    		try {
	    			HttpSession session = request.getSession();
		    		String curso = session.getAttribute("curso").toString();
		    		String profesor = session.getAttribute("profesor").toString();
		    		boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
		    		out.println("<h2>Curso: "+ curso+ " - Profesor: " + profesor+ " - "+sessionActive+"</h2>");
					
				} catch (NullPointerException e) {
					out.println("<h4>No se inicio la sesion. Por favor inicie la sesion en el endpoint '/Sesion_Set'.</h4>");
					out.println(e);
				} catch (Exception e) {
					out.println("<h4>**** ERROR: "+ e+ " </h4>");
				}
	    		
	    		// Java 8 o superior
	    		List <String> list = new ArrayList<String>();
	    		list.forEach(System.out::println);
	    		
	    	}
	    	
	    }
	    
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	processRequest(request,response);
//			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	    
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request,response);
//			doGet(request, response);
		}

}