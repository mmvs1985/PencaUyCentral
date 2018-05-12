package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;

@Local
public interface PencaPersistenceLocal {
	
boolean agregarPenca(Organizacion o);
	
	Penca obtenerPenca(int id);
	
	List<Penca> obtenerPencas();
	
	List<Participante> obtenerParticipantesPenca(int id);

	boolean eliminarPenca(int id);

}
