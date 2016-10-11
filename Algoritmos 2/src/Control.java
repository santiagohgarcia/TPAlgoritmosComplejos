import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Control{
     private String name;
     private String label;
     private JPanel panel; 
     private boolean armado = false;
     
     
    public void armar(){
    	if(!armado){
        	panel = new JPanel();
        	panel.setLayout(new FlowLayout(0,0,0));
        	panel.add(new JLabel(label));
        	armado = true;
    	}else{
    		limpiar();
    	}
    }
     
    public abstract void limpiar();
    
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
