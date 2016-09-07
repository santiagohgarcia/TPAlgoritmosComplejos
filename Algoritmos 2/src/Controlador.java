import java.util.ArrayList;
import java.util.List;


public class Controlador {
	private VentanaPrincipal vista;
	private List<Aplicacion> aplicaciones;
	public Controlador(VentanaPrincipal vista){
		this.vista = vista;
		aplicaciones = new ArrayList<>();
		testAplicaciones();
		accionBotones();
		iniciar();
		vista.setVisible(true);
	}

	private void iniciar() {
		Aplicacion primeraApp = aplicaciones.get(0);
		vista.setTitle(primeraApp.getNombre());
		vista.setConfiguraciones(primeraApp.getConfiguraciones());
		
	}

	//solo para testear los combos
	private void testAplicaciones() {
		List<Configuracion> configuraciones1 = new ArrayList<>();
		configuraciones1.add(new Configuracion("config1 ap1"));
		configuraciones1.add(new Configuracion("config2 ap1"));
		configuraciones1.add(new Configuracion("config3 ap1"));
		
		List<Configuracion> configuraciones2 = new ArrayList<>();
		configuraciones2.add(new Configuracion("config1 ap2"));
		configuraciones2.add(new Configuracion("config2 ap2"));
		configuraciones2.add(new Configuracion("config3 ap2"));
		
		List<Configuracion> configuraciones3 = new ArrayList<>();
		configuraciones3.add(new Configuracion("config1 ap3"));
		configuraciones3.add(new Configuracion("config2 ap3"));
		configuraciones3.add(new Configuracion("config3 ap3"));
		
		Aplicacion ap1 = new Aplicacion("Aplicacion 1");
		ap1.setConfiguraciones(configuraciones1);
		Aplicacion ap2 = new Aplicacion("Aplicacion 2");
		ap2.setConfiguraciones(configuraciones2);
		Aplicacion ap3 = new Aplicacion("Aplicacion 3");
		ap3.setConfiguraciones(configuraciones3);
		
		aplicaciones.add(ap1);
		aplicaciones.add(ap2);
		aplicaciones.add(ap3);
		
		vista.setAplicaciones(aplicaciones);
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
