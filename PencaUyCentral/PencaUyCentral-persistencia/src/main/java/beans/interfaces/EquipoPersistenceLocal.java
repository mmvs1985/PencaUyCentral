package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Equipo;

@Local
public interface EquipoPersistenceLocal {
	
	boolean agregarEquipo(String nombre);

	Equipo obtenerEquipo(int id);
	
	List<Equipo> obtenerEquipos();

	boolean eliminarEquipo(int id);
}
