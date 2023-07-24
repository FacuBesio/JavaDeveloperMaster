package com.mitocode.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

//opcion con id
//@Component("messi")
//opcion sin id
@Component
public class Jugador {
	
	private int numero;
	@Value("Lionel Messi")
	private String nombre;
	@Autowired
	private IEquipo equipo;
	
/*
. @Component: Es un Stereotipo y es la representacion de haber creado un bean vacio en el xml.
Ejemplo:
<bean id="messi" class="com.mitocode.beans.Jugador">	</bean>

Es decir, cada @Component es un bean vacío creado en el Container listo para usarse. Spring lo va 
a reconocer como un componente en el archivo de configuración.
Es un Bean definido de manera genérica 
Por defecto el 'id' será el nombre de la Clase, en el caso de que quiera utlizar un 'id' diferente
se podrá asiganar el mismo entre paréntesis @Component("messi").

Para asigar valores por defecto vamos a utlizar @Value. Es decir, que @Value será nuestro reemplazo 
del tag property en el xml. 
 <bean id="messi" class="com.mitocode.beans.Jugador">
	<property name="nombre" value="Lionel Messi"></property>
</bean>
	
Los diferentes estereotipos funcionan igual que @Component, solo que semánticamente indican cual seria su función. 
Se toma como buena practica utilizar para todo lo que es Base de Datos (model) el estereotipo @Repository, para los 
Controladores el estereotipo @Controller, y para las Clases que van a consumir nuestros accesos a datos @Service.

 La Annotation @Component necesita de un tag adicional en el archivo xml. 

*/	
	
	public Jugador() {
	}

	public Jugador(int numero, String nombre, IEquipo equipo) {
		this.numero = numero;
		this.nombre = nombre;
		this.equipo = equipo;
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
		return equipo;
	}
	
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}


	
	
}
