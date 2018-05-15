package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;

@Remote
public interface PencaPersistenceRemote {	
	public boolean agregarPenca(String nombre, Organizacion o);	
	public Penca obtenerPenca(int id);	
	public Penca obtenerPencaPorNombre(String nombre);
	public Penca obtenerPencaPorNombreYOrganizacion(int id, String nombre);
	public List<Penca> obtenerPencas();	
	public List<Penca> obtenerPencasPorOrganizacion(int id);
	public List<Participante> obtenerParticipantesPenca(int id);
	public boolean eliminarPenca(int id);
}
