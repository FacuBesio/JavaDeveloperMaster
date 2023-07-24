/*
 • Principio de Inversión de Dependencia (DIP)
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
. Los módulos de alto nivel no deben depender de los módulos de bajo nivel.

. Hay que hacer mas enfoque en las Abstracciones que las Implementaciones.
Un software debe estar totalmente desacoplado, no debe depender de una implementacion o una Clase en particular.
Bajo esta premisa se podra crear código desacoplado permitiendo cambiar de tecnología o implentaciones 
fácilmente sin perjudicar el flujo principal por el que se desarrollando el programa.

. El patrón Inversión de Control (IoC) es una aplicación de este principio. 
Principio de Hollywood. 'No nos llames, nosotros te llamamos'.

• Inyección de Dependencias(DI):
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
. Patrón de diseño de Software. 
. Es un Subtipo de IoC
. El Objetivo es tener un código facil de mantener. 
. Provee a los objetos lo que el objeto necesita.

Hay 3 estilos de como hacer una Inyección de Dependencias. Puede ser por
Constructor, Propiedad(set) o Servicio/Interfaz.

Cuando inyectamos la instacia del atributo a través del Constructor estamos realizando el principio básico 
de una inyección de dependencia. 

	public class Customer {
	
		Object atributo;
	
		public Customer(Object atributo) {
			this.atributo = atributo;
		} 
	}
	
A través del uso de Interfaces como atributos podemos definir que se estará esperando un Objeto de Clase 
que implemente la interfaz. Es decir, que cualquier objeto que implemente la Interfaz sera válido para 
ingresar como atributo. De esta forma se realiza un código mas desacoplado ya que se deja de depender de
una Clase en particular y se puede programar de una forma mas abstracta haciendo referencia a una Interfaz.
Se hace mas enfoque en las Abstracciones que en las Implementaciones.

	public class Messi {
		
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
		
	}


•. Spring Core Container
Es un IoC Container. No es necesario tener un Container para poder utilizar IoC pero es recomendable ya que
con el uso de un Container vamos a poder gestionar el ciclo de vida de los objetos (beans) de una forma más
organizada. Es decir, poder gestionar de una mejor manera la creación, enlaces, configuración y destrucción de
estos Objetos. En Spring a estos Objetos 'gestionados' se los conoce como Beans.  
 





  */

package mito.code.inyeccionDeDependencias;

public class texto {

}
