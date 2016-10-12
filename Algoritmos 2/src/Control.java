import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Control{
     private String name;
     private String label;
     private JPanel panel; 
     
    public void armar(){
    	panel = new JPanel();
    	panel.setLayout(new FlowLayout(0,10,0));
    	panel.add(new JLabel(label));
    }
     
    public abstract List<ParametroComando> getValores();
    
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
	
	public abstract void validar() throws Exception;
	public abstract boolean estaVacio();
}
