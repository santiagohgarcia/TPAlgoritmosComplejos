import java.awt.Window;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import Nico.Libreria.controller.CDialog;
import Nico.Libreria.utils.UPaneles;

public class CProcesar extends CDialog{

	private VProcesar vista;
	private Process proceso;
	
	public CProcesar(Window padre, VProcesar vista, Configuracion config){
		this.vista = vista;		
		iniciarDerivable(padre,vista);
		accionBotones();
		vista.setVisible(true);
		new Thread(() -> ejecutarComando(getComandoArmado(config))).start();
	}

	private String getComandoArmado(Configuracion config){
		List<Control> controles = config.getControles();
		List<ParametroComando> parametros = new ArrayList<>();
		for(Control control: controles){
			parametros.addAll(control.getValores());
		}
		
		String parametrosConfig = config.getParams();
		for(ParametroComando parametro:parametros){
			parametrosConfig = StringUtils.replace(parametrosConfig, "["+parametro.getNombreParametro()+"]", parametro.getValorParametro());
			//parametrosConfig = parametrosConfig.replaceFirst("["+parametro.getNombreParametro()+"]", parametro.getValorParametro());
		}
		return parametrosConfig;
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
		try{
			proceso.destroyForcibly();
			UPaneles.mostrarInformacion(vista, "Se ha cancelado la operacion");
		}catch(Exception e){
			UPaneles.mostrarError(vista, "Ocurrio un error al intentar cancelar el proceso");
		}
	}
	
}
