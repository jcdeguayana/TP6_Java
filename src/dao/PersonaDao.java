package dao;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaDao {
	public boolean cargarPersona(Persona p);
	public boolean modificarPersona(Persona p);
	public boolean delete(Persona persona_a_eliminar);
	public ArrayList<Persona> leerTodos();
}
