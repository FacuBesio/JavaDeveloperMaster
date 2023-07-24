/*
										● CONSULTAS (QUERIES) - SELECT
										  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
SELECT => Es un selector de Registros de una Tabla.
La sentencia SELECT permite realizar operaciones de selección, consulta, orden, agrupación y filtrado de registros. Es decir, se 
utiliza para seleccionar y/o consultar información almacenada en una o varias tablas.
El comando 'SELECT' por si solo no necesita una TABLA para ejecutarse, puede operar por si solo y puede servir para seleccionar datos, 
realizar operaciones,  etc y devolvera la información en una Tabla que generara como resultado.            

La cláusula WHERE se utiliza para establecer un criterio de búsqueda o filtro.

.Ejemplo: 

SELECT (1+1); 
SELECT (3.14 * 2);

.Sintaxis para realizar CONSULTAS: 

SELECT Campo FROM Tabla;  -- Se indican los campos de la Tabla que se desan consultar. 

- Ejemplos: 

SELECT nombre FROM profesores; -- Selecciona de la Tabla 'profesores' todos los Resgistros de la Columna 'nombre' .

SELECT apellido, nombre FROM profesores; -- Selecciona de la Tabla 'profesores' las Columnas 'apellido' y 'nombre' con sus 
                                             registros correspondientes.
                                       
- Para seleccionar todas las columnas se utiliza el  " * "(asterisco). Es decir, va a consultar todos los Registros de todos los Campos
de la Tabla.  

SELECT * FROM Tabla;


● 'AS':
El comando 'AS' sirve para establecer un 'Alias' a las operaciones que no estan asociadas una Columna o Table en particular. 

Ejemplo:
SELECT (1+1) AS resultado, 
SELECT (3.14 * 2) AS pi_2;
SELECT (precio * 1.21) AS Iva from Tabla AS otronombre;

   
● ORDENAMIENTO DE DATOS - 'ORDER BY':
¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Tiene como finalidad ordenar los resultados de las consultas por Columnas en lugar de respetar el orden por defecto del campo índice Primary Key. El orden 
puede ser Ascendente (por defecto ASC) o Descendente (DESC). Se puede ordenar por una columna o un conjunto de ellas, yendo de mayor importancia a
menor importancia, es decir, la primer Columna declarada sera la que predomine sobre el resto y asi sucesivamente. 

El siguiente ejemplo ordena el resultado en relación al atributo 'apellido' por defecto ascendente.

SELECT nombre, apellido FROM clientes ORDER BY apellido; 

El siguiente ejemplo ordena el resultado por el atributo apellido por defecto ascendente y Nombre descendente

SELECT nombre, apellido FROM clientes ORDER BY apellido ASC, nombre DESC;


● LIMITAR LA CANTIDAD DE REGISTROS - 'LIMIT' / 'OFFSET':
¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
* LIMIT:
Su funcionalidad es la de limitar el número de filas (registros/resultados) devueltas como resultado en las consultas SELECT. 

.Sintaxis

SELECT nombre, apellido FROM clientes LIMIT 2;  

Indica que de todos los Registros que hay como resultado 'Clientes' imprima solamente los primeros 2 registros. 
                
*OFFSET
Opera en combinación con la cláusula LIMIT y permite posicionarse en un registro indicado. A partir de este registro indicado es que 'LIMIT' seleccionará
la cantidad de registros establecidos en la sentencia.

El siguiente ejemplo limita a 2 el número total de registros a partir del 4 registro.

SELECT nombre, apellido FROM clientes LIMIT 2 OFFSET 4; 

Indica que de todos los Registros que hay como resultado 'Clientes' imprima solamente los primeros 2 registros, a partir del registro 4.

 
 ● CONSULTAS CONDICIONALES - CLAUSULA 'WHERE':
 ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
El modficador 'WHERE' nos va a servir para especificar que es lo que estamos buscando a través de operadores aritméticos y lógicos. Lo 
utilizaremos para filtrar Resgistros en nuestra consulta segun un determinado criterio. Se pueden añadir al WHERE los Operadores 
Logicos (AND, OR y XOR) para poder hacer mas especifica todavía la consulta. 
Se indica que 'Campos' quiero SELECCIONAR para realizar la consulta. 'DESDE' que Tabla voy a seleccionar dichos CAMPOS 'DONDE' se 
cumpla la condicion especificada.                                  

SELECT apellido, nombre, tipo_doc FROM alumnos WHERE tipo_doc = 2              

En este caso traera únicamente los Registros de las Columnas 'apellido, nombre, tipo_doc', DESDE la Tabla 'alumnos' 
DONDE " tipo_doc = 2" 
	
Ejemplos:

SELECT apellido, nombre, tipo_doc, num_doc FROM alumnos WHERE tipo_doc = 2 AND num_doc > 30000000; 
       
SELECT apellido, nombre, tipo_doc, num_doc FROM alumnos WHERE (tipo_doc = 4 AND num_doc > 30000000) OR
 															  (tipo_doc = 5 AND num_doc > 30000000); 


● SENTENCIA 'BETWEEN':
¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Al momento de querer realizar una búsqueda y establecer un rango de Parámetros entre los Valores de los Registros vamos a utilizar BETWEEN. Con dicha 
sentencia podremos comprobar si una expresión está comprendida (o no) en un determinado rango de valores. Siempre tiene que estar expresado de mínimo a máximo. 

.Sintaxis:
. BETWEEN mínimo AND máximo
. NOT BETWEEN mínimo AND máximo

Ejemplo: 
SELECT * FROM Articulos WHERE precio BETWEEN 100 AND 200;
SELECT * FROM Articulos WHERE precio NOT BETWEEN 100 AND 200


● SENTENCIA 'IN':
¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
Los operadores IN y NOT IN sirven para averiguar si un determinado valor está dentro de un conjunto indicado.

. IN (valor1, valor2, valor3...) El operador IN devuelve un valor verdadero si el valor de algun Registro es igual a alguno de los valores 
especificados.
. NOT IN (valor1, valor2, valor3...)
El operador NOT IN devuelve un valor falso en el caso contrario. 

. Ejemplo: 

SELECT nombre, marca, precio FROM Productos WHERE marca IN ('Philps', 'Samsung', 'Sony');  
           
Es mucho mas prolijo sintacticamenteque que si utlizariamos el operador 'OR'.           
"SELECT nombre, marca, precio FROM Productos WHERE marca='Philps' OR marca='Samsung' OR marca='Sony';"   

SELECT nombre, marca, precio FROM Productos WHERE marca NOT IN ('Philps', 'Samsung', 'Sony');

          
          
          
          
• IMPORTAR TABLAS DESDE ORÍGENES EXTERNOS
  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
En muchas oportunidades se presenta el caso de que una empresa posee las tablas generadas en Microsoft Access o Microsoft Excel y 
debido a la cantidad de información que empiezan a contener esas tablas, se decide pasar las tablas a SQL para trabajarlas de una mejor manera.
MySQL Workbench permite la importación de tablas externas. El único problema que se presenta es que este motor de bases de datos sólo 
admite la importación de tablas que se hallen en archivos con formato CSV o JSON.
Dado que esas tablas no fueron generadas dentro de un entorno SQL, los campos no tendrán definidos tipos de datos ni modificadores. Al 
momento de llevar a cabo la importación de las tablas, se podrá definir el tipo de dato para cada uno de los campos. 

. MECANISMO DE IMPORTACIÓN:
Para importar tablas desde archivos con formato CSV o JSON:

1. Pulsa el clic derecho del mouse sobre el nombre de la base de datos en uso.
2. Selecciona la opción Table Data Import Wizard. 
3. Pulsa el botón Browse.
4. Ubica y abre el archivo que contiene la tabla a importar.
5. Pulsa el botón Next.
6. Especifica si quieres volcar los datos de la tabla importada en una tabla existente dentro de la base de datos, o selecciona la 
opción Create new table para crear una nueva tabla dentro de la base de datos. Puedes cambiar el nombre de la tabla, o mantener el 
nombre por defecto (el nombre del archivo). Pulsa Next.
7. En este paso, podrás especificar los tipos de dato para cada campo. Por defecto, MySQL Workbench asignará a cada campo (columna) un 
tipo de dato según los valores que encuentre en ellos. Estos tipos de datos asignados se pueden cambiar, seleccionándolos de las listas
desplegables.
8. Una vez definidos los tipos de datos para campo, pulsa Next.
9. En este paso, sólo se especifica que se llevará a cabo la importación de los datos desde el archivo de datos externo. Sólo bastará 
con pulsar Next para comenzar la importación.
10. Finalizado el proceso de importación, pulsa el botón Next para poder observar la pantalla final. En esta vista encontrarás el 
tiempo que tardó la importación de los datos, la confirmación de que la tabla fue creada dentro de la base de datos y la cantidad de 
registros importados desde el origen externo.
11. Pulsa Finish para concluir el asistente.
12. No olvides actualizar los esquemas para observar la tabla dentro de la base.


*/

package clase15;

public class SQL_parte2 {

}
