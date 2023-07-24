/*
									• SPRING FRAMEWORK
									  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Framework => Marco de trabajo que define una serie de lineamientos y reglas de como hacer las cosas. 
Spring es uno de ellos. 

Spring Framework es una plataforma de trabajo creada por Rod Johnson en el año 2003. Durante ese año Rod 
escribió un libro titulado “Expert One-on-One J2EE Development without EJB”, en el cual hablo por 
primera vez de Spring y de las ventajas que suponía este framework versus las tecnologías oficiales 
java existentes en esa época. Seria una alternativa a los proyectos Java EE.

Simplicidad, es la palabra que define el desarrollo a través de Spring. Rod Johnson imaginó el desarrollo en 
Java de otra manera, más robusto y configurable, con más facilidades y posibilidades para los desarrolladores.
Esto se ve reflejado en este framework. La búsqueda de ser simple.
Springframework se basa en los estándares oficiales J2EE, pero nos da la ventaja de eliminar de nuestro 
código la responsabilidad de toda creación de objetos y paso de dependencias, por lo que tendremos 
un código más limpio.
Es una plataforma que nos proporciona una infraestructura que actúa de soporte para desarrollar
aplicaciones Java. Spring maneja toda la infraestructura y así te puedes centrar en tu aplicación. 
Diciéndolo más coloquialmente, Spring maneja a todos los componentes de la aplicación, su ciclo de vida y la 
interacción entre ellos. Spring se va a encargar de construir, controlar y manejar todos los objetos, 
y gracias a ese controlador que nosotros le delegamos nos va a dar mas modularidad. 
Vamos a ampliar el alcance y funcionalidad de nuestras Clases sin tocar el código. 
A través de un archivo de Configuración y un Contenedor, Spring va a poder gestionar los Objetos, inyectar las
dependencias y devolver lo que se le este solicitando. 

Normalmente cuando trabajamos en cualquier plataforma solemos utilizar algún tipo de framework. Estos son ni 
más ni menos que un conjunto de clases que nos facilitan el trabajo. Utilizamos el framework para crear el 
conjunto de objetos que nuestra aplicación necesita.
En la mayoría de las ocasiones para desarrollar aplicaciones no es suficiente usar un único framework sino que
necesitamos utilizar varios. Cada uno de los cuales generará su propio conjunto de objetos.
Esta situación genera problemas ya que cada framework es totalmente independiente y gestiona su propio ciclo de 
vida de los objetos.
Spring ayuda a solventar este problema ya que cambia las responsabilidades y en vez de que el propio desarrollador
sea el encargado de generar los objetos de cada uno de los frameworks, es Spring quien se encargará de construir 
todos los objetos que la aplicación va a utilizar.
Springframework, es un contenedor, pero no es solo un framewrok más. Es un contenedor que gestiona el ciclo de 
vida de los objetos y como se relacionan entre ellos. Proporciona una gran infraestructura que permite que el 
desarrollador se dedique más la lógica de la aplicación.
Es Ligero, es muy rápido en tiempo de procesamiento y no es intrusivo a la hora de desarrollar. Esto último es 
uno de sus puntos más fuertes.
Está orientado a aspectos, soporta la programación orientada a aspectos, lo que permite facilitar una capa de 
servicios que son ideales para este tipo de programación como auditoría, o gestión de transacciones.


• Inyección de Dependencias (DI)
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Originalmente la inyección de dependencias se llamaba inversión de control (Muchos autores intercambian el mismo
concepto al hablar de ellas), pero en el 2004 Martin Fowler llegó a la conclusión que realmente no se invertía el 
control, sino las dependencias.
DI es un patrón que de diseño orientado a objetos en el que se suministran todos los Objetos a una Clase, en lugar de que la misma
Clase se encarge de crearlos. Spring va inyectar cada Objeto cuando sea necesario, evitando asi tener que encargarse de instaciar 
objetos desde la aplicación. 
La DI (dependency injection) permite que un objeto conozca sus dependencias a través una interfaz y no por su
implementación. De esta forma, la implementación puede variar sin que el objeto dependiente se dé cuenta. La gran
ventaja de la DI es el acoplamiento débil entre objetos.
El objetivo es lograr un bajo acoplamiento entre los objetos en nuestra aplicación. Con este patrón, los objetos 
no crean sus dependencias, sino que éstas son suministradas al objeto a través de un tercero (El contenedor). El contenedor que
coordina cada objeto en el sistema, es el encargado de realizar este trabajo al momento de instanciar el objeto. Se invierte la 
responsabilidad en cuanto a la manera en que un objeto obtiene la referencia a otro objeto.
De esta manera, los objetos conocen sus dependencias por su interfaz. Así la dependencia puede ser intercambiada 
por distintas implementaciones a través del contenedor. En resumen, programaremos orientado a interfaces e 
inyectaremos las implementaciones a través del contenedor.

• Inversión de Control (IoC)
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Principio de Hollywood, no nos llames nosotros te llamaremos. Vamos a externalizar la construcción y el manejo de 
la aplicación, es este caso, a través de Spring. 
En inglés, conocido como Inversion of Control (IoC), es un estilo de programación en el cual un framework o 
librería controla el flujo de un programa. Esto representa un cambio con respecto a paradigmas tradicionales 
donde el desarrollador especifica todo el flujo del programa.
Es el principio subyacente a la técnica de Inyección de Dependencias, siendo términos frecuentemente confundidos.
A través del IoC y DI vamos a evitar la dependencias entre clases.


. Ventajas de DI/ IoC:
1. Eliminación de instrucciones new: Al usar este tipo de patrón, la primera consecuencia más observable a primera
vista es que el código permitirá que las instancias inyectadas no se generarán desde dentro a través del uso de la
palabra “new” si no que se harán por reflexión o mediante algún framework.
2. Sustitución de piezas software (Legos): Como se mencionó anteriormente, una ventaja es la posibilidad de
modificar una pieza de software por otra sin necesidad de reprogramar las clases que lo van a utilizar. Esto puede
ser interesante en desarrollos en los que es posible añadir o quitar elementos variables como plugins.
3. Mejoras en los test: Debido a la no utilización de la instrucción new, se tendrá de una gran ventaja para el testeo
automático de aplicaciones que consiste en hacer mocking. Esta técnica consiste en simular piezas de software
dependientes y reemplazarlas por otras más simples y más rápidas para ejecutar multitud de test.
4. Depuración de clases ya compiladas: Aunque se tiene grandes ventajas con el uso del mocking, muchas veces el
problema en los test es proveer lo que no se conoce. Caracteres ocultos, datos incorrectos, valores extraños y
mucha información corrupta puede hacer que nuestro sistema no funcione bien y no lo hayamos previsto. En ese
caso los test automáticos no funcionarán y tendremos que depurar el código para encontrar ese misterioso
problema. Esto no es algo propio del patrón de inyección de dependencias, pero sí que el patrón conduce o induce
a crear un diseño modular y con componentes independientes y como consecuencia a crear diferentes proyectos
para cada módulo.
5. Configuraciones: Las configuraciones también son tareas a añadir en el caso de utilizar inyección de
dependencias. Al hacer la inyección se traslada la responsabilidad de la instanciación de un código imperativo a
un código declarativo. Estas declaraciones pueden ser de muchas formas como xml, anotaciones, archivos de
texto, bases de datos, etc. Dependerá del framework o de nuestro propio algoritmo de inyección el que se use
una forma u otra.

• BEANS
  ¨¨¨¨¨
Es un componente de software que tiene la particularidad de ser reutilizable. En el lenguaje de programación 
Java los vamos a asociar a Clases con los siguientes criterios obligatorios para que todo Bean pueda funcionar:  
- Tienen todos sus atributos privados (private).
- Tienen métodos set() y get() públicos de los atributos privados que nos interese (encapsulamiento).
- Tienen un constructor público por defecto.
 
 A diferencia de los beans tradicionales que representan una Clase, en Springframework además son objetos creados
 y manejados por el contenedor Spring.
El contenedor se encuentra en el núcleo del marco de trabajo de este y utiliza inyección de dependencias para 
gestionar los componentes que forman la aplicación. Se encarga de varias tareas, como crear, conectar y alojar 
los objetos definidos por los beans. Además, hace de dispensador proporcionando beans por petición. El contenedor
se encarga de cargar las definiciones de beans.

Tipos de contenedor de Spring:
. Bean Factor: Contenedor sencillo con soporte básico de inyección de dependencias.

. Aplication Context: Es una implementación de un bean factory que proporciona opciones avanzadas como:
- Medios para resolver mensajes de texto e internalizacion,
- Publicación de beans registrados como receptores o formas genéricas de abrir recursos de archivo.

Los beans de Springframwork tienen un ciclo de vida en el contexto de la aplicación. Podemos ordenar las fases 
de la vida de un bean de la siguiente forma:
- Instanciación.
- Inyección de las propiedades.
- Nombre del Bean.
- Postprocesado (pre inicializacion)
- Inicialización.
- Postprocesado (post inicialización)
- Bean listo para uso.
- Destrucción.

Cuando trabajamos con un Bean en Springframework por defecto son singletons. Significa que el contenedor solo 
instancia un objeto de la clase, y cada vez que se pide una instancia del bean en realidad se obtiene una 
referencia al mismo objeto.
En el caso de cambiar el ambito de trabajo y necesitar mas de un Objeto de la Clase (con distinto hashcode) se 
puede cambiar a 'prototype'.

• ANOTACIONES @ 
  ¨¨¨¨¨¨¨¨¨¨¨
Las Anotaciones son etiqueas 'tag' que se añaden y sirven para agregar metadatos en distintos lugares de una aplicación en tiempo de
ejecución. Los 'metadatos' son un conjunto de datos que describen el contenido y/o proposito de un objeto.
En Java entonces las Anotaciones serán formas de añadir metadatos al código fuente para que esten disponibles en tiempo de compilación y 
ejecución. Pueden añadirse a los elementos de programa tales como clases, métodos, campos, parámetros, variables locales, y paquetes.
Son bastantes mas prácticas a la hora de definir un archivo de configuración que trabajar con un archivo xml. 

Springramework posee una lista de anotaciones, las más comunes:

@Bean, define un dentro del application context.
@Scope, indica el ámbito del Bean.
@Service, Indica que el Bean creado es un posible servicio.
@Component, Indica que el Bean creado es un posible componente.
@Repositoy, Indica que el Bean creado es un objeto de acceso a datos.
@Controller, Indica que el Bean creado es un componente Web.
@PostConstruct, Indica que el método en el Bean será disparado luego de ser llamado el constructor de la clase.
@PreDestroy, Indica que el método en el Bean sera disparado luego de ser eliminado el Bean del contexto.
@Autowired, Indica que el contexto debe de inicializar el argumento marcado en el Bean.


•. SINGLETON:
Por defecto los Beans trabajan utlizando un patrón de diseño SINGLETONE. Es un patrón de diseño que 
asegura que solo exista una única instancia (objeto) de la Clase que lo este implementando. Es decir, 
cada vez que se instancie un Objeto de la Clase como 'new', el mismo estará apuntando a la misma 
posición de memoria (mismo hashcode). Claramente es una patrón que tiene como principal ventaja el 
ahorro de recursos y va a brindar un control mas estricto de como se accede a la instancia de una Clase 
ya que en definitiva al trabajar con singletone trabajaremos con un punto de acceso único a un recurso 
centralizado en un Objeto.

•. PROTOTYPE:
Patron de diseño que admite mas de una instancia por Clase. Es decir, que cada objeto creado como 'new' 
tendra su propia posición de Memoria (su propio hashcode).

*/

package com.eduit.clase1;

public class clase1 {

}
