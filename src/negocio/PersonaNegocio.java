package negocio;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public ArrayList<Persona> leerTodos();
	public boolean actualizarPersona(Persona p);
	
	
}
