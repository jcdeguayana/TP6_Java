package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal  extends JFrame{

	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem mnAgregar;
	private JMenuItem mnModificar;
	private JMenuItem mnEliminar;
	private JMenuItem mnListar;
	
	public VentanaPrincipal() {
		setTitle("TP6-Grupo13");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
	    menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);
		
		mnAgregar = new JMenuItem("Agregar");
		mnPersonas.add(mnAgregar);
		
		mnModificar = new JMenuItem("Modificar");
		mnPersonas.add(mnModificar);
		
		mnEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(mnEliminar);
		
		mnListar = new JMenuItem("Listar");
		mnPersonas.add(mnListar);
	}

	public JMenu getMnPersonas() {
		return mnPersonas;
	}

	public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}

	public JMenuItem getMnAgregar() {
		return mnAgregar;
	}

	public void setMnAgregar(JMenuItem mnAgregar) {
		this.mnAgregar = mnAgregar;
	}

	public JMenuItem getMnModificar() {
		return mnModificar;
	}

	public void setMnModificar(JMenuItem mnModificar) {
		this.mnModificar = mnModificar;
	}

	public JMenuItem getMnEliminar() {
		return mnEliminar;
	}

	public void setMnEliminar(JMenuItem mnEliminar) {
		this.mnEliminar = mnEliminar;
	}

	public JMenuItem getMnListar() {
		return mnListar;
	}

	public void setMnListar(JMenuItem mnListar) {
		this.mnListar = mnListar;
	}
	
	
		
		
		
		
	
	
	
}
