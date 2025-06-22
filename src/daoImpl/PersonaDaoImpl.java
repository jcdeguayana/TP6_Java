package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {

	
	public static final String agregar= "INSERT INTO Personas (dni, nombre, apellido) VALUES (?,?,?)";
	private static final String borrar = "DELETE FROM Personas WHERE dni = ?";
	private static final String leerTodos = "SELECT * FROM Personas";
	private static final String modificar="UPDATE Personas SET nombre = ?, apellido = ? WHERE dni = ?";
	
	@Override
	public boolean cargarPersona(Persona p) {
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean isInsertExitoso = false;
			try
			{
				statement = conexion.prepareStatement(agregar);
				statement.setString(1, p.getDni());
				statement.setString(2, p.getNombre());
				statement.setString(3, p.getApellido());
				if(statement.executeUpdate() > 0)
				{
					conexion.commit();
					isInsertExitoso = true;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return isInsertExitoso;
		}
	
	public boolean delete(Persona persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(borrar);
			statement.setInt(1, Integer.parseInt(persona_a_eliminar.getDni()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	@Override
	public boolean modificarPersona(Persona p) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isModifyExitoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(modificar);
			statement.setString(1, p.getNombre());
			statement.setString(2, p.getApellido());
			statement.setString(3, p.getDni());
			if(statement.executeUpdate() > 0) 
			{
				conexion.commit();
				isModifyExitoso = true;
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			isModifyExitoso = false;
		}
		
		return isModifyExitoso;
	}
	
	public ArrayList<Persona> leerTodos(){
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(leerTodos);
			while(rs.next()) {
				Persona p = new Persona();
				p.setDni(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				personas.add(p);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return personas;
		
	}
	
		

}
	

