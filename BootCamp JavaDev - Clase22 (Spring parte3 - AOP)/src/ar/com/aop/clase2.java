/*
					  • PROGRAMACIÓN ORIENTADA A ASPECTOS (Aspect Oriented Programming - AOP)
						¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
La Programación Orientada a Aspectos AOP (Aspect Oriented Programming) es un paradigma de programación
relativamente reciente cuya intención es permitir una adecuada modularización de las aplicaciones y posibilitar 
una mejor separación de responsabilidades.
Gracias a la AOP se pueden encapsular los diferentes conceptos que componen una aplicación en entidades bien
definidas, eliminando las dependencias entre cada uno de los módulos. De esta forma se consigue razonar mejor 
sobre los conceptos, se elimina la dispersión del código y las implementaciones resultan más comprensibles, 
adaptables y reusables.
La programación orientada a objetos (OOP) supuso un gran paso en la ingeniería del software, ya que presentaba 
un modelo de objetos que parecía encajar de manera adecuada con los problemas reales. La cuestión era saber
descomponer de la mejor manera el dominio del problema al que nos enfrentáramos, encapsulando cada concepto en lo
que se dicen llamar objetos y haciéndoles interactuar entre ellos, habiéndoles dotado de una serie de propiedades.
Surgieron así numerosas metodologías para ayudar en tal proceso de descomposición y aparecieron herramientas que
incluso automatizaban parte del proceso. Esto no ha cambiado y se sigue haciendo en el proceso de desarrollo del
software. Sin embargo, frecuentemente la relación entre la complejidad de la solución y el problema resuelto hace 
pensar en la necesidad de un nuevo cambio. Así pues, nos encontramos con muchos problemas donde la OOP no es 
suficiente para capturar de una manera clara todas las propiedades y comportamientos de lo que queremos dotar 
nuestra aplicación. Así mismo, la programación procedural tampoco nos soluciona el problema. Por lo que ante tales
problemas, se utiliza la AOP.
Los conceptos y tecnologías reunidos bajo el nombre “programación orientada a aspectos” buscan resolver un 
problema identificado hace tiempo en el desarrollo de software. Se trata del problema de la separación de 
incumbencias (concerns).
La programación orientada a aspectos (POA) es una nueva metodología de programación que aspira a soportar la
separación de competencias para los aspectos antes mencionados. Es decir, que intenta separar los componentes y 
los aspectos unos de otros, proporcionando mecanismos que hagan posible abstraerlos y componerlos para formar todo 
el sistema. En definitiva, lo que se persigue es implementar una aplicación de forma eficiente y fácil de 
entender.
AOP es un desarrollo que sigue al paradigma de la programación orientada a objetos, y como tal, soporta la descomposición 
orientada a objetos, además de la procedimental y la descomposición funcional. Pero, a pesar de esto, AOP no se 
puede considerar como una extensión de la OOP, ya que puede utilizarse con los diferentes estilos de programación 
ya mencionados.

•. PRINCIPIO DE SEPARACIÓN DE INCUMBENCIAS (CONCERNS)
El principio de separación de incumbencias fue identificado en los años 70, plantea que un problema dado 
involucra varias incumbencias que deben ser identificadas y separadas. Las incumbencias son los diferentes temas 
o asuntos de los que es necesario ocuparse para resolver el problema. Una de ellas es la función específica que 
debe realizar una aplicación, pero también surgen otras como por ejemplo distribución, persistencia, replicación, 
sincronización, etc. Separando las incumbencias, se disminuye la complejidad a la hora de tratarlas y se puede 
cumplir con requerimientos relacionados con la calidad como adaptabilidad, mantenibilidad, extensibilidad y 
reusabilidad.
El principio puede aplicarse de distintas maneras. Por ejemplo, separar las fases del proceso de desarrollo puede 
verse como una separación de actividades de ingeniería en el tiempo y por su objetivo. Definir subsistemas, 
objetos y componentes son otras formas de poner en práctica el principio de separación de incumbencias. Por eso 
podemos decir que se trata de un principio rector omnipresente en el proceso de desarrollo de software.
Las técnicas de modelado que se usan en la etapa de diseño de un sistema se basan en partirlo en varios 
subsistemas que resuelvan parte del problema o correspondan a una parte del dominio sobre el que trata. La 
desventaja de estas particiones es que muchas de las incumbencias a tener en cuenta para cumplir con los 
requerimientos no suelen adaptarse bien a esa descomposición.
El problema aparece cuando una incumbencia afecta a distintas partes del sistema que no aparecen relacionadas en 
la jerarquía. En ese caso, la única solución suele ser escribir código repetido que resuelva esa incumbencia para 
cada subsistema.
La programación orientada a aspectos intenta formalizar y representar de forma concisa los elementos que son
transversales a todo el sistema. En los lenguajes orientados a objetos, la estructura del sistema se basa en la 
idea de clases y jerarquías de clases. La herencia permite modularizar el sistema, eliminando la necesidad de 
duplicar código. No obstante, siempre hay aspectos que son transversales a esta estructura: el ejemplo más 
clásico es el de control de permisos de ejecución de ciertos métodos en una clase.
Estructurando adecuadamente el programa se puede minimizar la repetición de código, pero es prácticamente 
imposible eliminarla. La situación se agravaría si además tuviéramos que controlar permisos en objetos de varias 
clases. El problema es que en un lenguaje orientado a objetos los aspectos transversales a la jerarquía de clases 
no son modularizables ni se pueden formular de manera concisa con las construcciones del lenguaje. La programación
orientada a aspectos intenta formular conceptos y diseñar construcciones del lenguaje que permitan modelar estos 
aspectos transversales sin duplicación de código.

En AOP, a los elementos que son transversales a la estructura del sistema y se pueden modularizar gracias a las
construcciones que aporta el paradigma se les denomina aspectos (aspects). En el ejemplo anterior el control de
permisos de ejecución, modularizado mediante AOP, sería un aspecto.
Un consejo (advice) es una acción que hay que ejecutar en determinado/s punto/s de un código, para conseguir
implementar un aspecto. En el ejemplo, la acción a ejecutar sería la llamada a chequeaPermisos(). El conjunto de 
puntos del código donde se debe ejecutar un advice se conoce como punto de corte o pointcut.
Un punto de corte o pointcut es un punto de interés en el código antes, después o "alrededor" del cual queremos 
ejecutar algo (un advice). Es importante destacar que al definir un pointcut realmente no estamos todavía diciendo
que vayamos a ejecutar nada, simplemente marcamos un "punto de interés". La combinación de pointcut + advice es la
que realmente hace algo útil.

Spring posee un muy buen módulo de AOP y siguiendo la filosofía de no reinventar la rueda, los desarrolladores de
Spring han considerado que no era necesaria una sintaxis propia existiendo la de AspectJ ampliamente probado en la
práctica. Hay que tener presente que no es lo mismo usar la sintaxis de AspectJ que usar AspectJ en sí.
Hay dos sintaxis alternativas para usar AOP en Spring. Una es mediante el uso de anotaciones en el propio código 
Java. La otra es con etiquetas en un archivo de configuración. Sin embargo, usando anotaciones podemos encapsular 
el AOP junto con el código Java en un único lugar.
Para añadir soporte AOP a un proyecto Spring necesitaremos son necesarias 2 librerías: aspectjweaver.jar, y
aspectjrt.jar. Además, si se quiere usar AOP con clases que no implementen ningún interface, se necesitaria la 
librería CGLIB.

Para hacer un programa orientado a aspectos se necesita definir los siguientes elementos:
1. Un lenguaje para definir la funcionalidad básica. Este lenguaje se conoce como lenguaje base. Suele ser un
lenguaje de propósito general, tal como C++ o Java.
2. El lenguaje de aspectos define la forma de los aspectos – por ejemplo, los aspectos de AspectJ se programan de
forma muy parecida a las clases en Java.
3. El compilador se encargará de combinar los lenguajes. El proceso de mezcla se puede retrasar para hacerse en
tiempo de ejecución, o hacerse en tiempo de compilación.
*/

package ar.com.aop;

public class clase2 {

}
