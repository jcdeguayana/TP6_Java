package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PanelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;

	private JList listPersonas;
	private JButton btnEliminar;

	public PanelEliminarPersona() {
		setLayout(null);

		// ScrollPane para que el JList sea visible si hay muchos elementos
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 300, 150); // 🔸 Aumentar tamaño
		add(scrollPane);

		listPersonas = new JList();
		scrollPane.setViewportView(listPersonas);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(150, 220, 100, 30);
		add(btnEliminar);
	}

	// 🔸 Getter y Setter para el JList
	public JList getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList listPersonas) {
		this.listPersonas = listPersonas;
	}

	// 🔸 Getter y Setter para el botón
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
}

