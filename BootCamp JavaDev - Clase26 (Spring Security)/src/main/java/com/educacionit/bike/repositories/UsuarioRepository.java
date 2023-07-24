package com.educacionit.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educacionit.bike.models.Usuario;


public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	
	// Modificamos y agregamos una consulta por columna ("nombre").
	Usuario findByNombre(String nombre); 
	
	/* El objetivo es que luego podamos utilizar el repository y buscar un registro por su nombre al momemto 
	que se 	realice un Login.
	El findBy${nombreDeLaColumna} es como una palabra reservada de Spring y JPA donde le indicamos por que 
	columna queremos hacer el where. Es como si realizaramos un : "select * from  usuario where nombre = "${algo}"; */
		

}
