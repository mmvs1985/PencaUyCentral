package beans.interfaces;

import java.util.Date;

import javax.ejb.Local;

import entidades.Partido;

@Local
public interface PartidoBusinessLocal {
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha);
	public Partido obtenerPartido(int id);
	public boolean eliminarPartido(int id);
}
