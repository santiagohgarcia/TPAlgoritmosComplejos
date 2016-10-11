import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlFileChooser extends Control{

	//TODO FALTA
	private String defaultDir;
	private String tipoArch;
	private String value;
	private JFileChooser file;
	private JTextField txtRuta;
	private JButton btnFile;

	@Override
	public void armar(){
		super.armar();
		txtRuta = new JTextField(10);
		btnFile = new JButton("Explorar");

		btnFile.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	 file = new JFileChooser();
		    	 
		    	 List<String> tiporArchList = Arrays.asList(tipoArch.split(","));
		    	
		    	 file.setAcceptAllFileFilterUsed(false);
		    	 for (String tipoArchElem : tiporArchList) {
		    		 file.addChoosableFileFilter(new FileNameExtensionFilter(tipoArchElem,tipoArchElem));
			      	}
		    	 
		    	 file.setCurrentDirectory(new File(defaultDir));
		    	 
		         int status = file.showOpenDialog(null);
		            if (status == JFileChooser.APPROVE_OPTION) {
		                File selFile = file.getSelectedFile();
		                if (selFile == null) {
		                    return;
		                }

		                txtRuta.setText(selFile.getAbsolutePath());

		            }
		    }
		});
		getPanel().add(txtRuta);
		getPanel().add(btnFile);
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getDefaultDir() {
		return defaultDir;
	}
	public void setDefaultDir(String defaultDir) {
		this.defaultDir = defaultDir;
	}
	public String getTipoArch() {
		return tipoArch;
	}
	public void setTipoArch(String tipoArch) {
		this.tipoArch = tipoArch;
	}
	@Override
	public void limpiar() {
		
	}
}
