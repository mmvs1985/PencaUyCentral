package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Participante;
import entidades.Penca;

@Remote
public interface ParticipantePersistenceRemote {
	
boolean agregarParticipante(String usuario, Penca p);
	
	List<Participante> obtenerParticipantes();
	
	Participante obtenerParticipante(int id);
	
	boolean eliminarParticipante(int id);

}
