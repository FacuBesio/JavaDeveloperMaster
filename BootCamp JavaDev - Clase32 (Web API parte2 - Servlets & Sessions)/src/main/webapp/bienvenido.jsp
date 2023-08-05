<!--  
	Los archivos JSP (Java Server Page) van a ser la representación de un Servlet, es decir, que en su codigo 
 	base se terminaran comportando como los Servlets vistos anteriormente, pero representa una gran ventaja ya 
 	que se puede combinar HTML con Java de forma seperada y visualmente mejor distribuida. Pero como desventaja
  	no se puede utilizar un Modelo MVC, teniendo bien definido desaclopado cada modulo, siguen conviviendo 
  	direntes lenguajes en un mismo archivo, lo que genera un codigo altamente acolplado y dificil de escalar
  	y matener.
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Test JSP </title>
</head>
<body>
		  <!-- 		CODIGO HTML 		-->
		<h1> Java Server Page - HTML  </h1>
		
		<% 
			// CODIGO JAVA 
			/* Como se dijo los archivos JSP seran un equivalente a los Servlets anterioemente trabajados, 
			por este motivo se pueden invocar determinados objetos ya definidos como por ejemplo 'session', 'request'
			y 'response' o el 'out'. Los primeros tres seran objetos de HttpSession, HttpServletRequest y HttpServletResponse
			respectivamente, y el'out' sera lo mismo que PrintWriter out = response.getWriter(). Al invocar java en un archivo 
			JSP es como si estuviesmos escribiendo dentro del metodo processRequest() de los Servlets anteriores. */
			
			// • CONTROL DE SESION: 
			// En esta pagina de Bienvenida antes de visualizar la misma, se va a verificar que la session este correctamente iniciada. 
			// Solicitamos la session asociada al Request
			session = request.getSession();
		
			// Verificamos que valor (true or false) tiene el atributo session. Si es true hay una session inciada, si es false no.
			
			try{
				boolean test = (boolean)session.getAttribute("session"); 
				
				// Si la session no fue indiciada (test=false) entonces el usuario sera redirigido a logout.html.
				if(!test){
					response.sendRedirect("logout.html");
				}else {
					out.println("<h1> BIENVENIDO - Servlet JSP </h1>");
					out.println("<h2> Se ha iniciado la sesion correctamente </h2>");
				}
			} catch (Exception e){
				System.out.println("*****************************************");
				System.out.println(e);
				System.out.println("*****************************************");
				response.sendRedirect("logout.html");
			}
		%>
		
</body>
</html>