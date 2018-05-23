package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entidades.Equipo;
import entidades.Partido;

@Remote
public interface PartidoBusinessRemote {
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha);
	public Partido obtenerPartido(int id);
	public boolean eliminarPartido(int id);
	public int obtenerPartidoPorGrupoEquipoLocalYEquipoVisitante(int idg, int idel, int idev);
	public List<Equipo> obtenerEquipoVisitantePartido(int idel, int idg);
}
