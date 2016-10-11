import java.sql.Date;

import javax.swing.JTextField;

public class ControlDate extends Control{
    
	private String regex;
	private JTextField fecha;
	
	@Override
	public void armar(){
		super.armar();
		fecha = new JTextField(10);
		getPanel().add(fecha);
	}
	
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public Date getValue() {
		return value;
	}
	public void setValue(Date value) {
		this.value = value;
	}
	private Date value;

	@Override
	public void limpiar() {
	}
	
	
}
