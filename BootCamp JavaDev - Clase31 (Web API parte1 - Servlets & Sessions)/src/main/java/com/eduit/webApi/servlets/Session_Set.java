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
 * Servlet implementation class Test2
 */
/*
Por default las  duran 30 minutos, es decir, que una vez iniciada la sesion los datos de la misma 
quedarán guardados la memoria ram, y si durante ese lapso de tiempo no se detecta actividad en la Session, 
se dejará de reservar espacio en memoria para esos datos y será destruidos de la memoria ram (no de la base 
de datos). En el archivo web.xml  generalmente ubicado en '/.../src/main/webapp/WEB-INF/web.xml' vamos a 
poder cambiar esta configuración a través de las etiquetas <session-config> y <session-timeout>.
*/

public class Session_Set extends HttpServlet {
	
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    	response.setContentType("text/html;charset=UTF-8"); 
	    	try (PrintWriter out = response.getWriter()){ 
	    		out.println("<!DOCTYPE html><html lang=es><head><title> Servlet Test2 - Clase 01 </title></head>");
    			out.println("<body>");
    			out.println("<h1>Servlet Session at "+ request.getContextPath()+ " - Clase 01</h1>");
    			out.println("</body>");
	    		out.println("</html>");
	    		System.out.println("*****************************************");
	    		System.out.println("*********** Testeando Consola ***********");
	    		System.out.println("*****************************************");
	    		//• HTTP SESSIONS: setAttribute()
	    		/*
	    		El Servidor a través de HttpSession me va a proveer de un lugar en memoria reservado para las Sessions, donde 
	    		va a guardar información temporal. Como una suerte de 'base de datos' temporal en memoria.
	    		Este objeto HttpSession tiene un espacio en memoria reservado para recibir valores clave- valor en un Map, que 
	    		es donde se guardara la información. 
	    		Se le pide la Session relacionada al Request y se le asignan valores (clave, valor)	a través de setAttribute().
	    		*/
	    		HttpSession session = request.getSession();
	    		session.setAttribute("curso", "Curso de Java Web API");
	    		session.setAttribute("profesor", "Carlos Rios");
	    		session.setAttribute("session", true);
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
