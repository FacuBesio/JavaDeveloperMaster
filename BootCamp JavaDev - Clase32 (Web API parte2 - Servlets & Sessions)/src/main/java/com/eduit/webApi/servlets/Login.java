package com.eduit.webApi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    	response.setContentType("text/html;charset=UTF-8"); 
	    	try (PrintWriter out = response.getWriter()){ 
	    		String user = request.getParameter("user");
	    		String password = request.getParameter("password");
    			
	    		if(user.equals("root")&&password.equals("1234")) {
	    			HttpSession session = request.getSession();
		    		session.setAttribute("session", true);
		    		response.sendRedirect("bienvenido.jsp");
	    		}else {
	    			response.sendRedirect("sesionInvalida.html");
	    		}
	    	}
	    }
	    
	 	/* En metodo doGet() no se tiene que poder ejecutar un processRequest. Debera ser ejecutado en metodo doPost() si o si.
 	 	De esta forma se evita que cuando se transfiera informacion no sea visible en la URL, la informacion esta dentro del 
	 	cuerpo de HTTP.*/
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
