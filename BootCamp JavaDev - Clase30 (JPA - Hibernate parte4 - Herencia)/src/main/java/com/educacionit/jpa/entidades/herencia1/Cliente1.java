package com.educacionit.jpa.entidades.herencia1;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Cliente1")
public class Cliente1 extends Persona1{
	private Long numeroCliente;
	private Integer cantidadDeCompras;
	
	public Long getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(Long numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public Integer getCantidadDeCompras() {
		return cantidadDeCompras;
	}
	public void setCantidadDeCompras(Integer cantidadDeCompras) {
		this.cantidadDeCompras = cantidadDeCompras;
	}

}
