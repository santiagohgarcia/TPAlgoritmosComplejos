import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JSpinner;

public class ControlNumber extends Control {
	
	private String regex;
	private int value;
	private JSpinner spinner;
	
	@Override
	public void armar(){
		super.armar();
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(50,20));
		getPanel().add(spinner);
	}
	
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.add(new ParametroComando(getName(),String.valueOf(spinner.getValue())));
		return parametros;
	}

	@Override
	public void validar() throws Exception {
	}

	@Override
	public boolean estaVacio() {
		return spinner.getValue()==null;
	}
	

	
}
