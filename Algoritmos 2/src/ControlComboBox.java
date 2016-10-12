import java.util.ArrayList;
import java.util.List;

import Nico.Libreria.view.mi_swing.MiCombo;

public class ControlComboBox extends Control{

	private List<String> options = new ArrayList<>();
	private MiCombo<String> combo;

	@Override
	public void armar(){
		super.armar();
		combo = new MiCombo<>();
		combo.addItems(options);
		getPanel().add(combo);
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.add(new ParametroComando(getName(),String.valueOf(combo.getSelectedItem())));
		return parametros;
	}

	@Override
	public void validar() {
	}

	@Override
	public boolean estaVacio() {
		return false;
	}
	
	
	
}
