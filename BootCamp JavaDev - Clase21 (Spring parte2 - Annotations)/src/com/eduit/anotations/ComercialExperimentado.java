package com.eduit.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eduit.interfaces.CreacionInformesFinancieros;
import com.eduit.interfaces.IEmpleados;

/* 
 Registramos el beans con el 'id', que no es necesario que coincida con el nombre de la Clase. Con 
 esto ya estaria registrado nuestro Bean en el Container. Tambien podemos presindir de darle un id al 
 Component. En es caso, Spring lo que hace es tomar como 'id' al nombre de la Clase pero con la primera 
 letra en minuscula.
 Con la Annotation @Scope modificamos del tipo Singleton (default) o Prototype. 
 */
@Component("comercialExperimentado") 
//@Scope("prototype") // con esta anotacion deja de funcionar @PostConstruct y @PreDestroy
@Scope("singleton")
public class ComercialExperimentado implements IEmpleados{
	
	// Utilizamos este campo para la inyeccion de dependencias.
	private CreacionInformesFinancieros informeNuevo;
	
/* Creamos un constuctor para que atavés de este pueda Spring inyectar la dependencia con @Autowired. 
 Mediante la anotacion @Autowired se indica que busque si existe una Clase que implemente la Intefaz 
 'CreacionInformesFinancieros'. Si la encuentra, sabe que es de esa clase de donde obtendra la 
 dependencia. En este caso, encontrará la Clase 'InformeFinacieroTrimestre1'.
 Reemplaza la inyeccion de depenencia mediante el <constructor-arg ref="miInforme"></constructor-arg>
 en el xml. 
 Una vez que Spring detecta la Clase, después nosotros solamente deberiamos llamar al método 
 getInforme(). @Autowired tambien se puede implementar en Atributos (mediante el concepto de reflexion).*/	
	@Autowired
	public ComercialExperimentado(CreacionInformesFinancieros informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	@Override
	public String getInforme() {
		// utlizamos el método getInformes() sin la inyeccion de dependencias
		// return "Informe creado por el comercial con mucha experiencia en informes";
		
		// utlizamos el método getInformes() de la interface (con @Autowired implementado)
		 return informeNuevo.getInformeFinanciero();
	}
	
	@Override
	public String getTareas() {

		return "Soy un Comercial Experimentado";
	}

	
	
	/* 
	Para usar PostContruct y PreDestroy SI O SI debemos utilizar el scope por default (singleton). Esto 
	se debe a que Spring no maneja el ciclo de vida completo del bean si trabajamos con scope del tipo 
	'prototype'. Bajar la Javax Annotation API » 1.3.2 de Maven Repository en caso de la que Anotacion 
	no figure.
 	*/

	//• Método Init: Ejecucion de codigo despues de la ejecucion del bean.  
	@PostConstruct
	public void ejecutaDepuesCreacion() {
		System.out.println("Ejecutando código después de la Creacion del Bean");
	};

	//• Método Destroy: Ejecución de codigo despues del apagado del Contenedor de Spring y destruccion del Bean.
	@PreDestroy
	public void ejecutaCreacion() {
		System.out.println("Ejecutando código antes de la destruccion del Bean");
	};

}
