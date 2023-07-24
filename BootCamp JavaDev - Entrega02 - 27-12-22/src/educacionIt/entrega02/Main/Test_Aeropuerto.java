package educacionIt.entrega02.Main;

import educacionIt.entrega02.Entities.Avion;
import educacionIt.entrega02.Entities.Helicoptero;
import educacionIt.entrega02.Entities.Ovni;
import educacionIt.entrega02.Entities.Superman;
import educacionIt.entrega02.Entities.TorreDeControl;

public class Test_Aeropuerto {

	public static void main(String[] args) {
		
		System.out.println("********** AEROPUERTO **********");
		System.out.println("---- volador1 ----");
        Avion volador1 = new Avion("Avion1", 900, "Aerol�neas Argentinas", "Boeing 747", 400, 350);
        System.out.println(volador1);
        
        TorreDeControl.PermisoAterrizar(volador1);
        
        System.out.println("");
        System.out.println("---- volador2 ----");
        Helicoptero volador2 = new Helicoptero("Helicoptero1",200,"Blanco y Celeste","Bell","204/205", "Rescate");
        System.out.println(volador2);
        
        TorreDeControl.PermisoAterrizar(volador2);
        
        System.out.println("");
        System.out.println("---- volador3 ----");
        Superman volador3 = new Superman("Clark Kent", 2000000, true, "roja");
        System.out.println(volador3);
        
        /* TorreDeControl.PermisoAterrizar(volador3); => No puede obtener permiso de Aterrizar en el Aeropuerto 
         desde la Torre de Control porque no cumple con la Interfaz Aterrizable, pero si tiene la capacidad de aterrizar
         fuera del Aeropuerto.*/
        volador3.aterrizar_superman();
        
        System.out.println("");
        System.out.println("---- volador4 ----");
        Ovni volador4 = new Ovni("Ovni1", 8000, "Nave Espacial 01", "Gris");
        System.out.println(volador4);
        
        /* TorreDeControl.PermisoAterrizar(volador4); => No puede obtener permiso de Aterrizar en el Aeropuerto 
        desde la Torre de Control porque no cumple con la Interfaz Aterrizable, pero si tiene la capacidad de aterrizar
        fuera del Aeropuerto.*/
        
        volador4.aterrizar_ovni();
        
     

	}

}
