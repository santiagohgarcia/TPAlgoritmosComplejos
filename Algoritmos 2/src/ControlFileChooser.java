import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

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
		btnFile = new JButton();
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
