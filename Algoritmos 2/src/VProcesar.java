import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

public class VProcesar extends JDialog{

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JButton btnCerrar;
	private JTextArea txtSalida;
	private static final String newLine = System.getProperty("line.separator");

	public VProcesar(JFrame padre) {
		super(padre);
		setTitle("Ejecucion del comando");
		setSize(400,350);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(l -> habilitarCerrar());
		panel.add(btnCancelar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setEnabled(false);
		panel.add(btnCerrar);
		
		txtSalida = new JTextArea();
		txtSalida.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtSalida);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblSalidaDelComando = new JLabel("Salida del comando");
		getContentPane().add(lblSalidaDelComando, BorderLayout.NORTH);
		lblSalidaDelComando.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalidaDelComando.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void addCancelarListener(ActionListener lst){
		btnCancelar.addActionListener(lst);
	}
	
	public void addCerrarListener(ActionListener lst){
		btnCerrar.addActionListener(lst);
	}
	
	public void deshabilitarCancelar(){
		btnCancelar.setEnabled(false);
	}
	
	public void habilitarCerrar(){
		btnCerrar.setEnabled(true);
	}
	
	public void addNewLine(String texto){
		txtSalida.append(texto+newLine);
	}

	public void addFirstLine(String texto) {
		txtSalida.append(texto);
	}

}
