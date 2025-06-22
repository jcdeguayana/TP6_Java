package negocioImpl;

import entidad.Persona;
import negocio.PersonaNegocio;

import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDaoImpl pdao = new PersonaDaoImpl();

    @Override
    public boolean insert(Persona persona) {
		boolean estado = false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0) {
			
			estado = pdao.cargarPersona(persona);
		}
		
		return estado;
    }
    
    public ArrayList<Persona> leerTodos(){
    	
    	return pdao.leerTodos();
    	
    }
    
    public boolean actualizarPersona(Persona p) {
		boolean estado = false;
		if(p.getNombre().trim().length()>0 && p.getApellido().trim().length()>0 && p.getDni().trim().length()>0) {
			estado = pdao.modificarPersona(p);
		}
		return estado;
    }
    
    @Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni()!=null )//Tambi�n se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}
    
}

