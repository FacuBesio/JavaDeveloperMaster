package com.eduit.webApi.Clase04Cliente;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.eduit.webApi.entities.Articulo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* A través de este proyecto se va crear un Cliente TCP/IP con HTTP para llegar hasta el Servidor y consumir sus servicios.*/

// CLIENTE HTTP:
//Cada vez que ejecuto la aplicación estoy ingresando datos a través de la URL.
public class Clase04Cliente {

	public static void main(String[] args) {
		
		// De acuerdo a que URL seleccion va a a ser la informacion que traiga mi HttpClient:
		//Opcion 1
//		System.out.println("**************** URL /ArticuloAlta ****************");
//		String url = "http://localhost:8080/webApi_clase03/ArticuloAlta?id=1&descripcion=Articulo1&precio=1000";
		
		//Opcion 2
//		System.out.println("**************** URL /ArticuloAll ****************");
//		String url = "http://localhost:8080/webApi_clase03/ArticuloAll";
		
		//Opcion 3 => Consulta de Paginas Externas.
//		System.out.println("**************** URL PAGINA EXTERNA - Normalizador de direcciones ****************");
//		String url = "http://servicios.usig.buenosaires.gob.ar/normalizar";
		
		//Opcion 3 => Consulta de Paginas Externas.
//		System.out.println("**************** URL PAGINA EXTERNA CON RESULTADO - Normalizador de direcciones ****************");
//		String url = "http://servicios.usig.buenosaires.gob.ar/normalizar?direccion=Medrano%20162";
		/*
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
			HttpResponse <String> response= client.send(request, HttpResponse.BodyHandlers.ofString());
			
			// Estos los encabezados que entrega como información el Servlet al cual nos estamos conectando.
			System.out.println("---------------- HEADERS ----------------");
			response.headers().map().forEach((k,v)->System.out.println(k+" - "+v));
			System.out.println("-----------------------------------------");
			
			// Es la informacion del Body del Servlet al que estamos conectados que viaja por HTTP. 
			System.out.println("------------------ BODY -----------------");
			System.out.println(response.body());
			System.out.println("-----------------------------------------");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		*/
		// TODO ESTE SISTEMA LO PODEMOS TRANSFORMA EN UN METODO => getBody().
		
		
		// getBody():
		
		String url;
		
		System.out.println("**************** getBody() ****************");
		System.out.println("-------- URL /ArticuloAlta --------");
		url = "http://localhost:8080/webApi_clase03/ArticuloAlta?id=10&descripcion=Articulo10&precio=10000";
		System.out.println(getBody(url));
		
		System.out.println("");
		System.out.println("-------- URL /ArticuloAll --------");
		url = "http://localhost:8080/webApi_clase03/ArticuloAll";
		System.out.println(getBody(url));
		
//		System.out.println("");
//		System.out.println("-------- URL PAGINA EXTERNA - Normalizador de direcciones --------");
//		url = "http://servicios.usig.buenosaires.gob.ar/normalizar";
//		System.out.println(getBody(url));
		
		
		// • GSON
		/*
		 A traves de GSON nuevamente vamos a realizar el proceso inverso para poder trajabar la información recibida en Java.
		 Es decir, vamos a convetir los archivos recibidos 'json' en un Objeto del tipo List en este caso. 
		 Para poder realizar el ejemplo se tuvo que configurar el archivo 'module-info' e ingresar:
		 
	  	module Clase04Cliente {
			requires java.net.http;
			requires com.google.gson;
			opens com.eduit.webApi.entities to com.google.gson;  // <------- Esta linea hubo que ingresar. para evitar un 'com.google.gson.JsonIOException: Failed making field'
		}
		 
		*/
		System.out.println("******** GSON conversion de json en List ********");
		Type ListType = new TypeToken<List<Articulo>>(){}.getType();
		
		List<Articulo> list = new Gson().fromJson(getBody("http://localhost:8080/webApi_clase03/ArticuloAll"), ListType);
	
		list.forEach(a->System.out.println(a));
	}
	
	public static String getBody(String url){
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
			HttpResponse <String> response= client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
			
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}
		
		
	}

}
