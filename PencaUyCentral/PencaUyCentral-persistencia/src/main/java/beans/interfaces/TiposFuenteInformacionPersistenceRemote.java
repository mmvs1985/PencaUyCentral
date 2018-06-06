package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.TiposFuenteInformacion;

@Remote
public interface TiposFuenteInformacionPersistenceRemote {
	public boolean agregarTipoFuenteInformacion(String nombre);
	public List<TiposFuenteInformacion> obtenerTiposFuenteInformacion();
	public TiposFuenteInformacion obtenerTipoFuenteInformacion(int id);
	public int obtenerTipoFuenteInformacionPorNombre(String nombre);
	public boolean eliminarTipoFuenteInformacion(int id);
}
