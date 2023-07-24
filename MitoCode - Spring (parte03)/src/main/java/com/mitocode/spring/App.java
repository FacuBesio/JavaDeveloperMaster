package com.mitocode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mitocode.beans.AppConfigUniverso;
import com.mitocode.beans.AppConfigMundo;
import com.mitocode.beans.Mundo;
import com.mitocode.beans.Universo;

public class App {

	public static void main(String[] args) {
		// 'con Annotations'
		System.out.println("• appConfig:");
		//Opcion A
		ApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfigUniverso.class,
																			  AppConfigMundo.class);
		
		
		Universo universo = appConfig.getBean(Universo.class);
		/* Solo se puede utilizar 'Universo.class' para definir el Bean si hay un único Bean declarado
		en el appConfig*/
		System.out.println(universo.getSaludo());
		
		/* En el caso de que mas haya declarado más de un Bean dentro del appConfig, se deberá indicar cual 
		es el id del Bean que se desea utlizar, declarado como 'id' en los XML o  a través del nombre del método 
		que tenga el Bean en el caso de las annotations. Es decir, 
	 	si se desea invocar al 
	 	
	 	@Bean
		public Mundo tierra() {
			return new Mundo();
		}
		
		el 'id' en este caso será 'tierra'.
		 
		*/
		Mundo tierra = (Mundo) appConfig.getBean("tierra");
		System.out.println(tierra.getSaludo());
		
		Mundo mar = (Mundo) appConfig.getBean("marte");
		System.out.println(mar.getSaludo());
		// 'marte' y 'tierra' en este caso hacen referencia al nombre del método declarado dentro del Bean.
		
		
//		//Opcion B para registrar los appConfig en el archivo de Configuracion. 
//		AnnotationConfigApplicationContext appConfigBis = new AnnotationConfigApplicationContext();
//		appConfigBis.register(AppConfigUniverso.class);
//		appConfigBis.register(AppConfigMundo.class);
//		appConfigBis.refresh();
	}
}
