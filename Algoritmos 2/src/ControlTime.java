import java.sql.Time;

public class ControlTime extends Control{
	private String regex;
	private Time value;

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
	
	
	
}
