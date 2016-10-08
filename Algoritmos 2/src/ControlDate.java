import java.sql.Date;

public class ControlDate extends Control{
    
	private String regex;
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
	
	
}
