package beans;

import beans.interfaces.ParticipantePersistenceLocal;
import beans.interfaces.ParticipantePersistenceRemote;
import entidades.Participante;
import entidades.Penca;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ParticipantePersistence
 */
@Stateless
@LocalBean
public class ParticipantePersistence implements ParticipantePersistenceRemote, ParticipantePersistenceLocal {
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private static EntityManager em;

    /**
     * Default constructor. 
     */
    public ParticipantePersistence() {
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public boolean agregarParticipante(String usuario, Penca p) {
		Penca pe = em.find(Penca.class, p.getId());
		if (pe != null) {	
			Participante pa = new Participante();
			pa.setUsuario(usuario);
			pa.setPuntos(0);
			pa.setPenca(p);
			em.persist(pa);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Participante obtenerParticipante(int id) {
		return (Participante) em.find(Participante.class, id);
	}	
	
	@Override
	public List<Participante> obtenerParticipantes(){
		return (List<Participante>) em.createNamedQuery("Participante.findAll", Participante.class).getResultList();
	}	
	
	@Override
	public boolean eliminarParticipante(int id) {
		Participante pa = em.find(Participante.class, id);
		if (pa != null) {				
			em.remove(pa);
			return true;
		} else {
			return false;
		}	
	}	

    

}
