package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.TiposPremio;

@Remote
public interface TiposPremioPersistenceRemote {
	
	boolean agregarTipoPremio(String nombre);

	List<TiposPremio> obtenerTiposPremio();

	TiposPremio obtenerTipoPremio(int id);

	boolean eliminarTipoPremio(int id);

}
