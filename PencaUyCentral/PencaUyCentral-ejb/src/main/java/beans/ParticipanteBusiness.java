package beans;

import beans.interfaces.OrganizacionPersistenceRemote;
import beans.interfaces.ParticipanteBusinessLocal;
import beans.interfaces.ParticipanteBusinessRemote;
import beans.interfaces.ParticipantePersistenceRemote;
import entidades.Participante;
import entidades.Penca;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ParticipanteBusiness
 */
@Stateless
@LocalBean
public class ParticipanteBusiness implements ParticipanteBusinessRemote, ParticipanteBusinessLocal {

	@EJB ParticipantePersistenceRemote bean;
	
    /**
     * Default constructor. 
     */
    public ParticipanteBusiness() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarParticipante(String usuario, Penca p) {
    	return bean.agregarParticipante(usuario, p);
    }
    
    @Override
	public List<Participante> obtenerParticipantes() {
    	return bean.obtenerParticipantes();
    }
    
    @Override
	public Participante obtenerParticipantePorUsuario(String usuario) {
    	return bean.obtenerParticipantePorUsuario(usuario);
    }
    
    @Override
	public List<Participante> obtenerParticipantesPorPenca(int id){
    	return bean.obtenerParticipantesPorPenca(id);
    }
    
    @Override
	public Participante obtenerParticipante(int id) {
    	return bean.obtenerParticipante(id);
    }
    
    @Override
	public boolean eliminarParticipante(int id) {
    	return bean.eliminarParticipante(id);
    }

}
