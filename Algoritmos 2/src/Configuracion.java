
public class Configuracion {
	private String nombre;
	
	//para testear combo
	public Configuracion(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString(){
		return nombre;
	}
}
