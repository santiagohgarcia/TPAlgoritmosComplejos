import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

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
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.add(new ParametroComando(getName(),txtTime.getText()));
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txtTime.getText());
		if(!matcher.matches()){
			throw new Exception("Formato de tiempo invalido");
		}
	}

	@Override
	public boolean estaVacio() {
		return StringUtils.isEmpty(txtTime.getText());
	}
	
	
}
