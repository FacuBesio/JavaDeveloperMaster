package mito.code.inyeccionDeDependencias;

public class Messi {
	

	// • Opcion 1:
	/*
	Barcelona bar = new Barcelona(); 
	
	public void mostrarEquipo() {
		bar.mostrar();
	}
	*/
	
	/*	En este caso Messi esta fuertemente ligado a este Club 'Barcelona', para darle mas dinamismo y 
	flexibilidad a la aplicación, se opta por las Inyecciones de Dependencias. */
	
	// • Opcion 2:
	/*Ahora la instaciacion es un poco más dínamica, pero al momento de invocar sigue siendo dependiendo
	de Barcelona. Para poder darle dinamismo y que no depende solo de Barcelona vamos a apoyarnos en una 
	interfaz. De esta forma mediante el Polimorfismo podemos indicar que todas aquellas Clases que la 
	implementen podran instanciar, desacoplando de esta forma la exclusividad de una Clase. Solomente 
	se establece un contrato de vocabulario y comportamiento mediante la Interface, y todas las Clases que 
	cumplan con dicho contrato podran instanciar a Messi.   
	 */
	/*
	private Barcelona barcelona;

	public Messi(Barcelona bar) {
		this.barcelona = bar;
	}
	
	public void setBarcelona(Barcelona barcelona) {
		this.barcelona = barcelona;
	}
	
	
	public static void main(String[] args) {
		
		Messi messi = new Messi(new Barcelona());
		
		messi.setBarcelona(new Barcelona());
		
	}
	*/
	// • Opcion 3:
	
	IEquipo equipo;

	public Messi(IEquipo equipo) {
		this.equipo = equipo;
	}

	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
	
	public void mostrarEquipo() {
		equipo.mostrar();
	}
	
	public static void main(String[] args) {
		
		Messi messi = new Messi(new Barcelona());
		messi.mostrarEquipo();
		
		messi.setEquipo(new PSG());
		messi.mostrarEquipo();
	}
	
	
}

/* En resumen se podran realizar una Inyecciónes de Dependecias a través del Constructor o Método Set y para 
 tener mayor desacoplamiento es que nos apoyaremos en Interfaces. 
 
 Si bien este esquema funciona a simple vista, el problema es que cuando necesitamos Inyectarle varias 
 dependencias a un Objeto, como en este caso podrian ser botines, pantalones, camiseta, etc, el codigo se 
 empieza a volver complejo y díficil de matener. Es por este motivo que mediante Spring se realizaran las 
 Inyecciones de Dependencias a través del Container. 
 */


 