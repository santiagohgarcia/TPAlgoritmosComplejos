import java.util.List;

import Nico.Libreria.utils.UPaneles;


public class CPrincipal {
	private VPrincipal vista;
	private List<Aplicacion> aplicaciones;
	public CPrincipal(VPrincipal vista, TP_ACyEDA tp){
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
		vista.addProcesarListener(l -> procesarListener());
	}
	
	private void procesarListener() {
		List<Control> controles = vista.getSelectedConfig().getControles();
		boolean algunVacio = controles.stream().anyMatch(c -> c.estaVacio());
		if (algunVacio){
			UPaneles.mostrarError(vista, "Complete todos los campos");
			return;
		}
		try{
			for(Control control:controles){
				control.validar();
			}
			new CProcesar(vista,new VProcesar(vista),vista.getSelectedConfig());
		}catch(Exception e){
			UPaneles.mostrarError(vista, e.getMessage());
		}
	}

	private void aplicacionListener(){
		Aplicacion app = vista.getSelectedAplicacion();
		if(app!=null){
			vista.setTitle(app.getNombre());
			vista.setConfiguraciones(app.getConfiguraciones());
		}
	}
	
	private void configuracionListener(){
		Configuracion config = vista.getSelectedConfig();
		if (config!=null) {
			config.armar();
			vista.addControls(config.getControles());
		} 
	}
}
