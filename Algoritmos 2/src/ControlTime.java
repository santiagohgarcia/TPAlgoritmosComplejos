import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class ControlTime extends Control{
	private String regex;
	private Time value;
	private JTextField txtTime;

	@Override
	public void armar(){
		super.armar();
		txtTime = new JTextField(10);
		getPanel().add(txtTime);
	}
	
	public Time getValue() {
		return value;
	}

	public void setValue(Time value) {
		this.value = value;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	@Override
	public void limpiar() {
	}
	
	public boolean validar()
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txtTime.getText());
		return matcher.matches();
	}
	
	
}
