import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlTimeInterval extends Control{

	private ControlTime timeLow;
	private ControlTime timeHigh;
	private boolean interval;
	
	public boolean isInterval() {
		return interval;
	}

	public void setInterval(boolean interval) {
		this.interval = interval;
	}

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
		List<ParametroComando> timeHighValues = timeHigh.getValores();
		if(!interval){
			String tLow = timeLow.getValores().get(0).getValorParametro();
			String tHigh = timeHigh.getValores().get(0).getValorParametro();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1,date2;
				try {
					date1 = format.parse(tLow);
					date2 = format.parse(tHigh);
					long difference = date2.getTime() - date1.getTime(); 
					int difInt = (int)(difference/1000);
					String resultado="";
					if(difInt<10){
						resultado = "00:00:0"+difInt;
					}else{
						resultado = "00:00:"+difInt;
					}
					timeHighValues.get(0).setValorParametro(resultado);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		parametros.addAll(timeLow.getValores());
		parametros.addAll(timeHighValues);
		
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
