package com.eduit.webApi.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.eduit.webApi.entities.Articulo;

/* Esta Clase simula una 'base de datos'. Como la tecnologia seleccionada para este ejemplo fue 'List<Articulo> list = new ArrayList()', 
se genera una instancia estatica de 'ArticuloRepository' para poder usar un 'sistema que persista' momentaneamente la información
mientras testeamos el funcionamiento del Servidor. De esta forma al testear el Servidor, vamos a poder llamar a una misma instancia,
es decir, vamos a poder utilizar un lista en comun y que todos los metodos apunten a la misma lista ya tiene la misma instancia.
Concepto SingleTone, se carga en memoria una unica instancia de la Clase que va a ser llamada cada vez sea necesaria utilizarla, 
y siempre va a estar apuntando a la misma instancia. Con esta Clase terminamos de emular entonces un sistema capaz de persistir la
informacion (momentaneamente en este caso), con tu tecnologia desarrollada para poder hacer un CRUD, sin tener que preocuparnos
nosotros en desarrollar el sistema. */
public class ArticuloRepositoryFactory  {
	
	private static ArticuloRepository ar = new ArticuloRepository();
	
	public static ArticuloRepository getRepository() {
		return ar;
	}

}
