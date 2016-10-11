import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class VPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
	private JComboBox<Configuracion> cbConfig;
	private JComboBox<Aplicacion> cbAplicacion;
	private JPanel panelPrincipal;
	public VPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnProcesar = new JButton("Procesar");
		panelSur.add(btnProcesar);
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelAplicacion = new JPanel();
		panelNorte.add(panelAplicacion);
		
		JLabel lblAplicacion = new JLabel("Aplicacion");
		panelAplicacion.add(lblAplicacion);
		
		cbAplicacion = new JComboBox<>();
		panelAplicacion.add(cbAplicacion);
		
		JPanel panelConfig = new JPanel();
		panelNorte.add(panelConfig);
		
		JLabel lblConfig = new JLabel("Configuracion");
		panelConfig.add(lblConfig);
		
		cbConfig = new JComboBox<Configuracion>();
		panelConfig.add(cbConfig);
		
		panelPrincipal = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(panelPrincipal);
	
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void addControls(List<Control> controles){
		panelPrincipal.removeAll();
		controles.forEach(c -> panelPrincipal.add(c.getPanel()));
	}
	
	public void setAplicaciones(List<Aplicacion> aplicaciones){
		cbAplicacion.removeAllItems();
		for(Aplicacion app:aplicaciones){
			cbAplicacion.addItem(app);
		}
	}
	
	public void setConfiguraciones(List<Configuracion> configuraciones){
		cbConfig.removeAllItems();
		for(Configuracion conf:configuraciones){
			cbConfig.addItem(conf);
		}
	}
	
	public Aplicacion getSelectedAplicacion(){
		return (Aplicacion) cbAplicacion.getSelectedItem();
	}
	
	public Configuracion getSelectedConfig(){
		return (Configuracion) cbConfig.getSelectedItem();
	}
	
	public void addAplicacionListener(ItemListener lst){
		cbAplicacion.addItemListener(lst);
	}
	
	public void addConfiguracionListener(ItemListener lst){
		cbConfig.addItemListener(lst);
	}

	public void addProcesarListener(ActionListener lst) {
		btnProcesar.addActionListener(lst);
	}

}
