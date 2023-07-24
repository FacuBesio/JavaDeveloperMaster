package ar.com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/*A través de @Configuration indica que la Clase va a ser un archivo de Configuración. Es decir, en lugar de un archivo 'xml', en esta Clase
se va a declarar todo lo necesario para que se puedan gestionar los Beans.
Mediante @EnableAspectJAutoProxy vamos a indicar que se va a usar AOP y donde buscar las Clases con los Aspectos correspondientes. 
Habilitamos la Programación Orientada a Aspectos y buscará en el paquete indicado en @ComponentScan("") todos los Aspectos.
*/
@Configuration// Indicamos que esta Clase es un archivo de Configuración.
@EnableAspectJAutoProxy // Habilitamos la configuración de programación orientada a aspecto .
@ComponentScan("ar.com.aop")// Le indica a donde ir a buscar los aspectos , esto buscará en el paquete raiz y los paquetes subyacentes.
public class AppConfig {
	//esta clase no necesita llevado codigo en su interior 
}
