package controladores.interfaces;

import java.util.List;

import entidades.TiposPremio;

public interface ITiposPremioPersistenceController {
	public boolean agregarTipoPremio(String nombre);
	public List<TiposPremio> obtenerTiposPremio();
	public TiposPremio obtenerTipoPremio(int id);
	public TiposPremio obtenerTipoPremioPorNombre(String nombre);
	public boolean eliminarTipoPremio(int id);
}
