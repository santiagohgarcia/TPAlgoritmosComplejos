import java.util.ArrayList;
import java.util.List;


public class Controlador {
	private VentanaPrincipal vista;
	private List<Aplicacion> aplicaciones;
	public Controlador(VentanaPrincipal vista, TP_ACyEDA tp){
		this.vista = vista;
		aplicaciones = tp.getApps();
		vista.setAplicaciones(aplicaciones);
		accionBotones();
		iniciar();
		vista.setVisible(true);
	}

	private void iniciar() {
		Aplicacion primeraApp = aplicaciones.get(0);
		vista.setTitle(primeraApp.getNombre());
		vista.setConfiguraciones(primeraApp.getConfiguraciones());
		
	}

	private void accionBotones() {
		vista.addAplicacionListener(l -> aplicacionListener());
		vista.addConfiguracionListener(l -> configuracionListener());
	}
	
	private void aplicacionListener(){
		Aplicacion app = vista.getSelectedAplicacion();
		if(app!=null){
			vista.setTitle(app.getNombre());
			vista.setConfiguraciones(app.getConfiguraciones());
		}
	}
	
	private void configuracionListener(){
		
	}
}
