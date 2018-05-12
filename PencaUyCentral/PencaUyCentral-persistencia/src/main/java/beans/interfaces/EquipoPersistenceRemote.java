package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Equipo;

@Remote
public interface EquipoPersistenceRemote {
	
	boolean agregarEquipo(String nombre);

	Equipo obtenerEquipo(int id);
	
	List<Equipo> obtenerEquipos();

	boolean eliminarEquipo(int id);

}
