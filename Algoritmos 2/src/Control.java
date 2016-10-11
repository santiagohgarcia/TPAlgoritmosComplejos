import javax.swing.JPanel;

public class Control{
     private String name;
     private String label;
     private JPanel panel = new JPanel();
         
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
    
	public JPanel getPanel(){
		return panel;
	}
     
}
