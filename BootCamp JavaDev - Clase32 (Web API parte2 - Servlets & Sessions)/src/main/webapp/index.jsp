<html>
<body>
	<h1> INDEX - Spring Tool Suite</h1>
	<h1> Bienvenidos al sistema</h1>
	
<!-- Cuando se transfieren parametros de un punto a otro a traves del metodo GET, estos seran visibles, sera parte de la URL.
  	 Por este motivo para transferir parametros se utilizaran metodos POST. De esta forma se evita que cuando se transfiera 
  	 informacion no sea visible en la URL, la informacion esta dentro del cuerpo de HTTP.		-->
	<form action="http://localhost:8080/webApi_clase02/Login" method="post">
		USER<input type="text" name="user"/><br>
		PASSWORD<input type="password" name="password"/><br>
		<input type="submit" value="login"/>
		<input type="reset" value="clear"/>
	</form>
</body>
</html>
