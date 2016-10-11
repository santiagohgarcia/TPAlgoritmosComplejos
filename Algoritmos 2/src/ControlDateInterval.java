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
	public void limpiar() {
	}
	
}
