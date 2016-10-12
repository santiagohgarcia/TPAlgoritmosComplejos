import java.util.ArrayList;
import java.util.List;

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
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.addAll(dateLow.getValores());
		parametros.addAll(days.getValores());
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{
		dateLow.validar();
		days.validar();
	}

	@Override
	public boolean estaVacio() {
		return dateLow.estaVacio() || days.estaVacio();
	}
}
