package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Grupo;

@Local
public interface GrupoPersistenceLocal {
	
	public boolean crearGrupo(String nombre,int fase);
	public Grupo obtenerGrupo(int id);
	public Grupo obtenerGrupoPorNombreYFase(String nombre,int id);
	public boolean eliminarGrupo(int id);
	public List<Grupo> obtenerGruposPorFase(int id);
	

}
