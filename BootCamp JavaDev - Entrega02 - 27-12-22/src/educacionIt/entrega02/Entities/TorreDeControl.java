package educacionIt.entrega02.Entities;

import educacionIt.entrega02.Interfaces.Aterrizable;

public class TorreDeControl {
	
/*Solo aquellos Voladores que cumplan e implementen la Interfaz Aterrizable podran ejecutar el m�todo 'PermisoAterrizar()'.*/
	
	public static void PermisoAterrizar(Aterrizable volador) {
		
		volador.aterrizar();
		
		if( volador instanceof Avion ){
	        Avion avion = (Avion)volador;
	        System.out.println("PERMISO DE ATERRIZAR AVION EN AEROPUETO OTORGADO - " +avion.getNombre());
        }
		
		if( volador instanceof Helicoptero ){
			Helicoptero helicoptero = (Helicoptero)volador;
	        System.out.println("PERMISO DE ATERRIZAR HELICOPTERO EN AEROPUETO OTORGADO - " +helicoptero.getNombre());
        }
		
	};
}
