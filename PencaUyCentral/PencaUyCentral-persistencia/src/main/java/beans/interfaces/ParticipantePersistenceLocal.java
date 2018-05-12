package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Participante;
import entidades.Penca;

@Local
public interface ParticipantePersistenceLocal {
	
	boolean agregarParticipante(String usuario, Penca p);
	
	List<Participante> obtenerParticipantes();
	
	Participante obtenerParticipante(int id);
	
	boolean eliminarParticipante(int id);

}
