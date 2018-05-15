package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;

@Local
public interface PencaPersistenceLocal {	
	public boolean agregarPenca(Organizacion o);	
	public Penca obtenerPenca(int id);	
	public List<Penca> obtenerPencas();	
	public List<Participante> obtenerParticipantesPenca(int id);
	public boolean eliminarPenca(int id);

}
