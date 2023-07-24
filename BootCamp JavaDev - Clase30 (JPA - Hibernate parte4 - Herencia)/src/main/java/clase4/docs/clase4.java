/*
El gap relacionado a la herencia entre el modelo relacional y el modelo de objetos es una de las principales
diferencias que dificulta la integraci�n directa de ambos modelos. La herencia en el contexto de la 
programaci�n orientada a objetos permite crear jerarqu�as de clases, donde las subclases heredan atributos y 
m�todos de las superclases. Sin embargo, en el modelo relacional, no hay un mecanismo nativo para representar 
la herencia directamente.

Para solucionar esta brecha, se han desarrollado diferentes enfoques y tecnolog�as que intentan abordar la 
representaci�n de la herencia en bases de datos relacionales y la integraci�n con el modelo de objetos. 
Algunas de estas soluciones son:

1. Single-Table Inheritance: Los ORM son bibliotecas o frameworks que facilitan la interacci�n entre un 
modelo de objetos y una base de datos relacional. Permiten mapear las clases y relaciones del modelo de 
objetos a tablas y relaciones en la base de datos relacional. Estos ORM pueden manejar la herencia mediante 
t�cnicas como la herencia de tabla �nica (single-table inheritance) o la herencia de tabla por clase 
(class-table inheritance).
La t�cnica de 'Single-Table Inheritance' almacena todos los atributos de todas las subclases en una sola 
tabla, donde algunos atributos pueden ser nulos seg�n la subclase. Se utiliza un atributo adicional para 
identificar a qu� subclase pertenece cada registro.
Si bien esta estrategia es v�lida y resulve el gap, generar� muchos campos con valores null, ya que todas
las subclases van a compartir una misma Tabla y sencillamente en los atributos que no sean compartidos
por herencia y no sean propios de esa subclase se autocompletaran con 'null'.

2. Tablas de uni�n (Join Tables): Una t�cnica para representar la herencia en bases de datos relacionales
es utilizar 'Join Tables' (tablas de uni�n) que almacenan atributos espec�ficos de cada subclase. Cada 
tabla representa una subclase y contiene sus atributos propios, y una tabla de uni�n asocia los 
registros de las tablas de subclases con los registros de la tabla principal. Tambien se utilizar los 
mismo 'id' para hacer el Join directamente, es decir, que el 'id' de la SubClase va a coincidir con 
el 'id' de la SuperClase o dicho de otra forma el 'id' con el que se guarde la SuperClase ser� el 
'id' con el se guarde la SubClase y de esta forma se hara la asociaci�n. 
La clave primaria es a su vez la clave for�nea correspondiente a la superclase. Para obtener los datos
de una subclase, es necesario hacer un join entre la tabla que representa a la superclase y la tabla 
que representa a la subclase.
Esta estrategia es v�lida, resulve el gap y resuelve el problema de no generar campos nulos, cada
Tabla ser� mas leg�ble, m�s facil de interpretar y tendr� su indpendencia unas de otras, pero al estar
realizando 'JOIN' constantemente puede representar un performance un poco mas lenta al momento de 
realizar las consultas, va a consumir mas memoria. 


3. Herencia de tabla por clase (Table_Per_Class Inheritance): En esta t�cnica, cada subclase tiene su 
propia tabla, que contiene los atributos espec�ficos de esa subclase y los de su Superclase. Es decir,
por cada subclase se creara una Tabla que contenga todos los atributos de ambas clases.
Esta estrategia es v�lida, resulve el gap y resuelve el problema de no generar campos nulos, cada
Tabla ser� mas leg�ble, m�s facil de interpretar y tendr� su indpendencia unas de otras, pero no 
se podr�n utlizar todo los tipos de @GeneratedValue(strategy = GenerationType) y la Clase Padre
deber� ser Abstracta. Si bien tiene un menor consumo de memoria que la opcion 'JOIN' por cada Tabla
de las SubClases va a repetir los Campos de su Clase Padre, lo que puede generar un volumen de datos
m�s grande.

Es importante destacar que cada enfoque tiene sus ventajas y desventajas, y la elecci�n de la mejor 
soluci�n depender� de los requisitos y la naturaleza espec�fica del proyecto. Los ORM, en particular, 
han ganado mucha popularidad debido a su capacidad para simplificar y automatizar gran parte del 
trabajo de mapeo entre modelos de objetos y bases de datos relacionales, lo que facilita la 
integraci�n entre ambos paradigmas.


@Inheritance
Mediante la anotacion @Inheritance(strategy = InheritanceType.*** ) definimos el tipo de estragegia 
que vamos a utlizar para resolver el gap relacionado a la herencia que hay entre Objetos y Tablas.
Vamos a definir que estrategia vamos a utilizar para 'simular' la herencia de objetos en las Tablas.

@DiscriminatorValue
La anotacion @DiscriminatorValue se utiliza para especificar el valor del discriminado en una estrategia
de herencia en JPA. El discriminador es un mecanismo que permite a JPA diferenciar entre las diferentes 
subclases en la tabla que representan a la clase base.

La anotaci�n @DiscriminatorValue se coloca en la definici�n de la clase que representa una de las subclases
y se utiliza para especificar el valor que se almacenar� en la columna de discriminador correspondiente en
la tabla cuando se persista un objeto de esa subclase. De esta manera, JPA sabe qu� tipo de objeto es 
cuando lo recupera de la base de datos.

A continuaci�n, se muestra un ejemplo de c�mo se puede usar la anotaci�n @DiscriminatorValue:

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_entidad")
public class Entidad {
    // Atributos y m�todos comunes para todas las subclases
}

@Entity
@DiscriminatorValue("SUBCLASE_A")
public class SubclaseA extends Entidad {
    // Atributos y m�todos espec�ficos para la Subclase A
}

@Entity
@DiscriminatorValue("SUBCLASE_B")
public class SubclaseB extends Entidad {
    // Atributos y m�todos espec�ficos para la Subclase B
}

En este ejemplo, Entidad es la clase base con la jerarqu�a de herencia, y se utiliza la estrategia 
SINGLE_TABLE para almacenar todas las subclases en la misma tabla. La columna "tipo_entidad" se 
utilizar� como el discriminador. Es decir la Columna donde se indicara a que tipo de SubClase
va a corresponder ese registro. 
Con las anotaciones @DiscriminatorValue en las subclases SubclaseA y SubclaseB especifican los 
valores "SUBCLASE_A" y "SUBCLASE_B", respectivamente, que se almacenar�n en la columna de 
discriminador cuando se persistan objetos de estas subclases.

Con la anotaci�n @DiscriminatorColumn vamos a renombrar el nombre del discrimanador, que por 
defecto ser� 'dtype' en el caso que no sea renombrado. 
*/

package clase4.docs;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;

public class clase4 {

}
