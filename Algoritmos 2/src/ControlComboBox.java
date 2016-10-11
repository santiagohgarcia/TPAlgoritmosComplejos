import java.util.ArrayList;
import java.util.List;

import Nico.Libreria.view.mi_swing.MiCombo;

public class ControlComboBox extends Control{

	private List<String> options = new ArrayList<>();
	private MiCombo<String> combo;
	private String value;

	@Override
	public void armar(){
		super.armar();
		combo = new MiCombo<>();
		combo.addItems(options);
		getPanel().add(combo);
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public void limpiar() {
	}
	
	
	
}
