package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnAgregar;

	public PanelAgregarPersonas() {
		setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(157, 177, 89, 23);
		add(btnAgregar);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(157, 45, 86, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(157, 87, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(157, 130, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(100, 48, 46, 14);
		add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 90, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(100, 133, 46, 14);
		add(lblApellido);
	}
	
	// Getters
	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	// Setters
	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
}

