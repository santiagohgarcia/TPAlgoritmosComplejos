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
	public void limpiar() {
	}
	
	public boolean validar()
	{
		if ( timeLow.validar() && timeToSum.validar() )
			return true;
		else
	        return false;
	}
	
}
