/*
												TCP/IP 
TCP/IP es un conjunto de protocolos de comunicación que permite la conexión y transmisión de datos entre
dispositivos en redes de computadoras. Su nombre proviene de dos de sus protocolos fundamentales: 
Protocolo de Control de Transmisión (TCP) e Internet Protocol (IP). Fue desarrollado en los años 70 por 
el Departamento de Defensa de los Estados Unidos y se convirtió en el estándar de facto para la 
comunicación en Internet.

TCP/IP consta de cuatro capas lógicas, cada una de las cuales tiene funciones específicas:

1. Capa de Aplicación: Esta capa es la más cercana al usuario y contiene los protocolos que se utilizan
directamente para la interacción con las aplicaciones. Aquí se encuentran protocolos como HTTP 
(Hypertext Transfer Protocol) para la navegación web, SMTP (Simple Mail Transfer Protocol) para el 
}correo electrónico, FTP (File Transfer Protocol) para la transferencia de archivos, entre otros.

2.Capa de Transporte: La capa de transporte se encarga de la transferencia de datos entre aplicaciones 
en dispositivos finales. Los protocolos más destacados en esta capa son TCP (Protocolo de Control de 
Transmisión) y UDP (Protocolo de Datagrama de Usuario). TCP garantiza la entrega ordenada y confiable 
de datos, mientras que UDP es más rápido pero no garantiza la entrega ni el orden.

3.Capa de Red: Esta capa se ocupa de la transmisión de paquetes de datos a través de la red desde el 
origen hasta el destino. El protocolo más conocido en esta capa es el Protocolo de Internet (IP), 
que asigna direcciones IP a los dispositivos y enruta los paquetes hacia su destino.

4.Capa de Enlace de Datos: La capa de enlace de datos se encarga de la transmisión de datos a través
de medios físicos, como cables o señales inalámbricas. Esta capa también define las reglas para el 
acceso y control del medio físico. Ejemplos de protocolos en esta capa son Ethernet y Wi-Fi.

Cuando un dispositivo envía datos a través de una red utilizando TCP/IP, los datos se dividen en 
pequeños paquetes que viajan independientemente a través de la red. Cada paquete contiene una 
dirección de origen, una dirección de destino y datos. Los routers y otros dispositivos de red se 
encargan de enrutar los paquetes hacia su destino final, donde son ensamblados nuevamente en la 
secuencia correcta para ser interpretados por la aplicación de destino.

TCP/IP ha sido la base fundamental del crecimiento y éxito de Internet y se ha convertido en el 
conjunto de protocolos de red más utilizado en el mundo. Su arquitectura abierta y escalable ha 
permitido el desarrollo de aplicaciones y servicios innovadores, lo que ha llevado a la revolución 
digital que experimentamos en la actualidad.

En resumen TCP/IP es un conjunto de protocolos que permite la comunicación y el enrutamiento de 
datos en una red. Se ocupa de la transmisión, enrutamiento y entrega confiable de paquetes de datos
entre dispositivos.
 
 											HTTP
HTTP (Hypertext Transfer Protocol) es un protocolo de la capa de aplicación en el modelo TCP/IP y
es fundamental para el funcionamiento de la World Wide Web (WWW). Fue desarrollado por Tim Berners-Lee
a principios de los años 90 y es utilizado para solicitar y transferir recursos, como páginas web, 
imágenes, videos, entre otros, entre un servidor y un cliente (generalmente un navegador web).

• Características de HTTP:
1. Cliente-Servidor: HTTP sigue un modelo cliente-servidor, donde un cliente (generalmente un navegador
web) realiza solicitudes a un servidor web que contiene los recursos solicitados.

2. Sin estado: HTTP es un protocolo sin estado, lo que significa que cada solicitud del cliente al 
servidor es independiente de las solicitudes anteriores. El servidor no mantiene un registro del estado
anterior de la comunicación con el cliente.

3. Métodos de solicitud: HTTP define varios métodos de solicitud que indican la acción que se debe 
realizar en el recurso solicitado. Los métodos más comunes son GET (obtener), POST (enviar datos al 
servidor), PUT (actualizar), DELETE (eliminar), entre otros.

4. Códigos de estado: HTTP utiliza códigos de estado para indicar el resultado de una solicitud. Por 
ejemplo, el código "200 OK" indica que la solicitud fue exitosa, mientras que el código "404 Not Found" 
indica que el recurso solicitado no fue encontrado.

5. Encabezados: HTTP utiliza encabezados para transmitir información adicional sobre la solicitud o la 
respuesta. Los encabezados pueden incluir información sobre el tipo de contenido, la longitud del 
contenido, cookies, autenticación, entre otros.

6. Estado de sesión: HTTP en sí mismo es un protocolo sin estado, lo que significa que no mantiene 
información de estado entre solicitudes. Para mantener el estado de sesión, las aplicaciones web utilizan 
técnicas como cookies o sesiones en el servidor.

Basicamente HTTP es un protocolo de aplicación utilizado para transferir recursos, como páginas web, entre
un cliente y un servidor.
En resumen, TCP/IP es el conjunto de protocolos que permite la comunicación en una red, mientras que HTTP 
es un protocolo específico utilizado para solicitar y transferir recursos en la World Wide Web. HTTP se basa 
en TCP/IP para la entrega de datos y la comunicación en la red.

										WEB SERVER
Un Web Server (servidor web) es un programa o software que proporciona servicios de hosting y entrega de 
páginas web y otros recursos a través de Internet o una red local. 
Será el encargado de administrar las peteciones provenientes del Cliente (navegador/ front), procesar el 
pedido y generar un respuesta al Cliente.

El funcionamiento básico de un servidor web implica recibir solicitudes de clientes (navegadores web u 
otras aplicaciones que utilizan HTTP) y responder a esas solicitudes enviando los recursos solicitados, 
como páginas HTML, imágenes, hojas de estilo, scripts, videos, entre otros. Estos recursos son almacenados 
previamente en el servidor o generados dinámicamente en el momento de la solicitud, dependiendo del tipo de 
servidor y las tecnologías utilizadas.

 Vamos a encontrar básicamente dos grandes capas:

Una capa encargada de comunicarse con el cliente (navegador/ parte front) y otra capa encargada de 
comunicarse con la base de datos. En la primer capa geralmente vamos a tener un conjunto de archivos 
.html, .css y .js para conectarse a través de HTTP con el Cliente, mientras que en la segunda capa 
vamos a tener un conjunto de archivos generalemente .java, .php, .etc para procesar la información
proveniente del front, hacer las peticiones correspondiente con la base de datos y procesar la 
respuesta.

* Si bien como Cliente suele hacerse referencia al navegador, no necesariamente tiene que ser una navegador, 
puede ser cualquier sistema que responda a HTTP. Es decir, el Cliente será un cualquier Cliente HTTP. Los 
Clientes se van a conectar al Servidor Web a través de HTTP sin importar que tecnología esten utilizando. 
Gracias al TCP/IP se va a permitir la conexión entre los dipositivos adentro de internet. Cada maquina tiene 
una IP que la identifica y gracias al TCP se puede dar la transferencia de datos entre un equipo y el otro. 
HTTP será un protocolo más para realizar la transferencia como paginas web entre un equipo y otro. Habra un 
equipo que será un Cliente HTTP y enviará Request hacia el otro equipo que hara de Web Server, quien enviará 
mediante el Response al Cliente HTTP las respuestas de sus Request.

El circuito básico sería el siguiente:
. A través de TCP/IP se establece la comunicación y el enrutamiento de datos en una red entre dos o 
más dispositivos. Es decir que se estable una conexión para la transmisión, enrutamiento y entrega 
confiable de paquetes de datos entre dispositivos.

. Desde el Cliente se va a generar un Request (pedido) y este será escuchado por el Web Server a través 
de HTTP. El Request será procesado en el Web Server para devolver un respuesta. A través de los Controladores
vamos a comunicar nuestros archivos .html, .css y .js con nuestra parte back del Web Server que pueden ser 
archivos .java. 

. Desde la parte back se utilizarán las herramientas correspondientes a cada lenguaje para 
comunicarse con la base de datos. En el caso de nuestros archivos .java generalmente a través
de algún ORM nos vamos a comunicar con la base de datos. Se transmite entonces el pedido de 
informacíon a la base de datos y esta procesa la información en su correspondiente lenguaje
como por ejemplo SQL.

. La base de datos generará un respuesta sobre la información solicitada y a través de nuestro 
ORM vamos poder recibir esa respuesta en nuestros archivos .java.

. La información será procesada y a través de los Controladores se enviará una respuesta por el Response 
con los archivos .html, .css, .js solicitados. Es decir, a través de los Controloadores vamos a terminar 
de generar los archivos .html, .css, .js con la información solicitada de la base de datos y enviaremos
esta respuesta a través del Response para que el Cliente HTTP la pueda interpretar y utilizar. En el caso 
de estar generando una respuesta para la World Wide Web (www) los archivos serán .html, .css y .js y 
finalmente en el navegador se van a interpretar y generar la respuesta al usuario.
Tambien por el Response se puede devolver información en crudo como puede ser un formato .json para ser
utilizada en un Cliente HTTP pero que no necesariamente Web, no necesariamente todas las respuestas 
generadas van a ser una archivo html. 
		
									API (Application Programming Interface)
En Java, una API (Application Programming Interface) se refiere a un conjunto de clases, interfaces, métodos
y constantes que proporcionan una forma estandarizada para que los desarrolladores interactúen con el software 
y servicios proporcionados por un sistema o biblioteca.

La idea en líneas generales es poder generar una aplicación que sera consumida por terceros, en donde, cualquier 
persona que utilice el mismo protocolo se pueda conectar a mi aplicacion y consumir los servicios de la misma, 
pueda hacer consultas y recibir una respuesta. A través de un protocolo TCP/IP cualquier persona se podrá conectar 
a la API y generar un mecanismo de consultas para consumir los servicios. Cada persona entonces podra generar sus 
propios mecanismos de consulta y su forma propia de consumir los servicios de API, siempre y cuando, se respete 
el TCP/IP con HTTP. Esto tambien permitirá que cada API tenga su propio vocabulario de para su consumo, pero 
sus conexiones para transferir los paquetes de datos estará orientada siempre a TCP/IP con HTTP. 
En resumen esto va a permitir que cada API tenga su propio vocabulario para su consumo, y que a su vez cada 
persona que quiera consumir mi API pueda usar ese voculario para generar su propio mecanismo de consulta, 
siempre y cuando, se respete el TCP/IP con HTTP como conexión para  para transferir los paquetes de datos.

Java EE es un conjunto de especificaciones, tenemos la especificación Servlet que es la mas antigua y la mas estable.
El resto de especificaciones con los mismos fines como por ejemplo JSP, JSF o Jax-RS serán en definitiva una 
implentacion de los Servlet. Es decir, el resto de las especificaciones terminará siendo un Servlet. El Servidor Web en 
Java terminará siendo un conetendor de Servelets.
Las especificaciones JSP o JSF terminarán produciendo archivos .html para páginas web, mientras que la especificación 
Jax-RS va a generar una especificación REST HTTP, es decir un servicio. A través de este servicio REST vamos a poder 
trabajar con formatos como del tipo .json.

En esencia, una API define cómo los componentes de software deben comunicarse entre sí. Sirve como un contrato 
o puente entre diferentes módulos o aplicaciones, permitiendo que se comuniquen y utilicen funcionalidades 
entre sí sin necesidad de conocer todos los detalles internos de implementación.

Los Servidores los van a instalar y manejar los IDE, nosotros nos tenemos que encargar de proporcionarle el archivo
.zip, o .rar correspondiente.


												SERVLETS
En Java, un Servlet es una clase que implementa la interfaz javax.servlet.Servlet y se utiliza para extender
la funcionalidad de un servidor web. Los Servlets son parte fundamental de la tecnología Java, que permite 
desarrollar aplicaciones web dinámicas y escalables.

Cuando un cliente realiza una solicitud HTTP (como hacer clic en un enlace o enviar un formulario) a un servidor web 
que ejecuta aplicaciones Java, el servidor invoca el Servlet apropiado para procesar esa solicitud. El Servlet 
puede realizar diferentes tareas, como procesar datos ingresados por el usuario, interactuar con bases de datos, 
generar contenido dinámico y enviar respuestas al cliente. Es decir, los Servlets son un conjunto de Clases e 
Interfaces con la capacidad de procesar las solicitudes HTTP y generar un respuesta. 

. Interfaz Servlet: Los Servlets implementan la interfaz javax.servlet.Servlet, que define los métodos que deben 
implementarse, como init(), service(), doGet(), doPost(), destroy(), entre otros.

Ciclo de Vida: Los Servlets siguen un ciclo de vida bien definido. Se inicializan una sola vez cuando se cargan por 
primera vez o cuando el servidor se inicia. Luego, pueden manejar múltiples solicitudes de manera concurrente, y 
finalmente se destruyen cuando el servidor se detiene o cuando se decide retirarlos.

Gestión de Solicitudes y Respuestas: Los Servlets procesan las solicitudes HTTP y generan respuestas dinámicas que 
se envían de vuelta al cliente. Pueden leer datos enviados por el cliente (por ejemplo, mediante formularios) y 
procesarlos para ofrecer contenido personalizado.

API Servlet: Java proporciona una API de Servlet (javax.servlet) que contiene clases e interfaces que facilitan la 
creación de Servlets, manejo de sesiones, redirecciones, entre otros aspectos relacionados con el desarrollo web.

Los Servlets son una tecnología central para desarrollar aplicaciones web en Java. Sin embargo, también es común que 
se utilicen junto con otras tecnologías, como JavaServer Pages (JSP) o frameworks web como Spring, para crear 
aplicaciones web más robustas y eficientes. En conjunto, estas tecnologías forman un enfoque conocido como el 
Modelo-Vista-Controlador (MVC) para el desarrollo web en Java.

--------------------------------------------------------------------------------------------------------------------------




*/

package clase01.docs;

public class clase01 {

}
