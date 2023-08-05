package com.eduit.webApi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculadora
 */
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    	response.setContentType("text/plain;charset=UTF-8"); // El Response va a generar un texto plano. 
	    	// Interaccion con el front:
    		/* Cuando desde el request se envien los parametros 'nro1' & 'nro2' se ejecutarán estos comandos.
    		 Es decir, cuando en el navegador se ejecute 'http://localhost:8080/pruebaMaven/Calculadora?nro1=4&nro2=4',
    		 se van a recibir esos parametros y realizar la suma.
    		*/
	    	try (PrintWriter out = response.getWriter()){ 
	    		// Con este try se controla los casos en los que no haya información para Castear.
	    		try {
	    			// 
	    			int nro1 = Integer.parseInt(request.getParameter("nro1")); // La respuesta del Response retorna en formato String, por 
	        		int nro2 = Integer.parseInt(request.getParameter("nro2")); // este motivo hay que parsear la respuesta para un int.
	        		int suma = nro1 + nro2;
	        		out.println(". SUMA = "+suma);
				} catch (NumberFormatException e) {
					out.println("**** Por favor ingrese nro1 y nro2 en el Request ****");
				}catch (Exception e) {
					out.println("*** ERROR => "+e);
				}
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
