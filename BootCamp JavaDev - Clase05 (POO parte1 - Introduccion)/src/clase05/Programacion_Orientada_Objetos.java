/*
 
											● PARADIGMA DE OBJETOS
											 
	Un Paradigma es un 'Modelo' o 'Patron' en cualquier disciplina cientifica. Es una forma de resolver los problemas.  El 'Paradigma           	de Programacion Orientada a Objetos'(POO) es la implentacion de un 'Paradigma', una propuesta mas, dentro de todos los Paradigmas 	que existen en la Programacion. 


	• PROGRAMACIÓN ORIENTADA A OBJETOS: "POO"  
 	  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Un 'MODELO' es una abstraccion de la realidad, una respresentación de la realidad simplificada, con el objetivo final de 
	pasar del 'modelo' a la 'realidad'. De la misma forma los Sistemas de Informacion deben ser modelados, respresentarlos 
	mediante un esquema previo, para luego poder tomar como referencia el modelo y contruir en base al mismo.  

	. OOP (Object Oriented Programming)
	
	El MODELADO ORIENTADO A OBJETOS consiste en interpretar un sistema como partes independientes que se comunican entre sí. Las 
	partes independientes se denominan 'OBJETOS'. Dichos 'objetos' tendrán comunicación e intereacción entre sí a través 
	de 'mensajes'. Es decir, se tratará de representar la realidad (proyecto, programa) como 'objetos' realacionados entre sí 
	comunicandose a través de mensajes (Atributos y metodos). 
	
	Antes se entendia a el Programa como una sola pieza, eso acumulaba muchas líneas de código, y por la tanto era 
	complejo tanto de desarollar como de matener. A través del 'MODELADO ORIENTADO A OBJETOS' se tiene sus partes facilmente 
	separadas, en donde cada burbuja resuelve un problema mucho mas chico y luego se integra. Cuando hay un problema o 
	modificación solo hay que ubicar cual seria la burbuja correspondiente a modificar, y no es necesario modificar todo el 
	programa. Por otro lado es mas fácil reutilizar 'burbujas' que programas enteros. 
	
	El OOP entonces se basa en el concepto de agrupar 'codigo' y 'datos' (métodos y atributos) juntos en una misma unidad 
	llamada 'CLASE'. Es decir, un molde para crear objetos.
	
	*Ventajas de OOP:
	- Altamente Escalable (se puede mejorar, se puede modificar fácilmente)
	- Fácil de Mantener   (al estar todo independizado es mas facil de corregir los errores de forma puntal, sin tener que 
	                       cambiar todo)
	- Fácil de Reutilizar (se puede reutilizar en mas de un programa)
	
	
	• CLASES: 
	  ¨¨¨¨¨¨ 
	Una CLASE es un conjunto de métodos y atributos con caracteristicas similares o una misma finalidad, organizados para poder 	definir objetos de la misma. Las 'Clases' serán nuestro 'molde' para crear cada 'objeto' nuevo, y cada objeto nuevo a su vez 	tendrá los métodos y atributos definidos en la clase. Generalmente las 'Clases' suelen detectarse como 'SUSTANTIVOS' en 	'SINGULAR'. Los atributos seran las variables o datos de cada objeto, y los métodos las accciones que podrá	realizar cada Objeto. 
	
	Es decir, las 'Clases' serán el molde donde se define la cantidad de variables y tipo que tendrá cada objeto (Atributos),
	y a su vez tendrá las acciones que podrá realizar (Métodos). Tambien en la 'Clase' indicará el tipo de relación que tienen sus 	objetos respecto a otros objetos de otras clases.
	Ejemplos: Auto, Empleado, CajaDeAhorro, Alumno, etc.
	
	En Java cada Clase sera un objeto de Class (java.lang.Class)
	
	UML: Técnica de representar gráficamente clases y objetos. 

    ------------------
    |  Nombre (clase)|  ----> SINGULAR
    |--------------- |  	
    |	Artibuto1:   |		 		
    |	Artibuto2:   |
    |                |
    |----------------|
    |	Metodo1:     |
    |	Metodo2:	 |
    |                |
    ------------------
    
    	- Sintaxis

        public class id_Clase {
        
        }   
	
	
	• ATRIBUTOS: 
	 ¨¨¨¨¨¨¨¨¨¨
	Son ADJETIVOS de una CLASE, la describen. Son aquellas caratecristicas principales que hacen a nuestro objeto sea único y 
	nos ayudan a describir el mismo. Es decir, aquellas caracteriscas que diferencian un objeto de otro. A nivel sistema los vamos a 	materializar como 'variables' contenidas dentro de una CLASE con un 'tipo de dato' asociado. Los atributos pueden ser datos 	primitivos u objetos de otra clase. 
	Los atributos a diferencia de las variables, tienen un proceso de inicialización automático. Es decir, que sin no incializan
	con ningun valor, los atributos númericos se inicializan en '0' y los atributos tipo String se inicializan en 'null'.
	
	En Java los atributos son variables de la Clase java.lang.reflect.Field
	
		- Sintaxis:
		
		public class id_Clase {
	       
	    	// ATRIBUTOS
    		String atributo1;
		    String atributo2;
		    boolean atributo3;
		    int atributo4;
		    	
	    	// METODOS
			 	.....
		}
	
	
 	• MÉTODOS: 
 	 ¨¨¨¨¨¨¨¨
	Los MÉTODOS serán las ACCIONES que podrá realizar cada objeto instanciado, motivo por el cual se pueden identificar como 
	VERBOS. Los métodos entonces serán un 'conjunto de acciones' definidas dentro de una clase, y cada método tendrá la 
	particularidad de realizar una 'acción' determinada. 
	La principal ventaja de trabajar con 'métodos' sera que podremos invocar a un 'conjunto de instrucciones' con solamente 
	un nombre. Cuando se llama a un 'Metodo ()', el programa pasara a ejecutar el 'bloque de codigo' declarado dentro del mismo. Una 	vez finalizado bloque de codigo el programa continuará con la ejecución principal a partir del punto donde se produjo el llamado. 	Los metodos podemos distinguirlos entre 'funciones' o 'procedimientos', es decir, si retornan un valor al finalizar su ejecución 	será una función, y si no retorna un valor será.
	
	En Java los métodos son objetos de la clase java.lang.reflect.Method
	    
    . Metodos '@Deprecated'
  	Cuando a un Método se le antepone un @Deprecated se indicando que actualmente esta funcional, pero en un futuro dicho método
	dejara de existir o utilizarse. Generalmente se debe complementar la información con un 'Comentario Java DOC' para indicar
	el reemplazo o recomendación. 
    
    	- Sintaxis:
		
		public class id_Clase {
	       
	    	// ATRIBUTOS
    			.....
		    	
	    	// MÉTODOS
		 	
		 	public void id_procedimiento(){                                       
	        ....
	        Bloque de Codigo
	        ...
		    }
		    
			public String id_funcion(){                                       
		    ....
		    Bloque de Codigo
		    ...
		    return (string);
		    }
		}
        
    
    • OBJETOS:
  	  ¨¨¨¨¨¨¨¨  
	Son INSTANCIAS de la una clase. El objeto es la razón de ser de la clase, es lo que se termina creando con el 'molde'. Cada 
	objeto respresentara a una situación en particular de la clase. Cada objeto tendra un estado propio, y estara determinado 
	por el valor de sus atributos. Si bien cada objeto tendrá sus propios valores, todos los 'objetos' podrán realizar las mismas 	'acciones', es decir, todos	los objetos tendrán los mismos métodos en común. 
	
	Es importante recordar que los objetos solo viven en memoria. En el caso de que se necesite registrar datos de forma 
	permanente, vamos a guardar la informacion de los obejtos en una Base de Datos.
	En Java quien se encarga de destruir o liberar la memoria de los Objetos que ya no usamos es el 'Garbage Collector' (GC) y 
	lo hace de forma automática administrando la memoria mediante la JVM. 
	
		Sintaxis:
			
			Clase id_objeto = new Clase();
	
	
	• CONSTRUCTORES:
  	 ¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Son métodos que van a tener como tarea específica 'inicializar' (crear) un nuevo objeto de la clase. Serán los encargados de 
	'construir' el objeto siguiendo el molde de la clase. En otras palabras, los Constructores seran métodos específicos encagardos 
	de crear al objeto y dejar el mismo listo para su utilización (inicializado). Es el único método que tendrá el mismo 
	nombre que la clase, no tienen devolución de parametros y no necesita la palabra reservada 'void' para su declaración. 
	
	Existe la 'Sobrecarga de Constructores', motivo por el cual se podrá declarar mas de un constructor por clase con diferentes
	finalidades. Se invoca un constructor usando la palabra clave 'new'.
	Si una clase no tiene constructor definido, Java al compilar creará de forma predeterminada un constructor vacío. Cuando se 	definen constructores, Java deja de ofrecer el constructor vacío por defecto, por lo que si se quiere se deberá especificar en la 	clase dicho constructor vacío.
	
	En Java los constructores son objetos de la clase java.lang.reflect.Constructors 
	
		Sintaxis:
		
		public class id_Clase {
	       
	    	// ATRIBUTOS
		    	.....
		    	
	    	// CONSTRUCTORES
		
		    public id_Clase() {
		    
		    }                                                 
	    
			// METODOS
			 	.....
			 	
	  	}
	
	• SOBRECARGA DE NOMBRES 'THIS.':
  	Muchas veces debemos utilizar un parámetro para asignar el valor a un atributo y nos surge la necesidad de pensar en nombrar los 	parámetros de forma tal que no “choquen” con los nombres de los atributos. Para evitar tener que estar pensando diferentes 	nombres y poder indicarle a Java en que momento se hace referencia al atributo y en que momento se hace referencia al parámetro, 	existe la palabra reservada 'this.'. Con 'this.' vamos 	a indicar que se esta haciendo referencia al atributo de la clase y no 	al parámetro.  
 	
 	- Ejemplo: 
 		
 		public Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
    
	En este caso, this.marca, this.modelo, y this.color hacen referencia a los atributos de la clase Auto, mientras que marca, 	modelo, y color se refieren a los parámetros. 	
	
	
	• Generalmente la forma de organizar una Clase es la siguiente: 
      ************************************************************
    	public class id_Clase {
	       
	    // ATRIBUTOS
		    String atributo1;
		    String atributo2;
		    boolean atributo3;
		    int atributo4;
	    
	    
	    // CONSTRUCTORES
		    public id_Clase() {
		    }                                                 
	    
		    public id_Clase(String atributo1, String atributo2, boolean atributo3, int atributo4) {
		        this.atributo1 = atributo1;
		        this.atributo2 = atributo2;
		        this.atributo3 = atributo3;
		        this.atributo4 = atributo4;
		    }
	    
	
	    
	    // METODOS
		    public void id_procedimiento(){                                       
		        ....
		        Bloque de Codigo
		        ...
		    }
		    
			public String id_funcion(){                                       
		    ....
		    Bloque de Codigo
		    ...
		    return (string);
		    }
		    	
	************************************************************
	
	● ENCAPSULACMIENTO:
  	  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Dado que hay artibutos que son muy sensibles para dejar al libre alberdio de su modificación se crea el ENCAPSULAMIENTO. Su
	filosofía es hacer que los atributos de las clases se puedan editar solo a través de métodos controlados. Básicamente el 
	'encapsulamiento' se utiliza para brindar mas seguridad en la aplicación, evitar que la información se filtre y dar mucho más 
	orden en las clases. 
	El 'Encapsulamiento' entonces sera simplemente la capacidad de ocultar los 'atributos' de una 'clase' (encapsularlos) y poder 
	modificar/acceder a los mismos únicamente a través de un 'ambiente controlado', es decir a través de métodos creados con 
	esa finalidad. La forma en la que vamos a poder generar nuestro encapsulamiento sera través de la 'Visibilidad' de 
	nuestros miembros.
	
	    
	• VISIBILIDAD: 
	  ¨¨¨¨¨¨¨¨¨¨¨¨
	Es la posibilidad de ver o no un 'atributo o método' (miembro) de la clase. La 'Visibilidad' estará establecida por los 	modificadores de visibilidad 'private', 'public', 'protected', 'default'.
	    
	- PRIVATE: Si un miembro es 'private' (privado) ÚNICAMENTE se podrá acceder al mismo dentro de la MISMA CLASE, no se podrá 
	acceder desde fuera de la clase. 
	
	- 'DEFAULT' o 'PACKAGE': Si no se indica NINGÚN modificador de Visibilidad (omitido) el miembro SOLAMENTE será accesible 
	desde la misma clase y desde las clases que esten dentro del mismo paquete. 
	
	- 'PROTECTED': Si un 'Miembro' es 'protected' se podrá acceder desde de la misma clase, desde clases que esten dentro del
	mismo 'Paquete' y tambien desde 'Clases hijas'. 
	    
	- 'PUBLIC': Es el más permisivo de todos. Si un miembro es 'public' (público) se podrá acceder tanto desde la propia clase 
	como desde cualquier otra clase (externa). 
	    
	. TABLA DE MODIFICADORES DE ACCESO
	    
	Modificador     La misma clase  Mismo paquete   Subclase    Otro paquete
	private             ✓               🗴              🗴           🗴
	default             ✓               ✓              🗴           🗴
	protected           ✓               ✓              ✓           🗴
	public              ✓               ✓              ✓           ✓
	
	    
	Para generar entonces el 'encapsulamiento' de una clase hay a declarar los atributos como PRIVATE y los métodos como PUBLIC. De 	esta forma SOLO se podrá acceder a un atributo a través de los métodos. Se evita el acceso 	directo al atributo y lo único a lo 	que se podrá acceder es a los métodos. A través de los métodos en un ambiente controlado se modificarán los atributos deseados. 
    En UML suele presentarse con el signo 'menos' (-) a los miembros privados y con el signo 'mas' (+) a los miembros públicos. 
    
	. Ejemplo:  
	    
	     ---------------------------------              
	    |        	  Auto               | 					 
	    |--------------------------------|  	
	    | -       velocidad: int         |		 		
	    |                                |
	    |--------------------------------|
	    | +      acelerar(): void        |
	    | +        frenar(): void        |
	    |                                |
	    |                                |
	    |                                |
	    ----------------------------------
	
	
	Si al atributo velocidad lo declaramos privado(-), prohibimos que se acceda al atributo directamente, y que este solo se pueda 	modificar a través de losmMétodos públicos (+). En este caso evitariamos la posibilidad de que se pueda modificar la 'velocidad' 
	libremente, y únicamente se pueda modificar a traves de los métodos 'acelerar()' y 'frenar()' en un ambiente controlado. 
	
	 
	 class Auto {
	// ATRIBUTOS
	    private int velocidad;
	
	
	// METODOS
	    public void acelerar() {
	        velocidad = velocidad + 10;
	        if(velocidad>100) velocidad=100;
	    }
	
	    public void frenar() {
	    velocidad = velocidad - 10;
	    }
	}
	
	    
	. Ejemplo2:  
	
	El atributo saldo es 'privado', solo puede modificarse a través de los métodos públicos depositar() y extraer().
	   
	    ----------------------------------
	    |         Cuenta Bancaria        | 					 
	    |--------------------------------|  	
	    | -         saldo: int           |		 		
	    |                                |
	    |--------------------------------|
	    | +	    depositar(int): void     |
	    | +	    extraer(int): void       |
	    |                                |
	    |                                |
	    |                                |
	    ----------------------------------
	    
	    
    • PAQUETES (PACKAGES): 
  	
  	Los Paquetes no son más que 'CARPETAS' dentro nuestro proyecto JAVA que nos ayudarán a organizar y contener un conjunto 
	de 'clases relacionadas' bien por finalidad, funcionalidad, por ámbito o por herencia. 
	Los paquetes resuelven además, el conflicto entre el nombre de clases. Al crecer el número de clases hay probabilidad de 
	designar con el mismo nombre a dos clases diferentes. Por otro lado las clases, atributos y métodos tienen ciertos 
	privilegios de acceso trambién determinados por los paquetes.    
	Para dar unicidad en el nombre de los paquetes, se escribe la 'ruta' (dominio) de las 'clases' en forma inversa, 
	para reducir la posibilidad de que haya paquetes con el mismo nombre en un proyecto. 
	
	Ejemplo: ar.com.eduit.curso.java.entities
    
	    
 	● SETTERS Y GETTERS: 
      ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Son métodos de acceso 'público' a atributos 'privados'. Representan la ÚNICA forma de acceder a los 'Atributos Privados'.
	Estos 'métodos' deben ser creados con un estándar de identificación, para diferenciarlos fácilmente. 
	
	. SETTER -> Método utilizado únicamente para setear un valor a un atributo privado. Se utilizará la palabra reserva 'set'. 
	            Es un método 'void' sin valor de retorno. 
	            
	            public void setIdAtributo (tipo_dato id_atributo) {
	                
	                    this.id_atributo = id_atributo
	    
	            }
	
	    .Ejemplo:   public void setNombre(String nombre) {
	                    this.nombre = nombre;
	                }
	    
	    
	. GETTER -> Método utilizado únicamente para obtener el valor de un atributo privado. Se utilizará la palabra reserva 'get'. 				            				Es un método que retornara un valor.  
	            
	            public tipo_dato getIdAtributo () {
	                
	                return id_atributo;
	    
	            }
	    
	    .Ejemplo:   public int getEdad() {
	                    return edad;
	                }
	
	
	Si se desea hacer que una 'clase' sea SOLO LECTURA se asignaran solamente los métodos GETTERS, y por el contrario, si se 
	desea hacer que una 'clase' sea SOLO ESCRITURA se asignaran solamente los métodos SETTERS.
 */

package clase05;

public class Programacion_Orientada_Objetos {

}
