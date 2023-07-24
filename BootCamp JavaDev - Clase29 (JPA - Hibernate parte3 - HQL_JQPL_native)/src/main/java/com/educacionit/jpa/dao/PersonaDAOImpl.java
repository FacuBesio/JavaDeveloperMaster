package com.educacionit.jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import com.educacionit.jpa.entidades.Persona;

/*
El EntityManager es una de las interfaces fundamentales proporcionadas por la Java Persistence API (JPA). Su función principal
es actuar como una interfaz de nivel de programación para realizar operaciones de persistencia en la base de datos relacionales
desde una aplicación Java. 
Proporciona métodos para gestionar entidades y ejecutar transacciones en una unidad de persistencia.

Las principales funciones del EntityManager incluyen:
- Gestión de entidades: El EntityManager permite realizar operaciones CRUD (Crear, Leer, Actualizar y Borrar) en entidades JPA. 
Esto significa que puedes crear nuevas entidades y persistirlas en la base de datos, recuperar entidades existentes según su 
identificador, actualizar los atributos de las entidades y eliminar entidades de la base de datos.

- Consultas: El EntityManager permite definir y ejecutar consultas en el lenguaje de consulta de JPA, que es similar a SQL pero 
se basa en los objetos y atributos de las entidades JPA en lugar de las tablas de la base de datos.

- Gestión del ciclo de vida de las entidades: El EntityManager realiza un seguimiento de las entidades administradas y las 
transiciones de su ciclo de vida. Administra la sincronización de los cambios realizados en las entidades con la base de datos.

- Control de transacciones: El EntityManager se utiliza para iniciar y manejar transacciones. Las operaciones de persistencia 
(como guardar o actualizar entidades) deben realizarse dentro de una transacción para garantizar la coherencia y la integridad 
de la base de datos.

El EntityManager se obtiene a través de la inyección de dependencias utilizando la anotación @PersistenceContext en clases 
gestionadas por contenedores (como EJBs o CDI-managed beans) o mediante el uso de EntityManagerFactory para crear instancias de
EntityManager manualmente en entornos no gestionados.

En resumen, el EntityManager es una parte esencial de JPA que proporciona una interfaz de alto nivel para interactuar con 
entidades y realizar operaciones de persistencia en una base de datos relacional desde una aplicación Java.

La anotación @PersistenceContext se utiliza para inyectar un contexto de persistencia en una clase, lo que permite administrar
entidades y realizar operaciones de persistencia. La función principal de la anotación @PersistenceContext es establecer una conexión 
entre la aplicación Java y el proveedor de persistencia, que se encarga de interactuar con la base de datos subyacente. Al inyectar un 
contexto de persistencia en una clase, se habilita el manejo de entidades de JPA en esa clase. 
se puede utilizar @PersistenceContext para inyectar un EntityManager (interfaz para operaciones de persistencia) y poder administrar las 
entidades de JPA.
*/
@Service
public class PersonaDAOImpl {
	
	@PersistenceContext
	private EntityManager em;

	public Long cuantasPersonasHay() {
		System.out.println("*********** cuantasPersonasHay () ********");
		Query query = em.createQuery("SELECT COUNT(p) FROM Persona p"); 
		// Según el tipo de resultado que de la consulta, sera el contenedor de su respuesta y el método de Query a utilizar. En este caso
		// habrá un único resultado por lo que el método seleccionado sera 'getSingleResult()'
		Long result = (Long) query.getSingleResult(); // Hay que asegurarse de realizar consultas con un único resultado, sino habra una Exception.
		System.out.println("La cantidad de Personas registradas es: " + result);
		em.close();
		System.out.println("******************************************");
		return result;
	}
	
	public void todosLosNombres() {
		System.out.println("*********** todosLosNombres () ********");
		Query query = em.createQuery("SELECT p.nombre FROM Persona p");
		// En este caso es posible que la consulta traera multiples resultados, por este motivo el contenedor de la respuesta debe ser un 
		// Listado y en este caso el método seleccionado será 'getResultList()'.
		List<String> result = query.getResultList(); // 
		result.forEach((r)->System.out.println(r));
		em.close();
		System.out.println("******************************************");
	}
	
	/*
	 . Paginación:
	La paginación es la posibilidad de trabajar con parte del resultado que satisface una consulta. Muchas veces resulta imposible mostrar
	una cantidad importante de registros, y lo que se hace es mostrarlos agrupados por una cantidad. A esta cantidad de registros se la
	denomina “Página”.
	Estos métodos son el setMaxResults() y el setFirstResult():
	- El método setMaxResults() establece que cantidad de registros traer por página. Representa al concepto de página.
	- El método setFirstResult() establece cuál será el primer registro a traer, esto se debe a que a veces resulta necesario traer del 
	registro 0 al 100, o tal vez del registro 500 al 600.
	El primer registro tiene el número cero.
	*/
	public void primerApellido() {
		System.out.println("*********** primerApellido () ********");
		Query query = em.createQuery("SELECT p.apellido FROM Persona p");
		// En este caso a través de Query podremos utlizar los métodos de JPA para condicionar/filtrar la respuesta de la consulta.
		// setFirstResult() seria un equivalente al indicar el número de Paginas en Page.
		// setMaxResults() seria un equivalente al indicar la cantidad de Elementos por Paginas en Page.
		List<String> result = query.setFirstResult(0).setMaxResults(1).getResultList(); // 
		result.forEach((r)->System.out.println(r));
		em.close();
		System.out.println("******************************************");
	}
	
	public void primerosDosNombres() {
		System.out.println("*********** primerosDosNombres () ********");
		// Mediante 'TypedQuery' indicamos cual será el tipo de retorno que tendra la consulta, por que lo no hará falta castear el resultado.
		TypedQuery<String> query = em.createQuery("SELECT p.nombre FROM Persona p", String.class);
		List<String> result = query.setMaxResults(2).getResultList(); // 
		result.forEach((r)->System.out.println(r));
		em.close();
		System.out.println("******************************************");
	}

	public List findByName(String nombre) {
		Query query = em.createQuery("Select p from Persona p JOIN FETCH p.telefonos where p.nombre = :name");
		query.setParameter("name", nombre);
		return query.getResultList();
	}

	public List findMayorDeEdad() {
		return em.createNamedQuery("findMayorDeEdad").getResultList();
	}

	public List findByApellido(String apellido) {
		Query query = em.createNamedQuery("findByApellido");
		query.setParameter("apellido", apellido);
		return query.getResultList();
	}

	public List getAllApellidosMayuscula() {
		return em.createQuery("Select UPPER(p.apellido) from Persona p").getResultList();
	}

	

	public List<Persona> findByEdad(int edad) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
		Root<Persona> root = criteria.from(Persona.class);

		criteria.where(builder.equal(root.get("edad"), edad));

		return em.createQuery(criteria).getResultList();

	}

}
