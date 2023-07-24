package educacionIt.entrega02.Entities;

import educacionIt.entrega02.Interfaces.Aterrizable;

public class Avion extends Volador implements Aterrizable{
	
	private String aerolinea;
	private String modelo;
	private int cant_AsientosTotal;
	private int cant_AsientosOcupados;
	
	
	public Avion(String nombre, int velocidad_max, String aerolinea, String modelo, int cant_AsientosTotal, 
				int cant_AsientosOcupados) {
		super(nombre, velocidad_max);
		this.aerolinea = aerolinea;
		this.modelo = modelo;
		this.cant_AsientosTotal = cant_AsientosTotal;
		this.cant_AsientosOcupados = cant_AsientosOcupados;
	}


	@Override
	public void aterrizar() {
		System.out.println(getAerolinea() + ", " + getModelo());
	}
	
	@Override
	public String toString() {
		return "Avion [aerolinea=" + aerolinea + ", modelo=" + modelo + ", cant_AsientosTotal=" + cant_AsientosTotal
				+ ", cant_AsientosOcupados=" + cant_AsientosOcupados + ", getNombre()=" + getNombre()
				+ ", getVelocidad_max()=" + getVelocidad_max() + "]";
	}


	public String getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getCant_AsientosTotal() {
		return cant_AsientosTotal;
	}


	public void setCant_AsientosTotal(int cant_AsientosTotal) {
		this.cant_AsientosTotal = cant_AsientosTotal;
	}


	public int getCant_AsientosOcupados() {
		return cant_AsientosOcupados;
	}


	public void setCant_AsientosOcupados(int cant_AsientosOcupados) {
		this.cant_AsientosOcupados = cant_AsientosOcupados;
	}




	
	
	
}
