import java.util.ArrayList;
import java.util.List;

public class ControlTimePlusTime extends Control{
	
	private ControlTime timeLow;
	private ControlTime timeToSum;
	
	@Override
	public void armar(){
		super.armar();
		timeLow.armar();
		timeToSum.armar();
		getPanel().add(timeLow.getPanel());
		getPanel().add(timeToSum.getPanel());
	}
	
	public ControlTime getTimeLow() {
		return timeLow;
	}
	public void setTimeLow(ControlTime timeLow) {
		this.timeLow = timeLow;
	}
	public ControlTime getTimeToSum() {
		return timeToSum;
	}
	public void setTimeToSum(ControlTime timeToSum) {
		this.timeToSum = timeToSum;
	}
	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.addAll(timeLow.getValores());
		parametros.addAll(timeToSum.getValores());
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{
		timeLow.validar();
		timeToSum.validar();
	}

	@Override
	public boolean estaVacio() {
		return timeLow.estaVacio() || timeToSum.estaVacio();
	}
	
}
