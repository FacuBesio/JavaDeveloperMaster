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
	    		// En este caso traemos la información desde el front, utilizando del index.jsp las entradas de datos
	    		// <input name="user"/> y <input name="password"/>
	    		String user = request.getParameter("user");
	    		String password = request.getParameter("password");
    			
	    		// En el caso que los datos sean correctos se podra iniciar sesion. En esta oportunidad los datos estan harcodeados,
	    		// a modo de prueba, pero la comparación podria ser por ejemplo con datos de una base de datos.
	    		if(user.equals("root")&&password.equals("1234")) {
	    			HttpSession session = request.getSession();
		    		session.setAttribute("session", true);
		    		response.sendRedirect("bienvenido.html");
	    		}else {
	    			response.sendRedirect("logout.html");
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
