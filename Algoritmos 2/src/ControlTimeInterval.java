import java.util.ArrayList;
import java.util.List;

public class ControlTimeInterval extends Control{

	private ControlTime timeLow;
	private ControlTime timeHigh;
	
	@Override
	public void armar(){
		super.armar();
		timeLow.armar();
		timeHigh.armar();
		getPanel().add(timeLow.getPanel());
		getPanel().add(timeHigh.getPanel());
	}
	
	public ControlTime getTimeLow() {
		return timeLow;
	}
	public void setTimeLow(ControlTime timeLow) {
		this.timeLow = timeLow;
	}
	public ControlTime getTimeHigh() {
		return timeHigh;
	}
	public void setTimeHigh(ControlTime timeHigh) {
		this.timeHigh = timeHigh;
	}
	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.addAll(timeLow.getValores());
		parametros.addAll(timeHigh.getValores());
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{
		timeLow.validar();
		timeHigh.validar();
	}

	@Override
	public boolean estaVacio() {
		return timeLow.estaVacio() || timeHigh.estaVacio();
	}
	
	
}
