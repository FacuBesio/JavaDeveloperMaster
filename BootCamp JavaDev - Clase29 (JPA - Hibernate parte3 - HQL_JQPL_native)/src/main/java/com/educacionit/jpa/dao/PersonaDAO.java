package com.educacionit.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educacionit.jpa.entidades.Persona;
@Repository
public interface PersonaDAO extends CrudRepository<Persona, Integer>{
	
	/* Para escribir indicar a JPA la sentencia SPQL que deberá implementar para este método lo vamos a realizar a través de la anotacion 
	@Query. Es facil notar que donde en SQL escribiamos nombres de  Tablas ahora en SPQL ingresamos objetos  con sus respectivas Clase 
	(Persona p). Donde ingresamos el nombre de la Columna ahora trabajamos orientado a objetos (p.nombre) y donde ingresamos el valor
	deseado podemos ingresar un parámetro dinámico a través de la anotacion @Param(). Es decir, en @Param("nombreParametro") vamos a 
	indicar el nombre del Parametró con que el será reconocido en el SPQL, donde será invocado a través de :nombreParametro.
	*/
	@Query("from Persona p where p.nombre = :personaNombre")
	public Iterable<Persona> findByName_A(@Param("personaNombre") String name);
	
	/* En esta configuración hay que tener en cuenta si el retorno del método es un Objeto de la Clase (y no un listado de objetos),
	en el caso de que exista mas de un resultado la consulta lanzará una excepción, por este motivo, es importante utilizar campos
	únicos para esta configuración como puede ser por ejemplo el id.*/
	@Query("from Persona p where p.id = :personaId")
	public Persona findById_B(@Param("personaId") Integer id);
	
	/* En SQL, 'INNER JOIN' es un tipo de operación de unión que combina registros de dos o más tablas en función de una condición 
	de unión específica. La cláusula 'INNER JOIN' selecciona únicamente los registros que tienen una correspondencia en ambas 
	tablas involucradas en la consulta. 
	La sintaxis básica en SQL de 'INNER JOIN' es la siguiente: SELECT columnas FROM tabla1 INNER JOIN tabla2 ON tabla1.columna = tabla2.columna;
	Donde 'columnas' representa las columnas específicas que deseas seleccionar de las tablas involucradas en la consulta. 
	'tabla1' y 'tabla2' son los nombres de las tablas que deseas combinar. 'ON' es la cláusula que indica la condición de unión entre
	las tablas, que se basa en una columna común presente en ambas tablas.
	En esta consulta personalizada, se utiliza el 'INNER JOIN' para combinar registros de dos entidades: 'Persona' y 'Telefono'. 
	Se consulta que se cree un objeto 't' por cada elemento del listado p.telefonos y se corrobore que el 't.numero' con ':numeroTelefono'.
	*/
	@Query("Select p from Persona p inner join p.telefonos t where t.numero = :numeroTelefono")
	public List<Persona> findByPhone(@Param("numeroTelefono") Integer numero);
	
	// JPQL way 
	@Query("from Persona p where p.nombre = ?1 and p.edad= ?2")
	public List<Persona> findByNombreYEdad(String nombre, Integer edad);
	
	// HQL way - named way 
	@Query("Select p from Persona p where p.nombre = :nombre and p.edad= :edad")
	public List<Persona> findByNombreYEdad_B(@Param("nombre")String nombre, @Param("edad")Integer edad);
	
	// Native way 
	@Query(value= "Select * from persona p where p.nombre = ?1 and p.edad= ?2", nativeQuery = true)
	public List<Persona> findByNombreYEdad_C(String nombre, Integer edad);
	
	
	// Query methods: Spring Data JPA repository CRUD
	/* Cuando extendamos de cualquier interfaz que responda a JPA (como en este caso CrudRepository), vamos a tener la posibilidad
	de utilizar una sintaxis propia del lenguaje para generar automaticamente las sentencias contra la base de datos. En este caso
	se utiliza la nomenclatura reservada 'findBy' con el objetivo de que cada método que empiece con esa misma nomenclatura sea 
	interpretado como un  'Select * from', donde implicitamente la 'Tabla' sera completada con el tipo de entidad que se haya declarado 
	en los generics 'CrudRepository<Persona, Integer>' y el where será completado con el resto del nombre del mismo método, en este caso,
	'NombreAndEdad'(que deberán ser coincidentes con el nombre del atributo deseado). Es importante recordar que la palabra 'And' esta 
	cumpliendo la función literal de hacer un 'and' en la consulta.
	Es decir en este caso solamente declarando el método, se le esta indicando implicitamente a JPA lo siguiente que realicia la
	siguiente sentencia en la base de datos y retorne el resultado:
	'Select * from Persona where nombre = ?1 and edad = ?2*/
	public List<Persona> findByNombreAndEdad(String nombre, Integer edad);
	
	// PAGE => Orden en las consultas. Al implementar 'Page' le podremos dar una paginacion a nuestras consultas. 
	@Query("from Persona p")
	Page<Persona> findAllUsersWithPagination(Pageable pageable);
	
	@Query("from Persona p")
	Page<Persona> usuarioConUltimoApellidoAlfabeticamente(Pageable pageable);
	
	@Query("from Persona p")
	Page<Persona> findAll(Pageable pageable);
	

}
