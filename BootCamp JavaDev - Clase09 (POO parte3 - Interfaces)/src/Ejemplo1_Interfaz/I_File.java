package Ejemplo1_Interfaz;

public interface I_File {

	void setArchivos(Archivo archivo);
	
	String getArchivos(Archivo archivo);
    
    default void info(){
        System.out.println("Hola desde M�todo default - Interface I_File");
    } 
	
}
