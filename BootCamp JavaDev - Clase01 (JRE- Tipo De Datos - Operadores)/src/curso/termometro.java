package curso;

/* Esta Clase transforma grados Celsius en Farenheith.*/

public class termometro {

	 
	
	public static void main(String[] args) {
		
		//Variables => Espacio f�sico donde almacenamos datos.
		
		
		//Entrada de Datos 
		double in= 1; 
		
		//Proceso de transformaci�n del Dato
		/*(0 �C � 9/5) + 32 = 32 �F*/
		
		double gradosF = (in*9/5) + 32;
		
		//Salida de Datos
		System.out.println("La temperatura de "+ in + "�C en Farenheith es: "+ gradosF+"�F");
		
		
		//Proceso inverso
		double gradosC= (gradosF - 32)*5/9;
		
		System.out.println("La temperatura de "+ gradosF + "�F en Celsius es: "+ gradosC+"�C");
		
		
		
		
	}

}
