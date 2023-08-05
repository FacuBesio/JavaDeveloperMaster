<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArticuloAltaSet</title>
</head>
<body>
	<h1> ArticuloAltaSet</h1>
	<form action="http://localhost:8080/pruebaMaven/ArticuloAlta" method="post">
		Id <input type="text" name="id"/><br>
		Descripcion<input type="text" name="descripcion"/><br>
		Precio<input type="number" name="precio"/><br>
		<input type="submit" value="ingresar"/>
		<input type="reset" value="clear"/>
	</form>
</body>
</html>