/*
												TCP/IP 
TCP/IP es un conjunto de protocolos de comunicacion que permite la conexion y transmision de datos entre
dispositivos en redes. Su nombre proviene de dos de sus protocolos fundamentales: 
Protocolo de Control de Transmision (TCP) e Internet Protocol (IP). Fue desarrollado en los años 70 por 
el Departamento de Defensa de los Estados Unidos y se convirtia en el estandar de facto para la 
comunicacion en Internet.

TCP/IP consta de cuatro capas logicas, cada una de las cuales tiene funciones especificas:

1. Capa de Aplicacion: Esta capa es la mas cercana al usuario y contiene los protocolos que se utilizan
directamente para la interaccion con las aplicaciones. Aqui se encuentran protocolos como HTTP 
(Hypertext Transfer Protocol) para la navegacion web, SMTP (Simple Mail Transfer Protocol) para el 
correo electronico, FTP (File Transfer Protocol) para la transferencia de archivos, entre otros.

2.Capa de Transporte: La capa de transporte se encarga de la transferencia de datos entre aplicaciones 
en dispositivos finales. Los protocolos mas destacados en esta capa son TCP (Protocolo de Control de 
Transmision) y UDP (Protocolo de Datagrama de Usuario). TCP garantiza la entrega ordenada y confiable 
de datos, mientras que UDP es mas rapido pero no garantiza la entrega ni el orden.

3.Capa de Red: Esta capa se ocupa de la transmision de paquetes de datos a traves de la red desde el 
origen hasta el destino. El protocolo mas conocido en esta capa es el Protocolo de Internet (IP), 
que asigna direcciones IP a los dispositivos y enruta los paquetes hacia su destino.

4.Capa de Enlace de Datos: La capa de enlace de datos se encarga de la transmision de datos a traves
de medios fisicos, como cables o señales inalambricas. Esta capa tambien define las reglas para el 
acceso y control del medio fisico. Ejemplos de protocolos en esta capa son Ethernet y Wi-Fi.

Cuando un dispositivo envia datos a traves de una red utilizando TCP/IP, los datos se dividen en 
pequeños paquetes que viajan independientemente a traves de la red. Cada paquete contiene una 
direccion de origen, una direccion de destino y datos. Los routers y otros dispositivos de red se 
encargan de enrutar los paquetes hacia su destino final, donde son ensamblados nuevamente en la 
secuencia correcta para ser interpretados por la aplicacion de destino.

TCP/IP ha sido la base fundamental del crecimiento y exito de Internet, y se ha convertido en el 
conjunto de protocolos de red mas utilizado en el mundo. Su arquitectura abierta y escalable ha 
permitido el desarrollo de aplicaciones y servicios innovadores, lo que ha llevado a la revolucion 
digital que experimentamos en la actualidad.

En resumen TCP/IP es un conjunto de protocolos que permite la comunicacion y el enrutamiento de 
datos en una red. Se ocupa de la transmision y entrega confiable de paquetes de datos
entre dispositivos.
 
 											HTTP
HTTP (Hypertext Transfer Protocol) es un protocolo de la capa de aplicacion en el modelo TCP/IP y
es fundamental para el funcionamiento de la World Wide Web (WWW). Fue desarrollado por Tim Berners-Lee
a principios de los años 90 y es utilizado para solicitar y transferir recursos entre un servidor y 
un cliente.

Caracterasticas de HTTP:
1. Cliente-Servidor: HTTP sigue un modelo cliente-servidor, donde un Cliente realiza solicitudes a un
Servidor Web que contiene los recursos solicitados.

2. Sin estado: HTTP es un protocolo sin estado, lo que significa que cada solicitud del cliente al 
servidor es independiente de las solicitudes anteriores. El servidor no mantiene un registro del estado
anterior de la comunicacion con el cliente.

3. Metodos de solicitud: HTTP define varios metodos de solicitud que indican la accion que se debe 
realizar en el recurso solicitado. Los metodos mas comunes son GET (obtener), POST (enviar datos al 
servidor), PUT (actualizar), DELETE (eliminar), entre otros.

4. Codigos de estado: HTTP utiliza codigos de estado para indicar el resultado de una solicitud. Por 
ejemplo, el codigo "200 OK" indica que la solicitud fue exitosa, mientras que el codigo "404 Not Found" 
indica que el recurso solicitado no fue encontrado.

5. Encabezados: HTTP utiliza encabezados para transmitir informacion adicional sobre la solicitud o la 
respuesta. Los encabezados pueden incluir informacion sobre el tipo de contenido, la longitud del 
contenido, cookies, autenticacion, entre otros.

6. Estado de sesion: HTTP en si mismo es un protocolo sin estado, lo que significa que no mantiene 
informacion de estado entre solicitudes. Para mantener el estado de sesion, las aplicaciones web utilizan 
tecnicas como cookies o sesiones en el servidor.

Basicamente HTTP es un protocolo de aplicacion utilizado para transferir recursos, entre un cliente y un 
servidor.

En resumen, TCP/IP es el conjunto de protocolos que permite la comunicacion en una red, y HTTP 
es un protocolo especifico en la capa de apliacion utilizado para solicitar y transferir recursos. 

										WEB SERVER
Un Web Server (servidor web) es un programa o software que proporciona servicios de hosting y entrega de 
paginas web y otros recursos a traves de Internet o una red local. 
Sera el encargado de administrar las peteciones provenientes del Cliente, procesar el pedido y generar 
una respuesta.

El funcionamiento basico de un servidor web implica recibir solicitudes de clientes (navegadores web u 
otras aplicaciones que utilizan HTTP) y responder a esas solicitudes enviando los recursos solicitados. 
Estos recursos estaran almacenados previamente en la base de datos con la que este trabajando el servidor 
o generados dinamicamente en el momento de la solicitud, dependiendo del tipo de servidor y las tecnologias
utilizadas.

Vamos a encontrar basicamente dos grandes capas: Una capa encargada de establecer un canal de comunicacion
entre el Cliente y el Servidor Web, y otra capa de comunicacion entre el Servidor Web y la base de datos.

En la primer capa geralmente vamos a tener un conjunto de archivos cuyo fin sera a comunicarse con el cliente
a traves de HTTP, como pueden ser archivos .html, .css, .js, .json entre otros. En la segunda capa vamos a 
tener un conjunto de archivos cuyo fin sera procesar la informacion proveniente del cliente, y hacer las 
peticiones correspondiente con la base de datos o lugar donde esten alojados esos recursos. 

El circuito basico sera el siguiente:
. A traves de TCP/IP se establece la comunicacion y el enrutamiento de datos en una red entre dos o 
mas dispositivos. Es decir que se estable una conexion para la transmision y entrega confiable de 
paquetes de datos entre dispositivos.

. Desde el Cliente se va a generar un Request (pedido) y este sera escuchado por el Web Server a traves 
de HTTP. El Request sera procesado en el Web Server para devolver una respuesta. A traves de los Controladores
vamos a comunicar la capa encargada de recibir el request del cliente con la parte backend del Web Server, como 
pueden ser archivos .java. 

. Desde la parte back se utilizaran las herramientas correspondientes a cada lenguaje para 
comunicarse con la base de datos. En el caso de archivos .java generalmente a traves
de algun ORM nos vamos a comunicar con la base de datos. Se transmite entonces la solicitud
a la base de datos y esta procesara la informacion en su correspondiente lenguaje
como por ejemplo SQL.

. La base de datos va a brindar una respuesta a la solicitud enviada y a traves del mismo 
ORM se enviara esa respuesta a nuestros archivos .java.

. La informacion sera procesada y a traves de los Controladores se enviara la respuesta a la capa encargada de 
comunicarse con el cliente, y esta utlima a traves del Response enviara la respuesta que finalmente recibira
el cliente http.

												SERVLETS
En Java, un Servlet es una clase que implementa la interfaz javax.servlet.Servlet y se utiliza para extender
la funcionalidad de un servidor web. Los Servlets son parte fundamental de la tecnologia Java, que permite 
desarrollar aplicaciones web dinamicas y escalables.

Cuando un cliente realiza una solicitud HTTP a un servidor web que ejecuta aplicaciones Java, 
el servidor invoca el Servlet apropiado para procesar esa solicitud. El Servlet 
puede realizar diferentes tareas, como procesar datos ingresados por el usuario, interactuar con bases de datos, 
generar contenido dinamico y enviar respuestas al cliente. Es decir, los Servlets son un conjunto de Clases e 
Interfaces con la capacidad de procesar las solicitudes HTTP y generar un respuesta. 

. Interfaz Servlet: Los Servlets implementan la interfaz javax.servlet.Servlet, que define los metodos que deben 
implementarse, como init(), service(), doGet(), doPost(), destroy(), entre otros.

. Ciclo de Vida: Los Servlets siguen un ciclo de vida bien definido. Se inicializan una sola vez cuando se cargan por 
primera vez o cuando el servidor se inicia. Luego, pueden manejar multiples solicitudes de manera concurrente, y 
finalmente se destruyen cuando el servidor se detiene o cuando se decide retirarlos.

Gestion de Solicitudes y Respuestas: Los Servlets procesan las solicitudes HTTP y generan respuestas dinamicas que 
se envian de vuelta al cliente. Pueden leer datos enviados por el cliente (por ejemplo, mediante formularios) y 
procesarlos para ofrecer contenido personalizado.

API Servlet: Java proporciona una API de Servlet (javax.servlet) que contiene clases e interfaces que facilitan la 
creacion de Servlets, manejo de sesiones, redirecciones, entre otros aspectos relacionados con el desarrollo web.

Los Servlets son una tecnologia central para desarrollar aplicaciones web en Java. Sin embargo, tambien es comun que 
se utilicen junto con otras tecnologias, como JavaServer Pages (JSP) o frameworks web como Spring, para crear 
aplicaciones web mas robustas y eficientes. En conjunto, estas tecnologias forman un enfoque conocido como el 
Modelo-Vista-Controlador (MVC) para el desarrollo web en Java.



									API (Application Programming Interface)
En Java, una API (Application Programming Interface) se refiere a un conjunto de clases, interfaces, metodos
y constantes que proporcionan una forma estandarizada para que los desarrolladores interactuen con el software 
y servicios proporcionados por un sistema.

La idea en lineas generales es poder generar una aplicacion que sera consumida por terceros, en donde, cualquier 
persona que utilice el mismo protocolo se pueda conectar a mi aplicacion y consumir los servicios de la misma, 
pueda hacer consultas y recibir una respuesta. A traves del protocolo TCP/IP cualquier persona se podra conectar 
a la API y generar un mecanismo de consultas para consumir los servicios. Cada persona entonces podra generar sus 
propios mecanismos de consulta y su forma propia de consumir los servicios de API, siempre y cuando, se respete 
el TCP/IP con HTTP. Esto tambien permitira que cada API tenga su propio vocabulario de para su consumo, pero 
sus conexiones para transferir los paquetes de datos estara orientada siempre a TCP/IP con HTTP. 
En resumen esto va a permitir que cada API tenga su propio vocabulario para su consumo, y que a su vez cada 
persona que quiera consumir mi API pueda usar ese voculario para generar su propio mecanismo de consulta, 
siempre y cuando, se respete el TCP/IP con HTTP como conexion para transferir los paquetes de datos.

Java EE es un conjunto de especificaciones, tenemos la especificacion Servlet que es la mas antigua y la mas estable.
El resto de especificaciones con los mismos fines como por ejemplo JSP, JSF o Jax-RS seran en definitiva una 
implentacion de los Servlet. Es decir, el resto de las especificaciones terminara siendo un Servlet. El Servidor Web en 
Java terminara siendo un conetendor de Servelets.
Las especificaciones JSP o JSF terminaran produciendo archivos .html para paginas web, mientras que la especificacion 
Jax-RS va a generar una especificacion REST HTTP, es decir un servicio. A traves de este servicio REST vamos a poder 
trabajar con formatos como del tipo .json.

En esencia, una API define como los componentes de software deben comunicarse entre si. Sirve como un contrato 
o puente entre diferentes modulos o aplicaciones, permitiendo que se comuniquen y utilicen funcionalidades 
entre si sin necesidad de conocer todos los detalles internos de implementacion.

Los Servidores los van a instalar y manejar los IDE, nosotros nos tenemos que encargar de proporcionarle el archivo
.zip, o .rar correspondiente.



--------------------------------------------------------------------------------------------------------------------------




*/

package clase01.docs;

public class clase01 {

}
