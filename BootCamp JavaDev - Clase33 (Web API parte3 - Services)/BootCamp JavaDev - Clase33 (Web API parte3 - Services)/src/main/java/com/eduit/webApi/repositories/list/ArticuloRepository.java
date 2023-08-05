package com.eduit.webApi.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.eduit.webApi.entities.Articulo;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;

// A través de esta Clase vamos a definir como vamos a implementar los metodos. Es decir, vamos a definir
// como vamos a realizar en codigo, los conceptos que definimos en el VOCABULARIO. 
public class ArticuloRepository implements I_ArticuloRepository{
	
	/*
	Este Atributo va a representar la 'tecnología' que vamos a utilizar para poder llevar a cabo la implementacion de los metodos.
	En este caso a través del uso de Colecciones como tecnologia, vamos implementar nuestros metodos. El concepto a remarcar
	en este punto es la posibilidad de utilizar cualquier sistema que tenga estandarizada una tecnologia que de alguna forma
	ya haya resuelto lo que necesito hacer, y me brinde la posibilidad de reutilizar ese codigo para adaptarlo a mi proyecto.
	Un bueno ejemplo es en esta instancia seria utilizar un objeto  Interferaz que hera de JpaRepository (o una clase que la implmente)
	
	'public interface interface_name extends JpaRepository<Class, id>' generalmente con @AutoWired:
	
	@AutoWired
	interface_name objeto_name;
	*/
	
	private List<Articulo> list = new ArrayList();
	
	@Override
	public void save(Articulo articulo) {
		list.add(articulo);
	}

	@Override
	public void remove(Articulo articulo) {
		list.remove(articulo);
		
	}

	@Override
	public List<Articulo> getAll() {
		return list;
	}

	@Override
	public Articulo getById(int id) {
		Articulo articulo = list.get(id);
		return articulo;
	}

}
