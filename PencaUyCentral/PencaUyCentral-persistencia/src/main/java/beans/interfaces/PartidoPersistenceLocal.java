package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entidades.Equipo;
import entidades.Partido;

@Local
public interface PartidoPersistenceLocal {	
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha);
	public Partido obtenerPartido(int id);
	public boolean eliminarPartido(int id);
}
