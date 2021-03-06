import java.util.ArrayList;
import java.util.List;

public class Configuracion {
	private String nombre;
	private String command;
	private String params;
	private List<Control> controles = new ArrayList<Control>();
	
	public void armar(){
		controles.forEach(c -> c.armar());
	}
	
	public List<Control> getControles() {
		return controles;
	}

	public void setControles(List<Control> controles) {
		this.controles = controles;
	}

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

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	
	@Override
	public String toString(){
		return nombre;
	}
}
