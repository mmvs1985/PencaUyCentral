package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import entidades.Equipo;
import entidades.Partido;

@Remote
public interface PartidoPersistenceRemote {	
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha);
	public Partido obtenerPartido(int id);
	public boolean eliminarPartido(int id);
}
