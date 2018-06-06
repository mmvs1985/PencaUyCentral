package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.TiposFuenteInformacion;

@Local
public interface TiposFuenteInformacionPersistenceLocal {
	public boolean agregarTipoFuenteInformacion(String nombre);
	public List<TiposFuenteInformacion> obtenerTiposFuenteInformacion();
	public TiposFuenteInformacion obtenerTipoFuenteInformacion(int id);
	public int obtenerTipoFuenteInformacionPorNombre(String nombre);
	public boolean eliminarTipoFuenteInformacion(int id);
}
