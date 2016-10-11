
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
	public void limpiar() {
	}
	
	
	
	
}
