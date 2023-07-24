/*
 
• Inyeccion de dependencias
  จจจจจจจจจจจจจจจจจจจจจจจจจ
1) Normalmente se prefiere trabajar con interfaces y NO con implementaciones (polimorfimo). 

2) ServicioA -> depende de RepositorioZ
	
	class ServicioA {
	
		private RepositorioZ repositorioZ;

		public ServicioA(RepositorioZ repositorioZ){
			this.repositorioZ = repositorioZ;
		}

		public void run(){
			repositorioZ.grabar();
		}

	}
	
3) Factory es un m้todo que crea un grafo de dependencias. 

Un grafo de dependencias es lo siguiente:

A -> B -> C -> D -> y asi sucesivamente.... una cadena de dependencias. 


4) Spring Factory o Spring-Core.
   AOP Aspect Oriented Programming
   Spring data JPA
   Spring Rest (Apis rest)
   Spring Security
   
   


*/


package clase20;

public class Clase20 {

}
