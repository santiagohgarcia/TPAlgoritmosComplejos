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
	public void limpiar() {
	}
	

	
}
