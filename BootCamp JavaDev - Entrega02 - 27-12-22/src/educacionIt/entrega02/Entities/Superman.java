package educacionIt.entrega02.Entities;

public class Superman extends Volador{
	
	private boolean traje_superHeroe;
	private String color_capa;
	
	
	public Superman(String nombre, int velocidad_max, boolean traje_superHeroe, String color_capa) {
		super(nombre, velocidad_max);
		this.traje_superHeroe = traje_superHeroe;
		this.color_capa = color_capa;
	}

		
	public void aterrizar_superman() {
		System.out.println("Aterriza SUPERMAN - " + getNombre() + " | Con Capa " + getColor_capa() );
	}
	
	@Override
	public String toString() {
		return "Superman [traje_superHeroe=" + traje_superHeroe + ", color_capa=" + color_capa + ", getNombre()="
				+ getNombre() + ", getVelocidad_max()=" + getVelocidad_max() + "]";
	}


	public boolean isTraje_superHeroe() {
		return traje_superHeroe;
	}


	public void setTraje_superHeroe(boolean traje_superHeroe) {
		this.traje_superHeroe = traje_superHeroe;
	}


	public String getColor_capa() {
		return color_capa;
	}


	public void setColor_capa(String color_capa) {
		this.color_capa = color_capa;
	}
	
}
