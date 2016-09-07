import java.util.List;


public class Aplicacion {
	private String nombre;
	private List<Configuracion> configuraciones;
	
	//para testear
	public Aplicacion(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Configuracion> getConfiguraciones() {
		return configuraciones;
	}

	public void setConfiguraciones(List<Configuracion> configuraciones) {
		this.configuraciones = configuraciones;
	}

	@Override
	public String toString(){
		return nombre;
	}
}
