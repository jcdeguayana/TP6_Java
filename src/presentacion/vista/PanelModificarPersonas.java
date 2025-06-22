package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelModificarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<Persona> dlModel;
	private JList<Persona> listPersonas;
	private JLabel lblModificar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;

	public PanelModificarPersonas() {
		setLayout(null);
		
		listPersonas = new JList<Persona>();
		listPersonas.setBounds(33, 56, 372, 145);
		add(listPersonas);
		
		lblModificar = new JLabel("Seleccione la persona que desea modificar");
		lblModificar.setBounds(33, 38, 372, 14);
		add(lblModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(33, 212, 89, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(132, 212, 89, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(231, 212, 89, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(330, 212, 83, 23);
		add(btnModificar);
	}

	
	//Getters
	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public JLabel getLblModificar() {
		return lblModificar;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}
	
	public DefaultListModel getModelPersonas() {
		return dlModel;
	}


	//Setters
	
	public void setModelPersonas(DefaultListModel dlModel) {
		this.dlModel = dlModel;
	}
	
	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public void setLblModificar(JLabel lblModificar) {
		this.lblModificar = lblModificar;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	

	
	
	
}
