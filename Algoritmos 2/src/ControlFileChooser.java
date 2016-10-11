import java.util.ArrayList;
import java.util.List;

public class ControlFileChooser extends Control{

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String defaultDir;
	private String tipoArch;
	private String value;
	

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
