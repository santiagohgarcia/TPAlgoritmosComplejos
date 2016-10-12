import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlDateInterval extends Control {
	private ControlDate dateLow;
	private ControlDate dateHigh;
	
	@Override
	public void armar(){
		super.armar();
		dateLow.armar();
		dateHigh.armar();
		getPanel().add(dateLow.getPanel());
		getPanel().add(dateHigh.getPanel());
	}
	
	public ControlDate getDateLow() {
		return dateLow;
	}
	public void setDateLow(ControlDate dateLow) {
		this.dateLow = dateLow;
	}
	public ControlDate getDateHigh() {
		return dateHigh;
	}
	public void setDateHigh(ControlDate dateHigh) {
		this.dateHigh = dateHigh;
	}
	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.addAll(dateLow.getValores());
		parametros.addAll(dateHigh.getValores());
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{
		dateLow.validar();
		dateHigh.validar();
	}

	@Override
	public boolean estaVacio() {
		return dateLow.estaVacio() || dateHigh.estaVacio();
	}
	
}
