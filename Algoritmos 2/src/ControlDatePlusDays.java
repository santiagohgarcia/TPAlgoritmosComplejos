
public class ControlDatePlusDays extends Control{
	private ControlDate dateLow;
	private ControlNumber days;
	
	@Override
	public void armar(){
		super.armar();
		dateLow.armar();
		days.armar();
		getPanel().add(dateLow.getPanel());
		getPanel().add(days.getPanel());
	}
	
	public ControlNumber getDays() {
		return days;
	}
	public void setDays(ControlNumber days) {
		this.days = days;
	}
	public ControlDate getDateLow() {
		return dateLow;
	}
	public void setDateLow(ControlDate dateLow) {
		this.dateLow = dateLow;
	}
	@Override
	public void limpiar() {
	}
	
	public boolean validar()
	{
		if ( dateLow.validar() && days.validar() )
			return true;
		else
	        return false;
	}
}
