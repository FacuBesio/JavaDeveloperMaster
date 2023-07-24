/*
El gap relacionado a la herencia entre el modelo relacional y el modelo de objetos es una de las principales
diferencias que dificulta la integración directa de ambos modelos. La herencia en el contexto de la 
programación orientada a objetos permite crear jerarquías de clases, donde las subclases heredan atributos y 
métodos de las superclases. Sin embargo, en el modelo relacional, no hay un mecanismo nativo para representar 
la herencia directamente.

Para solucionar esta brecha, se han desarrollado diferentes enfoques y tecnologías que intentan abordar la 
representación de la herencia en bases de datos relacionales y la integración con el modelo de objetos. 
Algunas de estas soluciones son:

1. Single-Table Inheritance: Los ORM son bibliotecas o frameworks que facilitan la interacción entre un 
modelo de objetos y una base de datos relacional. Permiten mapear las clases y relaciones del modelo de 
objetos a tablas y relaciones en la base de datos relacional. Estos ORM pueden manejar la herencia mediante 
técnicas como la herencia de tabla única (single-table inheritance) o la herencia de tabla por clase 
(class-table inheritance).
La técnica de 'Single-Table Inheritance' almacena todos los atributos de todas las subclases en una sola 
tabla, donde algunos atributos pueden ser nulos según la subclase. Se utiliza un atributo adicional para 
identificar a qué subclase pertenece cada registro.
Si bien esta estrategia es válida y resulve el gap, generará muchos campos con valores null, ya que todas
las subclases van a compartir una misma Tabla y sencillamente en los atributos que no sean compartidos
por herencia y no sean propios de esa subclase se autocompletaran con 'null'.

2. Tablas de unión (Join Tables): Una técnica para representar la herencia en bases de datos relacionales
es utilizar 'Join Tables' (tablas de unión) que almacenan atributos específicos de cada subclase. Cada 
tabla representa una subclase y contiene sus atributos propios, y una tabla de unión asocia los 
registros de las tablas de subclases con los registros de la tabla principal. Tambien se utilizar los 
mismo 'id' para hacer el Join directamente, es decir, que el 'id' de la SubClase va a coincidir con 
el 'id' de la SuperClase o dicho de otra forma el 'id' con el que se guarde la SuperClase será el 
'id' con el se guarde la SubClase y de esta forma se hara la asociación. 
La clave primaria es a su vez la clave foránea correspondiente a la superclase. Para obtener los datos
de una subclase, es necesario hacer un join entre la tabla que representa a la superclase y la tabla 
que representa a la subclase.
Esta estrategia es válida, resulve el gap y resuelve el problema de no generar campos nulos, cada
Tabla será mas legíble, más facil de interpretar y tendrá su indpendencia unas de otras, pero al estar
realizando 'JOIN' constantemente puede representar un performance un poco mas lenta al momento de 
realizar las consultas, va a consumir mas memoria. 


3. Herencia de tabla por clase (Table_Per_Class Inheritance): En esta técnica, cada subclase tiene su 
propia tabla, que contiene los atributos específicos de esa subclase y los de su Superclase. Es decir,
por cada subclase se creara una Tabla que contenga todos los atributos de ambas clases.
Esta estrategia es válida, resulve el gap y resuelve el problema de no generar campos nulos, cada
Tabla será mas legíble, más facil de interpretar y tendrá su indpendencia unas de otras, pero no 
se podrán utlizar todo los tipos de @GeneratedValue(strategy = GenerationType) y la Clase Padre
deberá ser Abstracta. Si bien tiene un menor consumo de memoria que la opcion 'JOIN' por cada Tabla
de las SubClases va a repetir los Campos de su Clase Padre, lo que puede generar un volumen de datos
más grande.

Es importante destacar que cada enfoque tiene sus ventajas y desventajas, y la elección de la mejor 
solución dependerá de los requisitos y la naturaleza específica del proyecto. Los ORM, en particular, 
han ganado mucha popularidad debido a su capacidad para simplificar y automatizar gran parte del 
trabajo de mapeo entre modelos de objetos y bases de datos relacionales, lo que facilita la 
integración entre ambos paradigmas.


@Inheritance
Mediante la anotacion @Inheritance(strategy = InheritanceType.*** ) definimos el tipo de estragegia 
que vamos a utlizar para resolver el gap relacionado a la herencia que hay entre Objetos y Tablas.
Vamos a definir que estrategia vamos a utilizar para 'simular' la herencia de objetos en las Tablas.

@DiscriminatorValue
La anotacion @DiscriminatorValue se utiliza para especificar el valor del discriminado en una estrategia
de herencia en JPA. El discriminador es un mecanismo que permite a JPA diferenciar entre las diferentes 
subclases en la tabla que representan a la clase base.

La anotación @DiscriminatorValue se coloca en la definición de la clase que representa una de las subclases
y se utiliza para especificar el valor que se almacenará en la columna de discriminador correspondiente en
la tabla cuando se persista un objeto de esa subclase. De esta manera, JPA sabe qué tipo de objeto es 
cuando lo recupera de la base de datos.

A continuación, se muestra un ejemplo de cómo se puede usar la anotación @DiscriminatorValue:

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_entidad")
public class Entidad {
    // Atributos y métodos comunes para todas las subclases
}

@Entity
@DiscriminatorValue("SUBCLASE_A")
public class SubclaseA extends Entidad {
    // Atributos y métodos específicos para la Subclase A
}

@Entity
@DiscriminatorValue("SUBCLASE_B")
public class SubclaseB extends Entidad {
    // Atributos y métodos específicos para la Subclase B
}

En este ejemplo, Entidad es la clase base con la jerarquía de herencia, y se utiliza la estrategia 
SINGLE_TABLE para almacenar todas las subclases en la misma tabla. La columna "tipo_entidad" se 
utilizará como el discriminador. Es decir la Columna donde se indicara a que tipo de SubClase
va a corresponder ese registro. 
Con las anotaciones @DiscriminatorValue en las subclases SubclaseA y SubclaseB especifican los 
valores "SUBCLASE_A" y "SUBCLASE_B", respectivamente, que se almacenarán en la columna de 
discriminador cuando se persistan objetos de estas subclases.

Con la anotación @DiscriminatorColumn vamos a renombrar el nombre del discrimanador, que por 
defecto será 'dtype' en el caso que no sea renombrado. 
*/

package clase4.docs;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;

public class clase4 {

}
