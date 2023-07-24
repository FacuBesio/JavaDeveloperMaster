/*
 � Principio de Inversi�n de Dependencia (DIP)
  ��������������������������������������������
. Los m�dulos de alto nivel no deben depender de los m�dulos de bajo nivel.

. Hay que hacer mas enfoque en las Abstracciones que las Implementaciones.
Un software debe estar totalmente desacoplado, no debe depender de una implementacion o una Clase en particular.
Bajo esta premisa se podra crear c�digo desacoplado permitiendo cambiar de tecnolog�a o implentaciones 
f�cilmente sin perjudicar el flujo principal por el que se desarrollando el programa.

. El patr�n Inversi�n de Control (IoC) es una aplicaci�n de este principio. 
Principio de Hollywood. 'No nos llames, nosotros te llamamos'.

� Inyecci�n de Dependencias(DI):
  �����������������������������
. Patr�n de dise�o de Software. 
. Es un Subtipo de IoC
. El Objetivo es tener un c�digo facil de mantener. 
. Provee a los objetos lo que el objeto necesita.

Hay 3 estilos de como hacer una Inyecci�n de Dependencias. Puede ser por
Constructor, Propiedad(set) o Servicio/Interfaz.

Cuando inyectamos la instacia del atributo a trav�s del Constructor estamos realizando el principio b�sico 
de una inyecci�n de dependencia. 

	public class Customer {
	
		Object atributo;
	
		public Customer(Object atributo) {
			this.atributo = atributo;
		} 
	}
	
A trav�s del uso de Interfaces como atributos podemos definir que se estar� esperando un Objeto de Clase 
que implemente la interfaz. Es decir, que cualquier objeto que implemente la Interfaz sera v�lido para 
ingresar como atributo. De esta forma se realiza un c�digo mas desacoplado ya que se deja de depender de
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


�. Spring Core Container
Es un IoC Container. No es necesario tener un Container para poder utilizar IoC pero es recomendable ya que
con el uso de un Container vamos a poder gestionar el ciclo de vida de los objetos (beans) de una forma m�s
organizada. Es decir, poder gestionar de una mejor manera la creaci�n, enlaces, configuraci�n y destrucci�n de
estos Objetos. En Spring a estos Objetos 'gestionados' se los conoce como Beans.  
 





  */

package mito.code.inyeccionDeDependencias;

public class texto {

}
