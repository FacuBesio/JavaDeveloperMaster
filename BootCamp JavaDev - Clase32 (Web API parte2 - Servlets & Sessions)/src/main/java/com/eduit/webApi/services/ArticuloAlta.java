package com.eduit.webApi.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.eduit.webApi.entities.Articulo;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;
import com.eduit.webApi.repositories.list.ArticuloRepositoryFactory;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticuloAlta
 */

/* Se diseño el JSP 'ArticuloAltaSet' para ingresar 'Articulos' a través de un formulario y que el Servlet
 'ArticuloAlta' los reciba e ingrese. El formulario enviara la información por 'post'.*/
public class ArticuloAlta extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.setContentType("text/plain;charset=UTF-8"); // --> DEFINO 'texto plano' COMO FORMATO DE RESPUESTA DEL RESPONSE <--
    	try (PrintWriter out = response.getWriter()){ 
    		
    		try {
    			I_ArticuloRepository ar = ArticuloRepositoryFactory.getRepository();
    			
    			int id = Integer.parseInt(request.getParameter("id"));
    			String descripcion = request.getParameter("descripcion");
    			float precio = Float.parseFloat(request.getParameter("precio"));
    			
    			ar.save(new Articulo(id,descripcion,precio));
    			out.println("True - Se recibio e ingreso el articulo en la Lista.");
    			out.println("Se ingreso exitosamente el arituclo: " + id +". "+ descripcion +" - "+ precio );
    		
    		} catch (Exception e) {
				out.println("False - Algo sucedio, no se ingreso el articulo. Intente nuevamente por favor.");
			}
		}
    }
    
 	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try (PrintWriter out = response.getWriter()){ 
    		out.println("<h1>* No se puede ingresar parametros por GET * </h1>");
    		out.println("<h2>Utilizar POST para transferir parametros</h2>");
    		}
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
