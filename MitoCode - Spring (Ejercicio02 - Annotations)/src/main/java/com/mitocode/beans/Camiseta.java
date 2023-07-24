package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Camiseta {
	
	private int id;
	@Value("10")
	private int numero;
	@Autowired
	private Marca marca;
	
	
	
	public Camiseta() {
		super();
	}

	public Camiseta(int id, int numero, Marca marca) {
		this.id = id;
		this.numero = numero;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	
	

}
