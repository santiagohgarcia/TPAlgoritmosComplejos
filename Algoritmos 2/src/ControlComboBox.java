import java.util.ArrayList;
import java.util.List;

public class ControlComboBox extends Control{

 
	private List<Integer> options = new ArrayList<Integer>();
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public List<Integer> getOptions() {
		return options;
	}

	public void setOptions(List<Integer> options) {
		this.options = options;
	}
	
	
	
}
