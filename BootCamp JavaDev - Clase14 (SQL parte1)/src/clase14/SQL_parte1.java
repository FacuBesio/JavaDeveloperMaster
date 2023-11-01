/*
● BASE DE DATOS:
 ¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Base de Datos = Esquema = Schemas (ingles)

Una 'Base de Datos' es un conjunto de datos organizados y estructurados según un determinado modelo de información, que 
refleja la relación entre ellos. Un 'motor' de Bases de Datos, también conocido por sus siglas SGBD ó DBMS/RDBMS, es un sistema que 
permite la creación, gestión y administración de Bases de Datos. Los usuarios pueden acceder a la información usando herramientas 
específicas de consulta y/o de generación de informes. 

Un Repositorio es un sitio centralizado donde se almacena y mantiene información digital, habitualmente de bases de datos. Los 
Repositorios pueden distribuirse habitualmente sirviéndose de una red informática como Internet o en un medio físico. Pueden ser de 
acceso público o pueden estar protegidos y necesitar de una autentificación previa.
Las Bases de Datos replican de alguna forma, el esquema antiguo (antes de la 'era' informatica) para guardar información en grandes 
cantidades.

Hoja de datos --> Carpertas (conjunto de 'Hojas de Datos') --> Ficheros (conjunto de 'Carpertas'). 

Por un lado tendremos el 'Fichero' que sera como la Base de Datos, dentro de ellos habra 'Carpetas' que estaran
respresentadas por las Tablas, y finalmente dentro de las Tablas habra 'Hojas de Datos' las cuales estaran respresentadas mediantes 
los Registros, que estaran ordenados por 'Filas' y 'Columnas'.

. Sistemas de Administración de Bases de Datos Relacionales: son un tipo de software específico, dedicado a servir de interfaz entre 
el motor de bases de datos, la base de datos, el usuario y las aplicaciones que la utilizan. El propósito general de estos sistemas es
el de gestionar de manera clara, sencilla y ordenada un conjunto de datos.


● SQL: STRUCTURED QUERY LANGUAGE
  ¨¨¨
SQL es un lenguaje, significa Structured Query Language (lenguaje de consulta estructurada). El objetivo principal de SQL es 
'interactuar' con la 'Base de Datos' en la que se almacena la información de forma tabular (tabla formada por filas y columnas). 
El Motor recopila e interpreta comandos y/o sentencias SQL para que se puedan realizar las Operaciones apropiadas en la Base de Datos. 
Existen varios tipos de motores SQL y todos tienen una arquitectura diferente, pero realizan el mismo objetivo que incluye operaciones 
CRUD en la base de datos y muchas otras características.

- CONTROL DE CONCURRENCIA
Debido a que los sistemas de bases de datos brindan servicios en forma simultánea a un conjunto de usuarios y desarrolladores, que 
normalmente acceden desde fuera de la máquina donde reside la base de datos, se 
hace imprescindible contar con un control de concurrencia que verifique la consistencia de cada operación (transacción) y asegure que 
no se creen conflictos al momento de realizar una operación de escritura en un mismo registro en forma simultánea.

************ CREACION DE BASE DE DATOS ************

 .Sintaxis
 CREATE DATABASE NombreBaseDatos;


● TABLAS
 ¨¨¨¨¨¨¨
Las TABLAS nos sirven para poder almacenar información dentro de nuestra Base de Datos. Una Base de Datos contiene entonces un
conjunto de Tablas, en las cuales estaran almacenados los datos. Las Tablas tienen un solo NOMBRE y debe ser ÚNICO en toda la Base de
Datos. Las mismas estaran compuestas por Filas (Registros) y Columnas (Campos).
 
Por ejemplo 
                      COLUMNA 'A'             COLUMNA 'B'	            COLUMNA 'C'
Tabla CLientes:   |  (CampoA) Nombre  |  |  (CampoB) Apellido  |  |    (CampoC) Edad     |
     Fila 1         Juan (Registro1A)       Perez (Registro1B)      21 años (Registro1C)		
     Fila 2         Maria (Registro2A)      Alegre(Registro2B)      28 años (Registro2C)		
     Fila 3        Esteban (Registro3A)     Gomez (Registro3B)      28 años (Registro3C)		

Cada 'Campo' posee un tipo de dato asignado, y por lo tanto, el 'Registro' ingresado deben ser coincidente. 


• TIPOS DE DATOS:
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨

-Int (numeros enteros)        ----> Con UNSIGNED se especifica que los numeros admitidos seran solo los positivos. 

-Double (numeros reales)

-Char (caracteres)            ----> Letras, simbolos y numeros(como texto)

-Varchar (carater variable)   ----> Cadena de Texto (String).

-date (fecha)                 ----> aaaa-mm-dd

-datetime (fecha y hora)	  ----> aaaa-mm-dd HH:MM:SS	

-blob (texto)				  ----> se utliza para texto case sensitive.

*Restricciones y Modificadores de Datos: 
-NULL     --> Indica que un Campo puede tener o no un Registro. 		
-NOT NULL --> Sirve para establecer que un Campo debe tener si o si un registro al momento de completarse. 
-DEFAULT --> Permite especificar un valor predeterminado.

La expresión NULL significa "dato desconocido" o "valor inexistente". No es lo mismo que un valor 0 en un campo numérico ó una cadena 
de texto vacía. A veces, puede desconocerse o no existir el dato correspondiente a algún campo de un registro. En estos casos decimos 
que el campo puede contener valores nulos.
En contraposición, tenemos campos que no pueden estar vacíos jamás, por ejemplo, los campos que identifican cada registro 
que son Clave Primaria.
Por defecto, si no lo aclaramos en la creación de la tabla, los campos permiten valores nulos.


● CREACION DE TABLAS 
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
La sentencia CREATE TABLE creará una tabla con las columnas que indiquemos. Las Tablas se escriban en plural, mientras que los Campos 
en singular. Ayudara a que al leerlo se pueda distingir facilmente uno de otro. Por ejemplo Alumnos (plural) hace referencia a una 
'Tabla', mientras que 'alumno' (singular) a un Campo a completar.

. RESTRICCIONES DE LAS TABLAS
- Los nombres de las tablas deben ser únicos en la base de datos.
- Los nombres de las columnas debe ser únicos en la tabla.
- No podrán existir dos registros con el mismo valor de la clave primaria.


************ CREACION DE BASE DE DATOS ************

.Sintaxis
	CREATE TABLE NombreTabla(
		CampoA tipo de dato  
		CampoB tipo de dato 
		CampoC tipo de dato 
		....
		Columna/Campo tipo de dato  
	);

Las TABLAS seran completadas con Resgistro (filas - Valores).

.Ejemplo
	CREATE TABLE autos (
	    id_auto INT NOT NULL,	-- Se declara primero el 'identificador' y luego el 'tipo de dato'. Cada Atributo de la tabla se 
	    marca VARCHAR (50),     -- separa con "," (coma).            	
	    color VARCHAR (50),
	    modelo VARCHAR (50),
	    patente VARCHAR (10),
	    fecha_fabricacion DATE,                 
	);


●  PRIMARY KEY (PK)
Una Tabla puede tener una Columna o combinación de Columnas cuyos valores identifican de forma única a cada Registro de la Tabla.
Estas Columnas se denominan 'Clave Primaria'. Se puede crear una Clave Primaria mediante la definición de una restricción 
PRIMARY KEY cuando cree o modifique una tabla. Una Tabla sólo puede tener una única PRIMARY KEY y ninguna Columna a la que se aplique 
una restricción PRIMARY KEY puede aceptar valores NULL. 
En conclusion, una Clave Primaria es un campo o combinacion de campos, que aseguran que no va haber dos filas repetidas ya que sera
un valor unico de cada registro.

.'auto_increment'  --> Contador automatico. 
El motor de base de datos incrementará automáticamente su valor. Una tabla sólo puede tener un campo autoincremental y éste tiene que 
formar parte de la Clave Principal (PRIMARY KEY).

. Ejemplo1:
	CREATE TABLE autos (
	    id_auto INT NOT NULL AUTO_INCREMENT,
	    ...
	    PRIMARY KEY (id_auto),    -- A través de la palabra reservada Primary Key se declara la Clave Primaria de la Tabla.               
		...
	);


.Ejemplo2 (Primary Key Compuesta):
	CREATE TABLE Clientes(
		dni VARCHAR (9) NOT NULL,
		tipo_doc ENUM('dni','dni ext','ci','lc','le','pasaporte'),
		nombre VARCHAR (60) NOT NULL,
		apellido VARCHAR (60) NULL,
		PRIMARY KEY (tipo_doc,dni) --> Esta compuesto por mas de un Resgistro, cada campo por sí solo no es clave, ni tampoco 
		identifica al registro, pero la combinación de los dos forman la clave.
	);


● FOREING KEY (FK)
Para relacionar una Tabla con otra ambas deberán tener si o si Clave Primaria. Cuando una de las Claves Primaria sea
campo de la otra Tabla se la llamara Clave Forenea.

 FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)


● UNIQUE KEY (UQ)
La restricción UNIQUE se utiliza para garantizar que no se inserten valores duplicados en una columna específica o (combinación
de columnas) y que a su vez estas no formen parte de la CLAVE PRIMARIA. Es decir, vamos a utilizar Unique Key para indicar que en 
dicho Campo no se admitirán datos duplicados. A diferencia de Primary Key, Unique Key permite un 
valor nulo. 

.Ejemplo: 
	CREATE TABLE alumnos(
		id_alumno INT NOT NULL AUTO_INCREMENT,  
		apellido VARCHAR (50),                 	
		nombre VARCHAR (50),
		tipo_doc ENUM('dni','dni ext','ci','lc','le', 'pasaporte'), 
		num_doc INT UNSIGNED,
		fecha_nac DATE,                 
		telefono VARCHAR (20), 						
		correo VARCHAR (200),
		PRIMARY KEY (id_alumno),        -- Campo Relacional (Clave Principal).		
		UNIQUE KEY (tipo_doc, num_doc)  -- Campos Unicos (Campo local e irrepetible en la Tabla) 
	);


• ENUM: 
Nos permitira elegir unicamente entre ciertos valores posibiles para completar el Campo selecionado, limitando de esta forma
la cantidad de opciones posibles para seleccionar como valor. 

Tienen las siguientes características:
- Sólo se puede seleccionar un valor.
- Se puede definir una lista de hasta 65.535 valores distintos.
- Si se permiten valores null, éste será el valor predeterminado, y si no se define un valor predeterminado con DEFAULT, será el 
primer valor de la lista.
- Cada valor de la lista es enumerado con un índice (comenzando en 1).

. Ejemplo
	CREATE TABLE autos (
	    ...
	    color ENUM('negro','rojo','blanco','azul','celeste'),                 
		...
	);


• INSERTAR DATOS EN UNA TABLA
 ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Para insertar datos en una Tabla utilizaremos la sentencia INSERT. Con ella podemos ir añadiendo registros uno a uno, o añadir tantos 
registros como deseemos en una sola sentencia.

'INSERT INTO NombreTabla VALUES (Valor1, ..., ValorX);'

'INSERT INTO NombreTabla (Columna1, ..., ColumnaX) VALUES (Valor1, ..., ValorX);'

Los Valores deben corresponder con cada uno de los Campos que aparecen, tanto en el Tipo de Dato como en el orden en el que se van a 
asignar. 
Si un campo no está en la lista, se almacenará dentro de éste el valor NULL, siempre y cuando el campo admita valores null.
Si un campo tiene 'auto_increment' no es necesario ingresarlo, ya que se incrementa automaticamente. 
Se pueden ingresar todos los Datos o especificar solamente los Campos que se van a ingresar.


• ELIMINAR BASE DE DATOS / TABLA
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
. Sintaxis
DROP DATABASE NombreBaseDatos;
DROP DATABASE IF EXISTS NombreBaseDatos;

DROP TABLE NombreTabla;
DROP TABLE IF EXISTS NombreTabla;



• COMANDOS DE DESCRIPCIONES
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
DESCRIBE alumnos; -- dispara una estructura de la Tabla

SHOW DATABASE; para obtener un listado de todas las Bases de Datos existentes en un Servidor; 



• MODIFICAR TABLAS: ALTER TABLE
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Este comando permite modificar la estructura de una tabla. Se utiliza para agregar, modificar o eliminar Columnas, 
modificar el tipo de datos de una columna existente o renombrar una columna o una tabla.

• AGREGAR COLUMNAS: 
- En este ejemplo, se agrega una nueva Columna con el nombre Observaciones, a una tabla con el nombre articulos:

	ALTER TABLE articulos ADD COLUMN Observaciones VARCHAR(50) NULL;

- En el siguiente ejemplo, se agrega una nueva columna con el nombre Primera, a una tabla con el nombre clientes. Y se la ubica al 
comienzo de la tabla:

	ALTER TABLE clientes ADD COLUMN Primera VARCHAR(50) NULL FIRST;

- En el siguiente ejemplo, se agrega una nueva columna con el nombre Siguiente a una tabla cuyo nombre es clientes, entre las columnas
 Nombre y Apellido:
 
	ALTER TABLE clientes ADD COLUMN Siguiente VARCHAR(50) NULL AFTER Nombre;
 

• MODIFICAR COLUMNAS: 
- En el siguiente ejemplo, se modifica el nombre de la columna observaciones por comentarios, en la tabla articulos:
 
	ALTER TABLE articulos CHANGE observaciones comentarios VARCHAR(40) NULL;
 
- En el siguiente ejemplo, se modifica el tipo de dato de la columna comentarios en la tabla articulos:
 
	ALTER TABLE articulos MODIFY comentarios TEXT NULL;


• ELIMINAR COLUMNAS: 
- En el siguiente ejemplo, se elimina la columna comentarios de la tabla articulos:

	ALTER TABLE articulos DROP COLUMN comentarios;

- En el siguiente ejemplo, se eliminan las columnas Primera y Siguiente de la tabla clientes, en una sola sentencia:

	ALTER TABLE clientes DROP COLUMN Primera, DROP COLUMN Siguiente;


• RENOMBRAR UNA TABLA: 
- En el siguiente ejemplo, se modifica el nombre de la tabla Articulos por Productos:

	ALTER TABLE Articulos RENAME Productos;

Otra forma de cambiar el nombre de una tabla es:

	RENAME TABLE Articulos TO Productos;

	
• AGREGAR Y ELMINAR RESTRICCIONES: 
- En el siguiente ejemplo, se elimina la restricción Primary Key de la tabla Articulos:

	ALTER TABLE Articulos DROP Primary Key;

- En el siguiente ejemplo, se agrega la restricción Primary Key al campo ArticuloID, en la tabla Articulos:

	ALTER TABLE Articulos ADD Primary Key(ArticuloID);
	
- En el siguiente ejemplo, se elimina la restricción FOREIGN KEY del campo fk_articulo, de la tabla facturas:

	ALTER TABLE facturas DROP FOREIGN KEY fk_articulo;

- Y en el ejemplo siguiente, se agrega la restricción FOREIGN KEY al campo fk_articulo de la tabla facturas:

	ALTER TABLE facturas ADD CONSTRAINT fk_articulo FOREIGN KEY(ArticuloID) REFERENCES Articulos(ArticuloID);

**************************************************************************************************************************************

DROP DATABASE IF EXISTS clase01;
CREATE DATABASE clase01;
USE clase01; -- Indicamos la Base de Datos a utilizar. Si se evita este paso va a generar error. Este comando es de caracter OBLIGATORIO. 

#SHOW DATABASES;

-- • AUTOS:
DROP TABLE IF EXISTS autos;
CREATE TABLE autos (
id_auto INT NOT NULL AUTO_INCREMENT,		
marca VARCHAR (50),
modelo VARCHAR (50),
color VARCHAR (50),
patente VARCHAR (50) NOT NULL,	
PRIMARY KEY (id_auto),
UNIQUE KEY (patente)
);

INSERT INTO autos (marca, modelo, color, patente) VALUES ('Toyota', 'Etios','Blanco', 'ABC 123');
INSERT INTO autos (marca, modelo, color, patente) VALUES ('Renault', 'Clio','Gris', 'DEF 456');
INSERT INTO autos (marca, modelo, color, patente) VALUES ('Volkswagen', 'Fox','Negro', 'GHI 789');

/*Existe una version abreviada de INSERT INTO, pero hay que declarar los valores de aquellos Campos que  tengan 'auto_increment' con valor ' ' o valor '0'  
(cero) para que se no genere error. El orden de ingreso sera acorde al orden en el que fueron declarados los Campos, y la cantidad debe ser coincidente
tambien, por eso es necesario agregar un dato 'vacío' si la Tabla tiene un valor auto_increment. 
INSERT INTO autos VALUES (0, 'Volkswagen', 'Gol','Azul', 'BEI 440');
INSERT INTO autos VALUES ('', 'Renault', 'Duster','Gris', 'NAA 963');

-- MODIFICACION DE TABLAS:
ALTER TABLE autos ADD COLUMN FechaFabricacion DATE NULL;
ALTER TABLE autos CHANGE FechaFabricacion fecha_fab DATE NULL;
ALTER TABLE autos MODIFY fecha_fab VARCHAR(40) NULL;
ALTER TABLE autos DROP COLUMN fecha_fab;

ALTER TABLE autos RENAME autos_modificado;

SELECT * FROM autos_modificado;

DESCRIBE autos_modificado; 


-- • ALUMNOS:  

DROP TABLE IF EXISTS alumnos;
    CREATE TABLE alumnos (
    id_alumno INT NOT NULL AUTO_INCREMENT, 
    apellido VARCHAR (50),                 	
    nombre VARCHAR (50),
    tipo_doc ENUM('dni','dni ext','ci','lc','le', 'pasaporte'), 
    num_doc INT UNSIGNED,
    fecha_nac DATE,                 -- 'date' tipo de dato fecha "yyyy-mm-dd".
    telefono VARCHAR (20), 						
    correo VARCHAR (200),
    PRIMARY KEY (id_alumno),        -- Campo Relacional (Clave Principal).		
    UNIQUE KEY (tipo_doc, num_doc)  -- Campos Unicos (Campo local e irrepetible en la Tabla) 
    );

-- * INSERT MULTIPLE: Con el mismo formato que la Insercion, se pueden realizar multiples ingresos de Registro. 

    INSERT INTO alumnos (apellido, nombre, tipo_doc, num_doc, fecha_nac, telefono, correo) 
    VALUES 
         ('Gomez','Juan', 'dni', 34137365, 19900206,47440015,'mail@gmail.com'),
         ('Rodriguez','Carlos', 2, 36258545, '1992-06-10',47463896,'mail3@gmail.com'),
         ('Gutierrez','Maria', 3, 33258545, '1989-06-13',47453888,'mail4@gmail.com');  
	
-- * INSERT OPCIONAL: Se pueden ingresar todos los Datos o especificar solamente los Campos que se van a ingresar.
             
  INSERT INTO alumnos (apellido, nombre, tipo_doc, num_doc, fecha_nac) 
  VALUES ('Gimnez','Antonia', 1, 33135345, 19890308);        
  
  INSERT INTO alumnos (tipo_doc, num_doc, nombre, apellido, fecha_nac) 
  VALUES (1, 35135654, 'Carlos','Lopez', 19890308);        
  
  INSERT INTO alumnos (nombre, apellido, tipo_doc, num_doc) 
  VALUES ('Juan','Senheiser',1, 36789456); 
         
         
SELECT * FROM alumnos;

DESCRIBE alumnos; 
         
*/

package clase14;

public class SQL_parte1 {

}
