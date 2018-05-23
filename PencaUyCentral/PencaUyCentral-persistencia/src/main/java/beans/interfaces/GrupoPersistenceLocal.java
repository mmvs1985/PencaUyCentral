package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Grupo;
import entidades.Partido;

@Local
public interface GrupoPersistenceLocal {
	
	public boolean crearGrupo(String nombre,int fase);
	public Grupo obtenerGrupo(int id);
	public int obtenerGrupoPorNombreYFase(String nombre,int id);
	public boolean eliminarGrupo(int id);
	public List<Grupo> obtenerGruposPorFase(int id);
	public List<Partido> obtenerPartidosGrupo(int id);
}
