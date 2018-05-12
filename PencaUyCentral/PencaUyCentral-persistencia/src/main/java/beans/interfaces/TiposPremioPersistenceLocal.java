package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.TiposPremio;

@Local
public interface TiposPremioPersistenceLocal {
	
	boolean agregarTipoPremio(String nombre);

	List<TiposPremio> obtenerTiposPremio();

	TiposPremio obtenerTipoPremio(int id);

	boolean eliminarTipoPremio(int id);

}
