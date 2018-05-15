package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Participante;
import entidades.Penca;

@Local
public interface ParticipantePersistenceLocal {	
	public boolean agregarParticipante(String usuario, Penca p);	
	public List<Participante> obtenerParticipantes();	
	public Participante obtenerParticipante(int id);	
	public boolean eliminarParticipante(int id);
}
