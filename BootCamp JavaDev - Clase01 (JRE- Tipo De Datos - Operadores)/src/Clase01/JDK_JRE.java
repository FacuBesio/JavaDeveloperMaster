/*                                     	 ● BOOTCAMP JAVA DEVELOPER - CLASE 1 ●

          											♦ JAVA ♦

JAVA es un lenguaje de programación desarrollado en la decada del 90' por un equipo liderado por JAMES GOSLING dentro de la 
Compañia 'Sun Microsystems'. Posteriormente dicha Compañia fue adquirida por Oracle en 2010.
La primera versión de JAVA fue públicada entre 1995 y 1996. A lo largo de los años se han ido desarrollado muchas herramientas 
dentro del lenguaje para cumplir con un determinado objetivo en particular. 

• JRE & JVM: Java Runtime Enviroinment & Java Virtual Machine:
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Lo que hizo popular al lenguaje Java fue su capacidad para trabajar bajo la premisa de WORA, 'write once, run anywhere' (escribir una vez, ejecutar en cualquier lugar). Este concepto fue innovador, ya que, antes de Java, cuando se quería ejecutar un programa en diferentes sistemas operativos, era necesario compilar el código fuente por separado para cada uno, lo que generaba un ejecutable específico para cada sistema (por ejemplo, uno para Windows, otro para Mac, otro para Linux, etc.).

Con WORA, el código fuente de Java se compila una vez en un formato intermedio llamado bytecode. Este bytecode no depende de un sistema operativo específico, y se ejecuta en cualquier sistema que tenga una Java Virtual Machine (JVM). La JVM interpreta y ejecuta el bytecode, permitiendo que la misma aplicación funcione en múltiples sistemas operativos sin necesidad de recompilar.

Para poder ejecutar la JVM en cualquier sistema operativo, es necesario tener instalado el Java Runtime Environment (JRE). El JRE incluye la JVM y un conjunto de bibliotecas (APIs de Java) necesarias para ejecutar aplicaciones Java. A diferencia del JDK, que es el kit de desarrollo que incluye herramientas adicionales como el compilador, el JRE está orientado únicamente a la ejecución de aplicaciones.

• JDK: Java Development Kit (Kit de desarrollo Java):
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Es un conjunto de herramientas para desarrollar y compilar en Java. 
Con el JRE podremos ejecutar cualquier archivo compilado en Java, pero en el caso de querer crear archivos Java vamos a 
necesitar tener el JDK instalado. Al instalar JDK en el sistema vamos a encontrarnos dentro del mismo a: 
. JRE (Java Runtime Enviroinment) [JVM (Java Virtual Machine)y API de Java (Clases y Librerias de Java)]
. javac (Java Compiler - Compilador Java)
. Debugger

- Entonces el proceso completo desde que creamos nuestro proyecto Java hasta el momento en el que lo ejecutamos es el 
siguiente:
Nuestro proyecto y lógica del programa seran todos nuestros archivos con la extension '.java' y a dichos archivos los 
llamaremos CÓDIGO FUENTE.
Como mencionamos dentro del JDK vamos a encontrar el 'javac' (java compiler). Este será el encargado de convertir nuestro 
código fuente (archivos.java) en BYTECODE (archivos.class). Es decir, el 'javac' será encargado de COMPILAR nuestro CODIGO 
FUENTE (.java) en BYTECODES (.class).
Estos 'archivos.class' son los archivos que posteriormente va a recibir e interpretar la JVM, sin importar cual 
sea el sistema operativo que estemos utlizando. Es decir, la JVM va a interpretar los ByteCodes y a través de esta se ejecutará el Programa según corresponda corresponda.

     _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
    |                                                                                                       |
    |                           JDK  (java, javac, jdb, appletviewer, javah, javaw, jar...)                 |
    |    _ _ _ _ _ _ _ _            _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _         |
    |   |                |         |     _ _ _ _ _ _ _ _ _ _ _ _         _ _ _ _ _ _ _ _            |       |
    |   |    'javac'     |         |    |                       |       |                |          |       |
    |   |(Java Compiler) |         |    |         JVM           |       |   Class Loader |          |       |
    |   |_ _ _ _ _ _ _ _ |         |    |  Java Interpreter     |       |   Librerias    |          |       |
    |                              |    |  JIT                  |       |   API Java     |          |       |
    |                              |    |  Garbage Collector    |       |_ _ _ _ _ _ _ _ |          |       |    
    |                              |    |     ...               |                                   |       |
    |                              |    |_ _ _ _ _ _ _ _ _ _ _ _|                                   |       |
    |    _ _ _ _ _ _ _ _           |                                                                |       |
    |   |               |          |    JRE                                                         |       |
    |   |   DEBUGGER    |          | (Class Loader, Byte Code Verifier, Java API, RuntimeLibraries) |       |
    |   |_ _ _ _ _ _ _ _|          |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |       |
    |                                                                                                       |   
    |                                                                                                       |
    |                                                                                                       |
    |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _| 


• JAVA SE: Java Standar Edition. Es una plataforma base Java que incluye el JDK y JRE. Es decir, es la plataforma básica 
para poder ejecutar y derrollar Java. 
La version Java SE tiene por default utilidades para desarrollar la interfaz gráfica basada en proyectos 'desktop', una 
interfaz grafica que hoy en dia esta en desuso.

• IDE: Integrated Development Enviroment. El IDE compila con el JDK y pasa el archivo.java a ByteCode en el archivo.class para que finalmente pueda ser ejecutado. 


*/

package Clase01;

public class JDK_JRE {

}
