/*
					  � PROGRAMACI�N ORIENTADA A ASPECTOS (Aspect Oriented Programming - AOP)
						���������������������������������
La Programaci�n Orientada a Aspectos AOP (Aspect Oriented Programming) es un paradigma de programaci�n
relativamente reciente cuya intenci�n es permitir una adecuada modularizaci�n de las aplicaciones y posibilitar 
una mejor separaci�n de responsabilidades.
Gracias a la AOP se pueden encapsular los diferentes conceptos que componen una aplicaci�n en entidades bien
definidas, eliminando las dependencias entre cada uno de los m�dulos. De esta forma se consigue razonar mejor 
sobre los conceptos, se elimina la dispersi�n del c�digo y las implementaciones resultan m�s comprensibles, 
adaptables y reusables.
La programaci�n orientada a objetos (OOP) supuso un gran paso en la ingenier�a del software, ya que presentaba 
un modelo de objetos que parec�a encajar de manera adecuada con los problemas reales. La cuesti�n era saber
descomponer de la mejor manera el dominio del problema al que nos enfrent�ramos, encapsulando cada concepto en lo
que se dicen llamar objetos y haci�ndoles interactuar entre ellos, habi�ndoles dotado de una serie de propiedades.
Surgieron as� numerosas metodolog�as para ayudar en tal proceso de descomposici�n y aparecieron herramientas que
incluso automatizaban parte del proceso. Esto no ha cambiado y se sigue haciendo en el proceso de desarrollo del
software. Sin embargo, frecuentemente la relaci�n entre la complejidad de la soluci�n y el problema resuelto hace 
pensar en la necesidad de un nuevo cambio. As� pues, nos encontramos con muchos problemas donde la OOP no es 
suficiente para capturar de una manera clara todas las propiedades y comportamientos de lo que queremos dotar 
nuestra aplicaci�n. As� mismo, la programaci�n procedural tampoco nos soluciona el problema. Por lo que ante tales
problemas, se utiliza la AOP.
Los conceptos y tecnolog�as reunidos bajo el nombre �programaci�n orientada a aspectos� buscan resolver un 
problema identificado hace tiempo en el desarrollo de software. Se trata del problema de la separaci�n de 
incumbencias (concerns).
La programaci�n orientada a aspectos (POA) es una nueva metodolog�a de programaci�n que aspira a soportar la
separaci�n de competencias para los aspectos antes mencionados. Es decir, que intenta separar los componentes y 
los aspectos unos de otros, proporcionando mecanismos que hagan posible abstraerlos y componerlos para formar todo 
el sistema. En definitiva, lo que se persigue es implementar una aplicaci�n de forma eficiente y f�cil de 
entender.
AOP es un desarrollo que sigue al paradigma de la programaci�n orientada a objetos, y como tal, soporta la descomposici�n 
orientada a objetos, adem�s de la procedimental y la descomposici�n funcional. Pero, a pesar de esto, AOP no se 
puede considerar como una extensi�n de la OOP, ya que puede utilizarse con los diferentes estilos de programaci�n 
ya mencionados.

�. PRINCIPIO DE SEPARACI�N DE INCUMBENCIAS (CONCERNS)
El principio de separaci�n de incumbencias fue identificado en los a�os 70, plantea que un problema dado 
involucra varias incumbencias que deben ser identificadas y separadas. Las incumbencias son los diferentes temas 
o asuntos de los que es necesario ocuparse para resolver el problema. Una de ellas es la funci�n espec�fica que 
debe realizar una aplicaci�n, pero tambi�n surgen otras como por ejemplo distribuci�n, persistencia, replicaci�n, 
sincronizaci�n, etc. Separando las incumbencias, se disminuye la complejidad a la hora de tratarlas y se puede 
cumplir con requerimientos relacionados con la calidad como adaptabilidad, mantenibilidad, extensibilidad y 
reusabilidad.
El principio puede aplicarse de distintas maneras. Por ejemplo, separar las fases del proceso de desarrollo puede 
verse como una separaci�n de actividades de ingenier�a en el tiempo y por su objetivo. Definir subsistemas, 
objetos y componentes son otras formas de poner en pr�ctica el principio de separaci�n de incumbencias. Por eso 
podemos decir que se trata de un principio rector omnipresente en el proceso de desarrollo de software.
Las t�cnicas de modelado que se usan en la etapa de dise�o de un sistema se basan en partirlo en varios 
subsistemas que resuelvan parte del problema o correspondan a una parte del dominio sobre el que trata. La 
desventaja de estas particiones es que muchas de las incumbencias a tener en cuenta para cumplir con los 
requerimientos no suelen adaptarse bien a esa descomposici�n.
El problema aparece cuando una incumbencia afecta a distintas partes del sistema que no aparecen relacionadas en 
la jerarqu�a. En ese caso, la �nica soluci�n suele ser escribir c�digo repetido que resuelva esa incumbencia para 
cada subsistema.
La programaci�n orientada a aspectos intenta formalizar y representar de forma concisa los elementos que son
transversales a todo el sistema. En los lenguajes orientados a objetos, la estructura del sistema se basa en la 
idea de clases y jerarqu�as de clases. La herencia permite modularizar el sistema, eliminando la necesidad de 
duplicar c�digo. No obstante, siempre hay aspectos que son transversales a esta estructura: el ejemplo m�s 
cl�sico es el de control de permisos de ejecuci�n de ciertos m�todos en una clase.
Estructurando adecuadamente el programa se puede minimizar la repetici�n de c�digo, pero es pr�cticamente 
imposible eliminarla. La situaci�n se agravar�a si adem�s tuvi�ramos que controlar permisos en objetos de varias 
clases. El problema es que en un lenguaje orientado a objetos los aspectos transversales a la jerarqu�a de clases 
no son modularizables ni se pueden formular de manera concisa con las construcciones del lenguaje. La programaci�n
orientada a aspectos intenta formular conceptos y dise�ar construcciones del lenguaje que permitan modelar estos 
aspectos transversales sin duplicaci�n de c�digo.

En AOP, a los elementos que son transversales a la estructura del sistema y se pueden modularizar gracias a las
construcciones que aporta el paradigma se les denomina aspectos (aspects). En el ejemplo anterior el control de
permisos de ejecuci�n, modularizado mediante AOP, ser�a un aspecto.
Un consejo (advice) es una acci�n que hay que ejecutar en determinado/s punto/s de un c�digo, para conseguir
implementar un aspecto. En el ejemplo, la acci�n a ejecutar ser�a la llamada a chequeaPermisos(). El conjunto de 
puntos del c�digo donde se debe ejecutar un advice se conoce como punto de corte o pointcut.
Un punto de corte o pointcut es un punto de inter�s en el c�digo antes, despu�s o "alrededor" del cual queremos 
ejecutar algo (un advice). Es importante destacar que al definir un pointcut realmente no estamos todav�a diciendo
que vayamos a ejecutar nada, simplemente marcamos un "punto de inter�s". La combinaci�n de pointcut + advice es la
que realmente hace algo �til.

Spring posee un muy buen m�dulo de AOP y siguiendo la filosof�a de no reinventar la rueda, los desarrolladores de
Spring han considerado que no era necesaria una sintaxis propia existiendo la de AspectJ ampliamente probado en la
pr�ctica. Hay que tener presente que no es lo mismo usar la sintaxis de AspectJ que usar AspectJ en s�.
Hay dos sintaxis alternativas para usar AOP en Spring. Una es mediante el uso de anotaciones en el propio c�digo 
Java. La otra es con etiquetas en un archivo de configuraci�n. Sin embargo, usando anotaciones podemos encapsular 
el AOP junto con el c�digo Java en un �nico lugar.
Para a�adir soporte AOP a un proyecto Spring necesitaremos son necesarias 2 librer�as: aspectjweaver.jar, y
aspectjrt.jar. Adem�s, si se quiere usar AOP con clases que no implementen ning�n interface, se necesitaria la 
librer�a CGLIB.

Para hacer un programa orientado a aspectos se necesita definir los siguientes elementos:
1. Un lenguaje para definir la funcionalidad b�sica. Este lenguaje se conoce como lenguaje base. Suele ser un
lenguaje de prop�sito general, tal como C++ o Java.
2. El lenguaje de aspectos define la forma de los aspectos � por ejemplo, los aspectos de AspectJ se programan de
forma muy parecida a las clases en Java.
3. El compilador se encargar� de combinar los lenguajes. El proceso de mezcla se puede retrasar para hacerse en
tiempo de ejecuci�n, o hacerse en tiempo de compilaci�n.
*/

package ar.com.aop;

public class clase2 {

}
