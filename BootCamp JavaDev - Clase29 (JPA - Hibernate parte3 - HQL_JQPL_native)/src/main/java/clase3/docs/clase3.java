/*
HQL es el lenguaje de consultas que usa Hibernate para recuperar informaci�n y manipular la base de datos. Su sintaxis recuerda mucho a 
SQL, pero las consultas no se realizar�n sobre las tablas de la base de datos, sino sobre los objetos vinculados a una tabla en la base
de datos.
Hibernate Query Language (HQL) es un lenguaje de consulta creado espec�ficamente para el framework de mapeo objeto-relacional (ORM)
llamado Hibernate. Hibernate es una herramienta popular en el mundo Java que permite a los desarrolladores interactuar con una base de 
datos relacional utilizando objetos y clases en lugares de escribir consultas SQL directamente. HQL se asemeja mucho a SQL en su sintaxis 
y estructura, pero en lugar de trabajar con tablas y columnas de la base de datos, se centra en trabajar con entidades y propiedades del 
dominio definido en las clases Java que est�n mapeadas a las tablas de la base de datos. De esta manera, HQL permite escribir consultas 
orientadas a objetos en lugar de consultas basadas en tablas, lo que facilita el desarrollo y mantenimiento de aplicaciones.

En HQL la cl�usula `WHERE` se utiliza para filtrar los resultados de una consulta y permite establecer condiciones que deben cumplir las
entidades (objetos) que deseamos recuperar de la base de datos. La cl�usula `WHERE` en HQL es similar a la cl�usula `WHERE` en SQL, pero
se aplica a las entidades y sus propiedades en lugar de tablas y columnas.

JPQL (Java Persistence Query Language) es un lenguaje de consulta similar a HQL, definido como parte de las mejoras de JPA (Java 
Persistence API). Es decir, HQL es un lenguaje manejado Hibernate (lo que nos produce una relaci�n de dependencia con el ORM) y JPQL es 
un lenguaje similar pero responde a JPA por lo tanto JPQL sera compatible con cualquier ORM que implemente JPA (permitiendo programar sin 
una dependencia directa con el ORM que se este utlizando).

B�sicamente tenemos 3 opciones para conectarnos desde Java con nuestra base de datos:
. A trav�s de JDBC donde terminamos utilizando SQL para escribir nuestras querys y se escriben manualmente orientado a Tablas. 
. A trav�s de SpringBoot y JPA, donde el ORM se encagar� de escribir las querys automaticamente y nuestra responsabilidad ser� solamente 
transmitirle al ORM lo que se quiere hacer).
. A trav�s de JPQL (o HQL), donde vamos a escribir nuestras querys manualmente pero ser� orientado a Objetos y no a Tablas, es decir
escribiremos directamente en JPQL orientado a Clases y Objetos, y no en SQL orientado al modelos Relacional.


*/

package clase3.docs;

public class clase3 {

}
