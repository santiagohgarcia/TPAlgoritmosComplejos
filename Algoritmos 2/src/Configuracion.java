import java.util.ArrayList;
import java.util.List;

public class Configuracion {
	private String nombre;
	private String command;
	private String params;
	private List<Control> controles = new ArrayList<Control>();
	
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
