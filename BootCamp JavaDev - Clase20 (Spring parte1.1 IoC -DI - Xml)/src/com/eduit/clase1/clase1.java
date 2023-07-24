/*
									� SPRING FRAMEWORK
									  ����������������
Framework => Marco de trabajo que define una serie de lineamientos y reglas de como hacer las cosas. 
Spring es uno de ellos. 

Spring Framework es una plataforma de trabajo creada por Rod Johnson en el a�o 2003. Durante ese a�o Rod 
escribi� un libro titulado �Expert One-on-One J2EE Development without EJB�, en el cual hablo por 
primera vez de Spring y de las ventajas que supon�a este framework versus las tecnolog�as oficiales 
java existentes en esa �poca. Seria una alternativa a los proyectos Java EE.

Simplicidad, es la palabra que define el desarrollo a trav�s de Spring. Rod Johnson imagin� el desarrollo en 
Java de otra manera, m�s robusto y configurable, con m�s facilidades y posibilidades para los desarrolladores.
Esto se ve reflejado en este framework. La b�squeda de ser simple.
Springframework se basa en los est�ndares oficiales J2EE, pero nos da la ventaja de eliminar de nuestro 
c�digo la responsabilidad de toda creaci�n de objetos y paso de dependencias, por lo que tendremos 
un c�digo m�s limpio.
Es una plataforma que nos proporciona una infraestructura que act�a de soporte para desarrollar
aplicaciones Java. Spring maneja toda la infraestructura y as� te puedes centrar en tu aplicaci�n. 
Dici�ndolo m�s coloquialmente, Spring maneja a todos los componentes de la aplicaci�n, su ciclo de vida y la 
interacci�n entre ellos. Spring se va a encargar de construir, controlar y manejar todos los objetos, 
y gracias a ese controlador que nosotros le delegamos nos va a dar mas modularidad. 
Vamos a ampliar el alcance y funcionalidad de nuestras Clases sin tocar el c�digo. 
A trav�s de un archivo de Configuraci�n y un Contenedor, Spring va a poder gestionar los Objetos, inyectar las
dependencias y devolver lo que se le este solicitando. 

Normalmente cuando trabajamos en cualquier plataforma solemos utilizar alg�n tipo de framework. Estos son ni 
m�s ni menos que un conjunto de clases que nos facilitan el trabajo. Utilizamos el framework para crear el 
conjunto de objetos que nuestra aplicaci�n necesita.
En la mayor�a de las ocasiones para desarrollar aplicaciones no es suficiente usar un �nico framework sino que
necesitamos utilizar varios. Cada uno de los cuales generar� su propio conjunto de objetos.
Esta situaci�n genera problemas ya que cada framework es totalmente independiente y gestiona su propio ciclo de 
vida de los objetos.
Spring ayuda a solventar este problema ya que cambia las responsabilidades y en vez de que el propio desarrollador
sea el encargado de generar los objetos de cada uno de los frameworks, es Spring quien se encargar� de construir 
todos los objetos que la aplicaci�n va a utilizar.
Springframework, es un contenedor, pero no es solo un framewrok m�s. Es un contenedor que gestiona el ciclo de 
vida de los objetos y como se relacionan entre ellos. Proporciona una gran infraestructura que permite que el 
desarrollador se dedique m�s la l�gica de la aplicaci�n.
Es Ligero, es muy r�pido en tiempo de procesamiento y no es intrusivo a la hora de desarrollar. Esto �ltimo es 
uno de sus puntos m�s fuertes.
Est� orientado a aspectos, soporta la programaci�n orientada a aspectos, lo que permite facilitar una capa de 
servicios que son ideales para este tipo de programaci�n como auditor�a, o gesti�n de transacciones.


� Inyecci�n de Dependencias (DI)
  �������������������������
Originalmente la inyecci�n de dependencias se llamaba inversi�n de control (Muchos autores intercambian el mismo
concepto al hablar de ellas), pero en el 2004 Martin Fowler lleg� a la conclusi�n que realmente no se invert�a el 
control, sino las dependencias.
DI es un patr�n que de dise�o orientado a objetos en el que se suministran todos los Objetos a una Clase, en lugar de que la misma
Clase se encarge de crearlos. Spring va inyectar cada Objeto cuando sea necesario, evitando asi tener que encargarse de instaciar 
objetos desde la aplicaci�n. 
La DI (dependency injection) permite que un objeto conozca sus dependencias a trav�s una interfaz y no por su
implementaci�n. De esta forma, la implementaci�n puede variar sin que el objeto dependiente se d� cuenta. La gran
ventaja de la DI es el acoplamiento d�bil entre objetos.
El objetivo es lograr un bajo acoplamiento entre los objetos en nuestra aplicaci�n. Con este patr�n, los objetos 
no crean sus dependencias, sino que �stas son suministradas al objeto a trav�s de un tercero (El contenedor). El contenedor que
coordina cada objeto en el sistema, es el encargado de realizar este trabajo al momento de instanciar el objeto. Se invierte la 
responsabilidad en cuanto a la manera en que un objeto obtiene la referencia a otro objeto.
De esta manera, los objetos conocen sus dependencias por su interfaz. As� la dependencia puede ser intercambiada 
por distintas implementaciones a trav�s del contenedor. En resumen, programaremos orientado a interfaces e 
inyectaremos las implementaciones a trav�s del contenedor.

� Inversi�n de Control (IoC)
  ��������������������
Principio de Hollywood, no nos llames nosotros te llamaremos. Vamos a externalizar la construcci�n y el manejo de 
la aplicaci�n, es este caso, a trav�s de Spring. 
En ingl�s, conocido como Inversion of Control (IoC), es un estilo de programaci�n en el cual un framework o 
librer�a controla el flujo de un programa. Esto representa un cambio con respecto a paradigmas tradicionales 
donde el desarrollador especifica todo el flujo del programa.
Es el principio subyacente a la t�cnica de Inyecci�n de Dependencias, siendo t�rminos frecuentemente confundidos.
A trav�s del IoC y DI vamos a evitar la dependencias entre clases.


. Ventajas de DI/ IoC:
1. Eliminaci�n de instrucciones new: Al usar este tipo de patr�n, la primera consecuencia m�s observable a primera
vista es que el c�digo permitir� que las instancias inyectadas no se generar�n desde dentro a trav�s del uso de la
palabra �new� si no que se har�n por reflexi�n o mediante alg�n framework.
2. Sustituci�n de piezas software (Legos): Como se mencion� anteriormente, una ventaja es la posibilidad de
modificar una pieza de software por otra sin necesidad de reprogramar las clases que lo van a utilizar. Esto puede
ser interesante en desarrollos en los que es posible a�adir o quitar elementos variables como plugins.
3. Mejoras en los test: Debido a la no utilizaci�n de la instrucci�n new, se tendr� de una gran ventaja para el testeo
autom�tico de aplicaciones que consiste en hacer mocking. Esta t�cnica consiste en simular piezas de software
dependientes y reemplazarlas por otras m�s simples y m�s r�pidas para ejecutar multitud de test.
4. Depuraci�n de clases ya compiladas: Aunque se tiene grandes ventajas con el uso del mocking, muchas veces el
problema en los test es proveer lo que no se conoce. Caracteres ocultos, datos incorrectos, valores extra�os y
mucha informaci�n corrupta puede hacer que nuestro sistema no funcione bien y no lo hayamos previsto. En ese
caso los test autom�ticos no funcionar�n y tendremos que depurar el c�digo para encontrar ese misterioso
problema. Esto no es algo propio del patr�n de inyecci�n de dependencias, pero s� que el patr�n conduce o induce
a crear un dise�o modular y con componentes independientes y como consecuencia a crear diferentes proyectos
para cada m�dulo.
5. Configuraciones: Las configuraciones tambi�n son tareas a a�adir en el caso de utilizar inyecci�n de
dependencias. Al hacer la inyecci�n se traslada la responsabilidad de la instanciaci�n de un c�digo imperativo a
un c�digo declarativo. Estas declaraciones pueden ser de muchas formas como xml, anotaciones, archivos de
texto, bases de datos, etc. Depender� del framework o de nuestro propio algoritmo de inyecci�n el que se use
una forma u otra.

� BEANS
  �����
Es un componente de software que tiene la particularidad de ser reutilizable. En el lenguaje de programaci�n 
Java los vamos a asociar a Clases con los siguientes criterios obligatorios para que todo Bean pueda funcionar:  
- Tienen todos sus atributos privados (private).
- Tienen m�todos set() y get() p�blicos de los atributos privados que nos interese (encapsulamiento).
- Tienen un constructor p�blico por defecto.
 
 A diferencia de los beans tradicionales que representan una Clase, en Springframework adem�s son objetos creados
 y manejados por el contenedor Spring.
El contenedor se encuentra en el n�cleo del marco de trabajo de este y utiliza inyecci�n de dependencias para 
gestionar los componentes que forman la aplicaci�n. Se encarga de varias tareas, como crear, conectar y alojar 
los objetos definidos por los beans. Adem�s, hace de dispensador proporcionando beans por petici�n. El contenedor
se encarga de cargar las definiciones de beans.

Tipos de contenedor de Spring:
. Bean Factor: Contenedor sencillo con soporte b�sico de inyecci�n de dependencias.

. Aplication Context: Es una implementaci�n de un bean factory que proporciona opciones avanzadas como:
- Medios para resolver mensajes de texto e internalizacion,
- Publicaci�n de beans registrados como receptores o formas gen�ricas de abrir recursos de archivo.

Los beans de Springframwork tienen un ciclo de vida en el contexto de la aplicaci�n. Podemos ordenar las fases 
de la vida de un bean de la siguiente forma:
- Instanciaci�n.
- Inyecci�n de las propiedades.
- Nombre del Bean.
- Postprocesado (pre inicializacion)
- Inicializaci�n.
- Postprocesado (post inicializaci�n)
- Bean listo para uso.
- Destrucci�n.

Cuando trabajamos con un Bean en Springframework por defecto son singletons. Significa que el contenedor solo 
instancia un objeto de la clase, y cada vez que se pide una instancia del bean en realidad se obtiene una 
referencia al mismo objeto.
En el caso de cambiar el ambito de trabajo y necesitar mas de un Objeto de la Clase (con distinto hashcode) se 
puede cambiar a 'prototype'.

� ANOTACIONES @ 
  �����������
Las Anotaciones son etiqueas 'tag' que se a�aden y sirven para agregar metadatos en distintos lugares de una aplicaci�n en tiempo de
ejecuci�n. Los 'metadatos' son un conjunto de datos que describen el contenido y/o proposito de un objeto.
En Java entonces las Anotaciones ser�n formas de a�adir metadatos al c�digo fuente para que esten disponibles en tiempo de compilaci�n y 
ejecuci�n. Pueden a�adirse a los elementos de programa tales como clases, m�todos, campos, par�metros, variables locales, y paquetes.
Son bastantes mas pr�cticas a la hora de definir un archivo de configuraci�n que trabajar con un archivo xml. 

Springramework posee una lista de anotaciones, las m�s comunes:

@Bean, define un dentro del application context.
@Scope, indica el �mbito del Bean.
@Service, Indica que el Bean creado es un posible servicio.
@Component, Indica que el Bean creado es un posible componente.
@Repositoy, Indica que el Bean creado es un objeto de acceso a datos.
@Controller, Indica que el Bean creado es un componente Web.
@PostConstruct, Indica que el m�todo en el Bean ser� disparado luego de ser llamado el constructor de la clase.
@PreDestroy, Indica que el m�todo en el Bean sera disparado luego de ser eliminado el Bean del contexto.
@Autowired, Indica que el contexto debe de inicializar el argumento marcado en el Bean.


�. SINGLETON:
Por defecto los Beans trabajan utlizando un patr�n de dise�o SINGLETONE. Es un patr�n de dise�o que 
asegura que solo exista una �nica instancia (objeto) de la Clase que lo este implementando. Es decir, 
cada vez que se instancie un Objeto de la Clase como 'new', el mismo estar� apuntando a la misma 
posici�n de memoria (mismo hashcode). Claramente es una patr�n que tiene como principal ventaja el 
ahorro de recursos y va a brindar un control mas estricto de como se accede a la instancia de una Clase 
ya que en definitiva al trabajar con singletone trabajaremos con un punto de acceso �nico a un recurso 
centralizado en un Objeto.

�. PROTOTYPE:
Patron de dise�o que admite mas de una instancia por Clase. Es decir, que cada objeto creado como 'new' 
tendra su propia posici�n de Memoria (su propio hashcode).

*/

package com.eduit.clase1;

public class clase1 {

}
