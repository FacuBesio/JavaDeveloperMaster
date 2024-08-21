/*
													LIBRERIAS
					   								¨¨¨¨¨¨¨¨¨
En Java, como en muchos otros lenguajes de programación, existe el concepto de librería:
Un conjunto de clases que poseen métodos y atributos para un propósito particular. Para recurrir a una librería interna o externa en Java debemos utilizar la palabra reservada 'import' seguida del nombre de la clase y el paquete donde se encuentra. 
Como por ejemplo: 

import java.util.Scanner;

Nuestros proyectos tienen JRE System Library que contiene las librerías que ofrece Java. Algo particular que pasa en Java es que hay clases que no necesitan importarse, como cuando utilizamos System.out.print. Esto se debe a que esta clase se encuentra dentro del paquete 'java.lang' y no necesitamos importarla. En cambio, con las otras librerías debemos hacerlo siempre.


● SCANNER:
Hay una utilidad que nos ayuda a capturar los datos de la consola, para ello debemos importar la biblioteca 'java.util.Scanner'.
Para poder obtener los datos ingresados por el usuario debemos crear este elemento con la siguiente estructura:

	Scanner nombrevariable = new Scanner(System.in); 

Cada vez que usemos uno de los métodos de la clase scanner, la consola quedará esperando que el usuario ingrese información. 
Para poder recibir un dato que se ingrese por consola, se utiliza la sentencia 'nombrevariable.nextTipoDeDato();' y para 
que dicha información quede registrada en memoria se asignara a una variable.
Por ejemplo:
	
	a = nombrevariable.nextTipoDeDato();
	
      
En el momento en el se ejecuta 'nextTipoDeDato' el programa se quedara detenido esperando que se ingrese por consola un dato. Para finalizar el ingreso y confirmar el mismo debe presionar 'enter', en ese momento el dato será enviado a nuestro compilador y el mismo se guardará en la 'variable' indicada. Es recomendable mostrar por pantalla qué dato debe ingresar, ya que la Clase
Scanner posee un metodo diferente para recibir cada tipo de Dato.

Es decir para datos númericos:   	'variable.nextByte();'
                					'variable.nextShort();'      
					                'variable.nextInt();'        
					                'variable.nextLong();'                                                                                           
					                'variable.nextFloat();'
					                'variable.nextDouble();'

y para datos de Texto:   			'variable.next();'
									'variable.nextLine();'
									
									'variable.close();'
									
Es importante recordar que si se recibe un número a través de los métodos next() o nextline(), y se desea realizar operacines con dicho
dato, se debera castear el valor. 

*/

package Clase01;

import java.util.Scanner;

public class Librerias_Scanner {

	public static void main(String[] args) {

		// ● INGRESO DE TEXTO "":

		Scanner teclado = new Scanner(System.in);

		String txtIn;

		System.out.println("Ingrese Texto: ");
		txtIn = teclado.nextLine();

		System.out.println("Texto ingresado: " + txtIn);

		// ● INGRESO DE NÚMEROS "":

		System.out.println("");

		int numIn;

		System.out.println("Ingrese Numero: ");
		numIn = teclado.nextInt();

		System.out.println("Numero ingresado: " + numIn);

		System.out.println("++numIn: " + ++numIn);

	}

}
