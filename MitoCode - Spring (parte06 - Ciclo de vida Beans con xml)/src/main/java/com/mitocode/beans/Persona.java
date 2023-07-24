/*
 * 
Para controlar el momento en que se crea un Bean y el momento en que se destruye es que existe los métodos 
'PostConstruc' y 'PreDestroy'. Dichos métodos seran controlados desde el archivo 'applicationContext.xml'.
Es decir, que una vez creado el Bean pero antes de que el mismo se incialice se ejecura el bloque de código
que se encuentre en el método declarado como PostConstruc. Y una vez que cerre el contexto en el que estemos 
trabajando, antes de destruir el Bean se ejecutara el bloque de codigo que se encuentre en el método declarado
como PreDestroy.
*
*/

package com.mitocode.beans;

public class Persona {
	
	private int id;
	private String nombre;
	private String apodo;
	private Pais pais;
	private Ciudad ciudad;
	
	public Persona() {
	
	}
	
	public Persona(int id, String nombre, String apodo, Pais pais, Ciudad ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	
	//• PostConstruct
	
	private void initBean() {
		System.out.println("Código antes de incializar el Bean");
	}
	
	//• PreDestroy
	private void destroyBean() {
		System.out.println("Código antes de Destruir el Bean");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}

