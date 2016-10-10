import java.util.List;


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
		String cmd = "ping google.com"; 
		new CProcesar(vista,new VProcesar(vista),cmd);

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
