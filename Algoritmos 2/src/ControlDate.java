import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

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

	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.add(new ParametroComando(getName(),fecha.getText()));
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{ 
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
	    Date parsed = null;
	    try {
	        parsed = sdf.parse(fecha.getText());
	    } catch (ParseException e1) {
            throw new Exception("Formato de fecha no valido");
	    }
	}

	@Override
	public boolean estaVacio() {
		return StringUtils.isEmpty(fecha.getText());
	}
	
}
