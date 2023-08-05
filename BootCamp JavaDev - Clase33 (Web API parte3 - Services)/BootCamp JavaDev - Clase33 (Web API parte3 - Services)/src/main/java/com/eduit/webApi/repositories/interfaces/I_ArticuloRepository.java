package com.eduit.webApi.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.eduit.webApi.entities.Articulo;

// A través de esta Interface vamos a definir el VOCABULARIO con el que vamos a trabajar.
public interface I_ArticuloRepository {
	
	void save(Articulo articulo);
	void remove(Articulo articulo);
	List<Articulo> getAll();
	Articulo getById(int id);
	
	default List<Articulo> getLikeDescripcion(String descripcion){
		
		if(descripcion==null) return new ArrayList();
		return getAll()
				.stream()
				.filter(a->a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
				.collect(Collectors.toList());
						
		
	};
	
	

}
