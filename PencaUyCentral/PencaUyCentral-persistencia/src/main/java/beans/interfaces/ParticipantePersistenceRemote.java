package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Participante;
import entidades.Penca;

@Remote
public interface ParticipantePersistenceRemote {	
	public boolean agregarParticipante(String usuario, Penca p);	
	public List<Participante> obtenerParticipantes();	
	public Participante obtenerParticipantePorUsuario(String usuario);
	public List<Participante> obtenerParticipantesPorPenca(int id);
	public Participante obtenerParticipante(int id);	
	public boolean eliminarParticipante(int id);
}
