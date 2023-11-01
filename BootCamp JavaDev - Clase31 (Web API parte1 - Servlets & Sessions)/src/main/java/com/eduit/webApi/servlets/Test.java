package com.eduit.webApi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*Generalmente al crear un Servlet con el asistente del IDE, el mismo nombre del Servlet será el mismo endpoint para 
 ser llamado dessde HTTP. En este caso sera '/Test'.
 En el caso de querer modificarlo, habra que ir al archivo web.xml generalmente ubicado en '/.../src/main/webapp/WEB-INF/web.xml'. 
 Este archivo es el archivo de configuración de despliege en el servidor. Es decir, se indica mediante este 
 archivo al Servidor como deberá desplegar a aplicación, como por ejemplo mediante que endpoint sera llamado cada Servlet
 y donde encontrarlo, como tambien las configuraciones de las Sessions y otras mas.
 Es importante recordar que generalmente los IDE al crear un nuevo Servlet se va a encargar de registrar en el mismo en 
 archivo web.xml el ruteo correspondiente, pero en el caso de crear el Servlet nosotros mismo de forma manual, se deberá 
 declarar tambien  de forma manual el Servlet con su correspondiente ruteo en el archivo web.xml. En el caso de cambiar
 el nombre de un Servlet, generalmente se debera cambiar de forma manual se cambio de nombre en el  archivo web.xml.*/
public class Test extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8"); // El Response va a generar un archivo html.
    	try (PrintWriter out = response.getWriter()){ //try with resources. El out se va a auto closear.
    		// Esto se va a renderizar en el cliente HTTP
    		out.println("<!DOCTYPE html>");
    		out.println("<html lang=es>");
    			out.println("<head>");
	    			out.println("<title> Servlet Test - Clase 01 </title>");
	    		out.println("</head>");
	    		out.println("<body>");
	    			out.println("<h1>Servlet Test at "+ request.getContextPath()+ " - Clase 01</h1>");
	    			out.println("<h3>Hola Mundo Servlet</h3>");
	    		out.println("</body>");
    		out.println("</html>");
    		
    		// Esto se va a imprimir en la Consola
    		System.out.println("*****************************************");
    		System.out.println("*********** Testeando Consola ***********");
    		System.out.println("*****************************************");
    		
    		// Interaccion con el front:
    		/* Cuando desde el request se envie un parametro llamado 'nombre' se ejecutarán estos comandos.
    		 Es decir cuando en el se ejecute 'http://localhost:8080/pruebaMaven/Test?nombre=Carlos',
    		 se va a recibir ese parametro en la variable 'nombre' mendiante el 'request.getParameter("nombre");'
    		 */
    		String nombre = request.getParameter("nombre");
    		if (nombre!=null && !nombre.isEmpty()) {
    			out.println("Hola " + nombre);
    		}
    	}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request,response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
//		doGet(request, response);
	}

}
