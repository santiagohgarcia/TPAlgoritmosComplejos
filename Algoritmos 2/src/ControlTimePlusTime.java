import java.sql.Time;

public class ControlTimePlusTime extends Control{
	
	private ControlTime timeLow;
	private ControlTime timeToSum;
	
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
	
}
