package presentacion.controlador;

import java.awt.event.ActionEvent;
//Importar si no está
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelEliminarPersona;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PersonaNegocio personaNegocio;
	private PanelEliminarPersona pnlEliminarPersona;


	public Controlador(VentanaPrincipal ventanaPrincipal, PersonaNegocio personaNegocio) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.personaNegocio = personaNegocio;

		this.pnlAgregarPersonas = new PanelAgregarPersonas();
		agregarRestriccionesCampos(); 
		this.ventanaPrincipal.getMnAgregar().addActionListener(e -> mostrarPanelAgregar());
		this.pnlAgregarPersonas.getBtnAgregar().addActionListener(e -> agregarPersona());
		
		this.pnlModificarPersonas = new PanelModificarPersonas();
		this.ventanaPrincipal.getMnModificar().addActionListener(e -> mostrarPanelModificar());
		
		this.pnlModificarPersonas.getListPersonas().addListSelectionListener(e -> elementoSeleccionado(e));
		this.pnlModificarPersonas.getBtnModificar().addActionListener(a -> modificarLosElementos());
		
		this.pnlEliminarPersona = new PanelEliminarPersona();
		this.ventanaPrincipal.getMnEliminar().addActionListener(e -> mostrarPanelEliminar());
		// Dentro del constructor o método inicializador del controlador
		pnlEliminarPersona.getBtnEliminar().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        EventoClickBoton_BorrarPersona_DesdeLista(e);
		    }
		});

	
	}
	
	public void EventoClickBoton_BorrarPersona_DesdeLista(ActionEvent e) {
	    // Obtener la persona seleccionada en el JList
	    Persona personaSeleccionada = (Persona) this.pnlEliminarPersona.getListPersonas().getSelectedValue();

	    if (personaSeleccionada != null) {
	        // Confirmación
	        int confirmacion = JOptionPane.showConfirmDialog(null,
	            "¿Estás seguro que deseas eliminar a " + personaSeleccionada + "?",
	            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

	        if (confirmacion == JOptionPane.YES_OPTION) {
	            // Llamar al método delete del negocio
	            boolean estado = personaNegocio.delete(personaSeleccionada);
	            String mensaje;

	            if (estado) {
	                mensaje = "Persona eliminada con éxito.";

	                // Eliminar del modelo del JList
	                DefaultListModel<Persona> modelo = (DefaultListModel<Persona>) pnlEliminarPersona.getListPersonas().getModel();
	                modelo.removeElement(personaSeleccionada);
	            } else {
	                mensaje = "No se pudo eliminar. ¿DNI inexistente?";
	            }

	            // Mostrar el resultado
	            JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar una persona de la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	}



	private void modificarLosElementos() {
		String dni = pnlModificarPersonas.getTxtDni().getText().trim();
		String nombre = pnlModificarPersonas.getTxtNombre().getText().trim();
		String apellido = pnlModificarPersonas.getTxtApellido().getText().trim();
		try {
			Persona persona = new Persona(dni, nombre, apellido);
			boolean modificado = personaNegocio.actualizarPersona(persona);

			if (modificado) {
				JOptionPane.showMessageDialog(null, "Persona modificada con éxito.");
				pnlModificarPersonas.getTxtDni().setText("");
				pnlModificarPersonas.getTxtApellido().setText("");
				pnlModificarPersonas.getTxtNombre().setText("");
				cargarListaPersonas();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo modificar la persona");
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	

	private void mostrarPanelModificar() {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		this.ventanaPrincipal.getContentPane().revalidate();
		this.ventanaPrincipal.getContentPane().repaint();
		cargarListaPersonas();

	}
	
	
	private void mostrarPanelAgregar() {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		this.ventanaPrincipal.getContentPane().revalidate();
		this.ventanaPrincipal.getContentPane().repaint();
	}
	
	private void mostrarPanelEliminar() {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		this.ventanaPrincipal.getContentPane().revalidate();
		this.ventanaPrincipal.getContentPane().repaint();
		cargarListaPersonasEnEliminar();
	}


	private void agregarPersona() {
		String dni = pnlAgregarPersonas.getTxtDNI().getText().trim();
		String nombre = pnlAgregarPersonas.getTxtNombre().getText().trim();
		String apellido = pnlAgregarPersonas.getTxtApellido().getText().trim();

		if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			Persona persona = new Persona(dni, nombre, apellido);
			boolean insertado = personaNegocio.insert(persona);

			if (insertado) {
				JOptionPane.showMessageDialog(null, "Persona agregada con éxito.");
				/*pnlAgregarPersonas.limpiarCampos();*/
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar la persona. Verifique los datos.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El DNI debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void agregarRestriccionesCampos() {
		// Nombre: solo letras y espacios
		pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume();
		        }
		    }
		});

		// Apellido: solo letras y espacios
		pnlAgregarPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume();
		        }
		    }
		});

		// DNI: solo números
		pnlAgregarPersonas.getTxtDNI().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
	}

	
	private void cargarListaPersonas() {
		ArrayList<Persona> personas = personaNegocio.leerTodos();
	    DefaultListModel<Persona> modelo = new DefaultListModel<Persona>();

	    for (Persona persona : personas) {
	        modelo.addElement(persona);
	    }

	    pnlModificarPersonas.getListPersonas().setModel(modelo);
	}
	
	private void cargarListaPersonasEnEliminar() {
		ArrayList<Persona> personas = personaNegocio.leerTodos();
		DefaultListModel<Persona> modelo = new DefaultListModel<Persona>();

		for (Persona persona : personas) {
		    modelo.addElement(persona);
		}

		pnlEliminarPersona.getListPersonas().setModel(modelo);
	}

	
	private void elementoSeleccionado(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) {
	            Persona seleccionada = pnlModificarPersonas.getListPersonas().getSelectedValue();
	            if (seleccionada != null) {
	                pnlModificarPersonas.getTxtDni().setText(seleccionada.getDni());
	                pnlModificarPersonas.getTxtNombre().setText(seleccionada.getNombre());
	                pnlModificarPersonas.getTxtApellido().setText(seleccionada.getApellido());
	            }
	        }
	    };
	    
	    //por las dudas, el metodo getValueIsAdjusting detecta cuando un elemento en la lista esta siendo seleccionado (solo reconoce el momento en el que el click
	    //se para en el objeto especifico de la lista y ya deja de realizar cambios, una seleccion fija)
	    
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}

