/*
 
											● PARADIGMA DE OBJETOS
											 
	Un Paradigma es un 'Modelo' o 'Patron' en cualquier disciplina cienti­fica. Es una forma de resolver los problemas. Admite la 
	existencia de multiples soluciones para un mismo problema y cada 'forma', 'modelo' o 'propuesta' de abordar la vamos a 
	llamar 'Paradigma'. El 'Paradigma de Programacion Orientada a Objetos'(POO) es la implentacion de un 'Paradigma', una 
	propuesta mas, dentro de todos los Paradigmas que existen en la Programacion. 


	• PROGRAMACIÓN ORIENTADA A OBJETOS: "POO"  
 	  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Un 'MODELO' es una abstraccion de la realidad, una respresentación de la realidad simplificada, con el objetivo final de 
	pasar del 'Modelo' a la 'Realidad'. De la misma forma los Sistemas de Informacion deben ser Modelados, respresentarlos 
	mediante un esquema previo, para luego poder tomar como referencia el Modelo y contruir en base al mismo.  

	. OOP (Object Oriented Programming)
	
	El MODELADO ORIENTADO A OBJETOS consiste en interpretar un sistema como partes independientes que se comunican entre sí­. Las 
	partes independientes se denominan 'OBJETOS'. Dichos 'Objetos' tendran comunicación e intereacción entre sí a través 
	de 'Mensajes'. Es decir, se tratara de representar la realidad (proyecto, programa) como 'Objetos' realacionados entre si 
	comunicandose a través de Mensajes (Atributos y metodos). 
	
	Antes se entendia a el Programa o Poryecto como una sola pieza, eso acumulaba muchas lineas de codigo, y por la tanto era 
	complejo tanto de desarollar como de matener. A través del 'MODELADO ORIENTADO A OBJETOS' se tiene sus partes facilmente 
	separadas, en donde cada burbuja resuelve un problema mucho mas chico y luego se integra. Cuando hay un problema o 
	modificación solo hay que ubicar cual seria la burbuja correspondiente a modificar, y no es necesario modificar todo el 
	Programa. Por otro lado es mas facil reutilizar 'burbujas' que Programas enteros. 
	
	El OOP entonces se basa en el concepto de agrupar 'Codigo' (Métodos) y 'Datos' (Atributos) juntos en una misma unidad 
	llamada 'CLASE'. Es decir, un Molde para crear Objetos.
	
	*Ventajas de OOP:
	- Altamente Escalable (se puede mejorar, se puede modificar facilmente)
	- Fácil de Mantener   (al estar todo independizado es mas facil de corregir los errores de forma puntal, sin tener que 
	                       cambiar todo)
	- Fácil de Reutilizar (se puede reutilizar en mas de un programa)
	
	
	• CLASES: 
	  ¨¨¨¨¨¨ 
	Una CLASE es un conjunto de OBJETOS con caracteristicas similares. Las 'Clases' nos van a ayudar a definir 'Objetos', seran
	nuestro 'Molde' para crear cada 'Objeto' nuevo. Generalmente las 'Clases' suelen detectarse como 'SUSTANTIVOS' en 'SINGULAR'. 
	Poseen Atributos y Métodos. Los Atributos seran las variables(datos) de cada Objeto, y los Métodos las Accciones que podra 
	realizar cada Objeto. 
	Es decir, las 'Clases' seran el Molde que defina la cantidad de variables (y tipo) que tendra cada 'Objeto' (Atributos)
	y a su vez tendra la informacion necesaria para indicar las acciones que podra realizar (Métodos). Tambien en la 'Clase' 
	estara indicado el tipo de Relacion que tiene el 'Objeto' creado respecto a otros 'Objetos'/'Clases'.
	Ejemplos: Auto, Empleado, CajaDeAhorro, Alumno, etc.
	
	En Java cada Clase sera un Objeto de Class (java.lang.Class)
	
	UML: Tecnica de representar graficamente Clases y Objetos. (Un cuadrado con el Nombre en el cuadro superior de la Clase).

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
    	La Clases se crea desde las mismas carpetas de nuestro IDE. Create => Java Class. La misma se creara con un 
    	formato similar al siguiente: 
        
        public class id_Clase {
        
        }   
	
	
	• ATRIBUTOS: 
	 ¨¨¨¨¨¨¨¨¨¨
	Son ADJETIVOS de una CLASE, la describen. Son aquellas 'Caratecristicas Principales' que hacen a nuestro 'Objeto' único y 
	nos ayudan a describir el mismo. Es decir, aquellas Caracteriscas que diferencian un 'Objeto' de otro.  
	A nivel sistema lo vamos a materializar como 'Variables' contenidas dentro de una CLASE con un 'tipo de dato' asociado. Los 
	'Atributos' seran entonces valores contenidos dentro de variables, que cumpliran la funciones de contener toda la 
	información de un 'Objeto'. Dicha información debería reflejar las caracteristicas principales del Objeto. Los Atributos 
	pueden ser Datos Primitivos u Objetos. 
	Los Atributos a diferencia de las variables, tienen un proceso de Inicialización automatico. Es decir, que sin no incializan
	con ningun valor, los Atributos númericos se inicializan en '0' y los Atributos tipo String se inicializan en  'null'.
	Recordar que en Java las 'Variables' SI deben estar Inicializadas. 
	
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
	Los MÉTODOS seran las ACCIONES que pueden realizar una Clase u Objeto, motivo por el cual se pueden identificar como 
	VERBOS. Los Métodos entonces seran un 'conjunto de acciones' definidas dentro de una Clase, y cada Método tendra la 
	particularidad de realizar una 'Accion' (Tarea/Funcion) determinada. 
	La principal ventaja de trabajar con 'Métodos' sera que podremos invocar a un 'Conjunto de Instrucciones' con solamente 
	un nombre (Metodo ()). Cuando se llama a un 'Metodo ()', el programa pasara a ejecutar el 'Bloque de Codigos' 
	declarado dentro del mismo. Una vez finalizado Bloque de Codigos el Programa continuara con la ejecución principal a partir 
	del punto donde se produjo el llamado. Los 'Metodos' podemos distinguirlos entre 'Funciones' o 'Procedimientos', es decir, 
	si retornan un valor al finalizar su ejecución (Funcion) o no (Procedimiento).
	
	En Java los métodos son objetos de la clase java.lang.reflect.Method
	    
	Los Métodos proporcionan una forma ingresar o intercambiar información que sera a traves de sus 'Parametos'. Es decir, 
	al momento de declarar el 'Bloque de Instrucciones' habra Elementos declarados genericamente como referencia a un 
	futuro valor, un 'Parametro'. Al momento de utilizar el Método se invocara el mismo mediante su nombre, y ademas se 
	indicaran valores para los Parametros que tenga declarados. 
	
	    . Parámetros: Son la declaración de uno o mas tipos de datos (Variables u Objetos)
	    
	    . Argumentos: Son los valores que se envían al llamar al método.
	    
    
    . Metodos '@Deprecated'
  	Cuando a un Método se le antepone un @Deprecated se indicando que actualmente esta funcional, pero en un futuro dicho Método
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
	Son INSTANCIAS de la Clase. El Objeto es la razon de ser de la Clase, es lo que se termina creando con el 'Molde', cada 
	Objeto respresentara a una situacion en particular de la Clase. Cada Objeto tendra un Estado propio, y estara determinado 
	por el valor de sus Atributos. Es decir, el 'Estado' de cada Objeto sera el valor de sus Atributos.
	Si bien cada Objeto tendra sus propios valores, todos los 'Objetos' podran realizar las mismas 'Acciones', es decir, todos 
	los Objetos tendran los mismos Métodos en común. 
	
	Es importante recordar que los Objetos solo viven en Memoria. En el caso de que se necesite registrar datos de forma 
	permanente, vamos a guardar la informacion de los Obejtos en una Base de Datos.
	En Java quien se encarga de destruir o liberar la memoria de los Objetos que ya no usamos es el 'Garbage Collector' (GC) y 
	lo hace de forma automatica administrando la memoria mediante la JVM. 
	
		Sintaxis:
			
			Clase id_objeto = new Clase();
	
	
	• CONSTRUCTORES:
  	 ¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Son Métodos que van a tener como tarea especifica 'Inicializar' (crear) un Objeto de la Clase. Seran los encargados de 
	'construir' el Objeto siguiendo el molde de la Clase. En otras palabras, los Constructores seran Métodos encagardos 
	de crear al Objeto y dejar el mismo listo para su utilizacion (inicializado). Es el único Método que tendrá el mismo 
	nombre que la Clase, no tienen devolución de parametros y no necesita la palabra reservada 'void' para su declaración. 
	
	Existe la 'Sobrecarga de Constructores', motivo por el cual se podra declarar mas de un Constructor por Clase con diferentes
	finalidades. Se invoca un Constructor usando la palabra clave 'new'.
	Si una Clase no tiene Constructor, Java al compilar creara de forma predeterminada un Constructor vacío. Cuando se definen 
	Constructores con Parámetros en una Clase, Java deja de ofrecer el Constructor vacío por defecto, por lo que si se quiere 
	instanciar un Objeto vacío, se deberá especificar en la Clase dicho constructor vacío.
	
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
  	Muchas veces debemos crear un 'Parámetro' para asignar el valor a una 'Variable de Instancia' y nos surge la necesidad de 
	pensar en un nombre que no “choque” con dicha variable.
	Para este problema se nos proporciona la capacidad de sobrecargar o utilizar un nombre idéntico en el 'Parámetro' para 
	asignárselo a una Variable de instancia.
	Anteponiendo la palabra reservada 'this.' vamos a indicar a Java que se haciendo referencia al 'Atributo' de la 'Clase' y no al 
	'Parámetro' del 'Metodo'. 
 	
 	- Ejemplo: 
 		
 		public Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
    
    Se esta indicando que el Parametro 'marca', sera igual que el Atributo 'marca'.
	
	
	
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
	Dado que hay Artibutos que son muy sensibles para dejar al libre alberdio de su modificación se crea el ENCAPSULAMIENTO. Su
	Filosofia es hacer que los 'Atributos' de las 'Clases' se puedan editar solo a través de 'Métodos'. Basicamente el 
	'Encapsulamiento' se utiliza para brindar mas seguridad en la aplicación, evitar que la información se filtre y dar mucho mas 
	orden en las Clases. 
	El 'Encapsulamiento' entonces sera simplemente la capacidad de ocultar los 'Atributos' de una 'Clase' (encapsularlos) y poder 
	modificar/acceder a los mismos únicamente a través de un 'ambiente controlado', es decir a través de 'Metodos' creados con 
	esa finalidad. La forma en la que vamos a poder generar nuestro 'Encapsulamiento' sera través de la 'Visibilidad' de 
	nuestros Miembros.
	
	    
	• VISIBILIDAD: 
	  ¨¨¨¨¨¨¨¨¨¨¨¨
	Es la posibilidad de ver o no  un 'Atributo o Método' (Miembro). La 'Visibilidad' estara establecida por los Modificadores 
	de visibilidad/acceso 'private', 'public', 'protected', 'default'.
	    
	- PRIVATE: Si un Miembro es 'private' (privado) UNICAMENTE se podra acceder al mismo dentro de la MISMA CLASE, no se podra 
	acceder desde fuera de la Clase. 
	
	- 'DEFAULT' o 'PACKAGE': Si no se indica NINGÚN modificador de Visibilidad (omitido) el Miembro SOLAMENTE sera accesible 
	desde la misma Clase y desde las Clases que esten dentro del mismo Paquete. 
	
	- 'PROTECTED': Si un 'Miembro' es 'protected' se podra acceder desde de la misma Clase, desde Clases que esten dentro del
	mismo 'Paquete' y tambien desde 'Clases hijas'. 
	    
	- 'PUBLIC': Es el mas permisivo de todos. Si un Miembro es 'public' (publico) se podra acceder tanto desde la propia Clase 
	como desde cualquier otra Clase (externamente). 
	    
	. TABLA DE MODIFICADORES DE ACCESO
	    
	Modificador     La misma clase  Mismo paquete   Subclase    Otro paquete
	private             ✓               🗴              🗴           🗴
	default             ✓               ✓              🗴           🗴
	protected           ✓               ✓              ✓           🗴
	public              ✓               ✓              ✓           ✓
	
	    
	En la mayoria de los casos para poder generar el 'Encapsulamiento' en las Clases vamos a declarar los Atributos como 
	PRIVATE y los Métodos como PUBLIC. De esta forma SOLO se podra acceder a un 'Atributo' desde un 'ambiente controlado'
	a través de los Métodos, y se evita el acceso directo al Atributo.
    En UML suele presentarse con el signo 'menos' (-) a los Miembros Privados y con el signo 'mas' (+) a los Miembros Públicos. 
    
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
	
	
	Si al Atributo velocidad lo declaramos 'Privado'(-), prohibimos que se acceda al Atributo y que solo se pueda modificar a 
	través de los Métodos que seran 'publicos' (+). De esta forma entonces evitamos que se modifique la 'velocidad' 
	libremente, y unicamente se pueda modificar a traves de los Metodos 'acelerar()' y 'frenar()'. 
	
	 
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
	
	El Atributo Saldo es 'Privado', solo puede modificarse a través de los Métodos 'Publicos' Depositar() y Extraer().
	   
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
  	
  	Los Paquetes no son mas que 'CARPETAS' dentro nuestro Proyecto JAVA que nos ayudaran a organizar y contener un conjunto 
	de 'Clases Relacionadas' bien por finalidad, funcionalidad, por ámbito o por Herencia. 
	Los Paquetes resuelven además, el conflicto entre el nombre de Clases. Al crecer el número de Clases hay probabilidad de 
	designar con el mismo nombre a dos Clases diferentes. Por otro lado las Clases, Atributos y Métodos tienen ciertos 
	privilegios de acceso y los Paquetes ayudaran a marcar límites.    
	Para dar 'Unicidad' en el nombre de los 'Paquetes', es que se escribe la 'ruta' (dominio) de las 'Clases' en forma inversa, 
	para reducir la posibilidad de que haya Paquetes con el mismo nombre en un Proyecto. 
	
	Ejemplo: ar.com.eduit.curso.java.entities
    
	    
 	● SETTERS Y GETTERS: 
      ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	Son Métodos de acceso 'Público' a Atributos 'Privados'. Representan la ÚNICA forma de acceder a los 'Atributos Privados'.
	Estos 'Métodos' deben ser creados con un estándar de identificación, ya que no dejaran de ser Métodos, pero mediante el 
	'estándar de identificación' podremos diferenciarlos fácilmente. 
	
	. SETTER -> Método utilizado únicamente para setear un valor a un Atributo Privado. Se utilizara la palabra reserva 'set'. 
	            Es un Procedimiento, es decir, es un Método 'void' sin valor de retorno. 
	            
	            public void setIdAtributo (tipo_dato id_atributo) {
	                
	                    this.id_atributo = id_atributo
	    
	            }
	
	    .Ejemplo:   public void setNro(int nro) {
	                    this.nro = nro;
	                }
	    
	    
	. GETTER -> Método utilizado para obtener el valor de un Atributo Privado. Se utilizara la palabra reserva 'get'. (Funcion)
	            Es una Funcion, es decir, es un Método que retornara un valor.  
	            
	            public tipo_dato getIdAtributo () {
	                
	                return id_atributo;
	    
	            }
	    
	    .Ejemplo:   public int getEdad() {
	                    return edad;
	                }
	
	
	Si se desea hacer que una 'Clase' sea SOLO LECTURA se asignaran solamente los 'Métodos GETTERS', y por el contrario, si se 
	desea hacer que una 'Clase' sea SOLO ESCRITURA se asignaran solamente los 'Metodos SETTERS'.
 */

package clase05;

public class Programacion_Orientada_Objetos {

}
