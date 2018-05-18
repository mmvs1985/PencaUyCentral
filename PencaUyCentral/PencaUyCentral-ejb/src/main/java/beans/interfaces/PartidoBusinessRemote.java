package beans.interfaces;

import java.util.Date;

import javax.ejb.Remote;

import entidades.Partido;

@Remote
public interface PartidoBusinessRemote {
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha);
	public Partido obtenerPartido(int id);
	public boolean eliminarPartido(int id);
}
