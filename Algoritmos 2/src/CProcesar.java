import java.awt.Window;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Nico.Libreria.controller.CDialog;
import Nico.Libreria.utils.UPaneles;

public class CProcesar extends CDialog{

	private VProcesar vista;
	private Process proceso;
	
	public CProcesar(Window padre, VProcesar vista, String comando){
		this.vista = vista;		
		iniciarDerivable(padre,vista);
		accionBotones();
		vista.setVisible(true);
		new Thread(() -> ejecutarComando(comando)).start();
	}

	private void ejecutarComando(String comando) {
		try {
			proceso = Runtime.getRuntime().exec(comando); 
			BufferedReader in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));  
			//impresion en pantalla
			String line = null;
			if((line=in.readLine())!=null){
				vista.addFirstLine(line);
			}
			while ((line = in.readLine()) != null) {  
			    vista.addNewLine(line);  
			}
			proceso.exitValue();
			vista.habilitarCerrar();
			vista.deshabilitarCancelar();
			UPaneles.mostrarInformacion(vista, "Comando finalizado con exito");
		}catch (Exception e) {
			UPaneles.mostrarError(vista, "Ocurrio un error inesperado");
		}
	}

	private void accionBotones() {
		vista.addCerrarListener(a -> cerrar());
		vista.addCancelarListener(a -> cancelarListener());
	}

	private void cancelarListener() {
		proceso.destroyForcibly();
		UPaneles.mostrarInformacion(vista, "Se ha cancelado la operacion");
	}
	
}
