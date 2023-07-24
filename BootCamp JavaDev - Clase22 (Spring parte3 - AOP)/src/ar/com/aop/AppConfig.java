package ar.com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/*A trav�s de @Configuration indica que la Clase va a ser un archivo de Configuraci�n. Es decir, en lugar de un archivo 'xml', en esta Clase
se va a declarar todo lo necesario para que se puedan gestionar los Beans.
Mediante @EnableAspectJAutoProxy vamos a indicar que se va a usar AOP y donde buscar las Clases con los Aspectos correspondientes. 
Habilitamos la Programaci�n Orientada a Aspectos y buscar� en el paquete indicado en @ComponentScan("") todos los Aspectos.
*/
@Configuration// Indicamos que esta Clase es un archivo de Configuraci�n.
@EnableAspectJAutoProxy // Habilitamos la configuraci�n de programaci�n orientada a aspecto .
@ComponentScan("ar.com.aop")// Le indica a donde ir a buscar los aspectos , esto buscar� en el paquete raiz y los paquetes subyacentes.
public class AppConfig {
	//esta clase no necesita llevado codigo en su interior 
}
