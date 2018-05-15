package beans;

import beans.interfaces.PencaPersistenceLocal;
import beans.interfaces.PencaPersistenceRemote;
import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PencaPersistence
 */
@Stateless
@LocalBean
public class PencaPersistence implements PencaPersistenceRemote, PencaPersistenceLocal {
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PencaPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarPenca(Organizacion o) {
		Organizacion org = em.find(Organizacion.class, o.getId());
		if (org != null) {	
			Penca p = new Penca();
			p.setOrganizacion(o);
			em.persist(p);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Penca obtenerPenca(int id) {
		return (Penca) em.find(Penca.class, id);
	}	
	
	@Override
	public List<Penca> obtenerPencas(){
		return (List<Penca>) em.createNamedQuery("Penca.findAll", Penca.class).getResultList();
	}
	
	@Override
	public List<Participante> obtenerParticipantesPenca(int id){
		Penca p = em.find(Penca.class, id);
		if (p != null) {
			List<Participante> lp = (List<Participante>) em.createNamedQuery("Participante.findByPenca", Participante.class).setParameter("penca", p).getResultList();
			return lp;
		} else {
			return null;
		}	
	}
	
	@Override
	public boolean eliminarPenca(int id) {
		Penca po = em.find(Penca.class, id);
		if (po != null) {				
			em.remove(po);
			return true;
		} else {
			return false;
		}	
	}

}
