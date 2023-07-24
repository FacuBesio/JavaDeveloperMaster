package ar.com.aop.aspectos;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Esta Clase sera nuestro Aspecto, con una funcionalidad transversal que tendrá que ejecutarse siempre. 

@Component // Indicamos primero que es un Component.
@Aspect // Indicamos que esta Clase es un Aspecto.
public class LoginConAspecto {

	/* 
	 Utilizamos @Before("execution(public void insertarCliente())") para que se ejecute ANTES del método indicado. 
	 Si hay más de un método con este nombre en distintas Clases, el aspecto se va a ejecutar siempre por que no
	 hace distinciones por Clase, sino por el nombre del método sin importar su instanciacion. 
	 . En el caso de querer que el aspecto se ejecute solo para una Clase en particular, simplemente se utilizará un 
	 pointCutExpression. Para ello debemos incluir la ruta de la Clase donde queremos que se ejecute el método en el @Before
	 Por ejemplo: @Before("execution(public void ar.com.aop.dao.ClientesVIPDAO.insertarCliente())").
	 . En el caso de querer que se ejecute para todos los métodos que empiecen con el un determinado formato
	 podremos hacer uso del siguiente pointCutExpression en el @Before:
	 Por ejemplo: @Before("execution(public void insertar*())"). 
	 De esta forma estamos indicando que todos los métodos que tengan como firma insertar#####...*(), serán incluidos en
	 este Aspecto y se ejecutará el método.
	 */
	
	//@Before("execution(public void insertarCliente())")
	//@Before("execution(public void ar.com.aop.dao.ClientesVIPDAO.insertarCliente())")
	@Before("execution(public void insertar*())")
	public void antesInsertarCliente() {
		System.out.println("@Before: Se comprobo que el Usuario esta correctamente logeado.");
		System.out.println("El Role/Perfil de Usuario logeado puede insertar datos en la DB.");

	}

    /*	@AfterReturning: Esta anotación la utilizaremos para ejecutar un aspecto después de la ejecución del método especificado en 
    el pointCutExpression de la anotación. El @AfterReturning se ejecutará siempre y cuando, el método declarado como pointCutExpression 
    retorne normal, es decir, sin generar excepciones.  
    */
	@AfterReturning("execution(public void insertarCliente())")
	public void despuesDeInsertarCliente() {
		System.out.println(" @AfterReturning: Este método se ejecuta después de insertaCliente()");
	}
	
	 /*	@AfterThrowing: Esta anotación la utilizaremos para ejecutar un aspecto únicamente después de que un método especificado en el 
	 pointCutExpression lance una Excepcion. En el caso de que el método especificado en el pointCutExpression se ejecute normalmente 
	 sin que una Exepcion suceda, el @AfterThrowing no se ejecutará.
    */
	@AfterThrowing(pointcut = "execution(public * insertarClienteConError())", throwing = "daoe")
	public void logException(Exception daoe) {
		System.out.println("ERROR NO se INSERTO el cliente. Sucedio un Error en el método insertarClienteConError() por eso me acabo de "
				+ "ejecutar");
	}

}
