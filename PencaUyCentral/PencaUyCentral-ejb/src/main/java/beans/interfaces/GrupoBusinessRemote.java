package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Grupo;

@Remote
public interface GrupoBusinessRemote {
	public boolean agregarGrupo(String nombre,int fase);
	public Grupo obtenerGrupo(int id);
	public int obtenerGrupoPorNombreYFase(String nombre,int id);
	public boolean eliminarGrupo(int id);
	public List<Grupo> obtenerGruposPorFase(int id);
}
