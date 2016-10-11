import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.JTextField;

public class ControlDate extends Control{
    
	private String regex;
	private JTextField fecha;
	private Date value;
	
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

	@Override
	public void limpiar() {
	}
	
	public boolean validar()
	{ 
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
	    Date parsed = null;
	    try {
	        parsed = sdf.parse(fecha.getText());
	        return true;
	    } catch (ParseException e1) {
            return false;
	    }
	}
	
}
