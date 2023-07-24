package com.mitocode.beans;
import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.interfaces.IEquipo;

public class Jugador {
	
	private int numero;
	private String nombre;
	@Autowired
	private IEquipo psg;
	
/*
. Autowired:
Con el Annotation @Autowired le vamos a indicar a Spring, que habra Atributos que se completaran de forma 
automática según a la Clase o Interfaz que pertenezcan, siempre y cuando el Bean este declarado. El 'autowired'
por defecto es del tipo tipo 'byType'. Es decir, buscara un Bean que este implementando una Clase que coincida 
con el tipo de Objeto que se esta solicitando. En el caso de de que haya mas de una Bean que coincida con el tipo de dato, 
va a realizar una comparacion 'byName' y verificara si alguna de las opciones disponibles coincide con el nombre 
del Atributo. Si coincide utilizara ese Bean, y en el caso de que no coincida indicara un error. 
Si hay mas de una opción que coindida con el tipo de dato y no se desea que el nombre del Atributo coincida con un 
tipo de Bean en particular se podrá indicar a través del @Qualifier.
es decir, que en el caso de que haya mas de una Bean coincidente
Es resumen por defecto el @Autowired funciona 'byType', y si se coincidir el nombre de Atributo con el del Bean el 
autowired funcionara 'byName'. 
*/	
	
	public Jugador() {
	}

	public Jugador(int numero, String nombre, IEquipo equipo) {
		this.numero = numero;
		this.nombre = nombre;
		this.psg = equipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public IEquipo getEquipo() {
		return psg;
	}
	
	public void setEquipo(IEquipo equipo) {
		this.psg = equipo;
	}


	
	
}
