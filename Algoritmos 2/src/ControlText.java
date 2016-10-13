import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import org.apache.commons.lang3.StringUtils;

public class ControlText extends Control {
    
	private JTextField texto;
	
	@Override
	public void armar(){
		super.armar();
		texto = new JTextField(10);
		getPanel().add(texto);
	}

	@Override
	public List<ParametroComando> getValores() {
		List<ParametroComando> parametros = new ArrayList<>();
		parametros.add(new ParametroComando(getName(),texto.getText()));
		return parametros;
	}
	
	@Override
	public void validar() throws Exception
	{ 
//		try {
//		} catch (ParseException e1) {
//            throw new Exception("Texto no valido");
//	    }
	}

	@Override
	public boolean estaVacio() {
		return StringUtils.isEmpty(texto.getText());
	}
	
}
