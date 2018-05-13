package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;

@Remote
public interface PencaPersistenceRemote {
	
boolean agregarPenca(Organizacion o);
	
	Penca obtenerPenca(int id);
	
	List<Penca> obtenerPencas();
	
	List<Participante> obtenerParticipantesPenca(int id);

	boolean eliminarPenca(int id);

}
