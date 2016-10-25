import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlDateInterval extends Control {
	private ControlDate dateLow;
	private ControlDate dateHigh;
	private boolean interval;
	
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
	/*	List<ParametroComando> parametros = new ArrayList<>();
		parametros.addAll(dateLow.getValores());
		parametros.addAll(dateHigh.getValores());
		return parametros;*/
		
		List<ParametroComando> parametros = new ArrayList<>();
		List<ParametroComando> dateHighValues = dateHigh.getValores();
		if(!interval){
			String dLow = dateLow.getValores().get(0).getValorParametro();
			String dHigh = dateHigh.getValores().get(0).getValorParametro();
			SimpleDateFormat format = new SimpleDateFormat(dateLow.getRegex());
			Date date1,date2;
				try {
					date1 = format.parse(dLow);
					date2 = format.parse(dHigh);
					long difference = date2.getTime() - date1.getTime(); 
					int difInt = (int)(difference/1000); //seconds
					Integer resultado = difInt / 60 / 60 / 24;//days
					dateHighValues.get(0).setValorParametro(resultado.toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		parametros.addAll(dateLow.getValores());
		parametros.addAll(dateHighValues);
		
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
