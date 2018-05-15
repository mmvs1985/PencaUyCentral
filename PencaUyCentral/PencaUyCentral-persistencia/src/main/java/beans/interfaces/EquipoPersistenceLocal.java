package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Equipo;

@Local
public interface EquipoPersistenceLocal {	
	public boolean agregarEquipo(String nombre);
	public Equipo obtenerEquipo(int id);	
	public Equipo obtenerEquipoPorNombre(String nombre);
	public List<Equipo> obtenerEquipos();
	public boolean eliminarEquipo(int id);
}
