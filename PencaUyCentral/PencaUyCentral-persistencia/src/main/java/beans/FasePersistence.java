package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.interfaces.FasePersistenceLocal;
import beans.interfaces.FasePersistenceRemote;
import entidades.Fase;
import entidades.Torneo;

/**
 * Session Bean implementation class FasePersistence
 */
@Stateless
@LocalBean
public class FasePersistence implements FasePersistenceRemote, FasePersistenceLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FasePersistence() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean crearFase(String nombre,int torneoId) {
    	
    	Fase fase = new Fase(nombre);
    	Torneo t = em.find(Torneo.class, torneoId);
    	
    	fase.setTorneo(t);
    	t.addFase(fase);
    	em.persist(fase);
    	return true;
    }    
    
    public Fase obtenerFase(int id) {
    	
    	return em.find(Fase.class, id);    	
    }    
    
    public boolean eliminarFase(int id) {
    	
    	Fase f = em.find(Fase.class, id);
    	em.remove(f);
    	return true;
    }

}
