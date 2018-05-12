package beans;

import beans.interfaces.TorneoPersistenceLocal;
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Fase;
import entidades.Torneo;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TorneoPersistence
 */
@Stateless
@LocalBean
public class TorneoPersistence implements TorneoPersistenceRemote, TorneoPersistenceLocal {

	@PersistenceContext
	private EntityManager em;
	
	/*@EJB 
	Fase fase;*/
	
    /**
     * Default constructor. 
     */
    public TorneoPersistence() {    
    	
        // TODO Auto-generated constructor stub
    }
    
    public boolean crearTorneo(String nombre, String tipo, Date comienzo) {
    	
    	Torneo torneo = new Torneo(nombre, tipo, comienzo);
    	em.persist(torneo);
    	return true;
    }
    
    
    public Torneo obtenerTorneo(int id) {
    	Torneo t = em.find(Torneo.class, id);
    	return t;
    	
    }
    
    
    public boolean eliminarTorneo(int id) {
    	
    	Torneo t = em.find(Torneo.class, id);
    	em.remove(t);
    	return true;
    }
    
    
    /*public boolean agregarFase(int id) {
    	Fase fase = em.find(Fase.class, id);
    	Torneo t = em.find(Torneo.class, fase.getTorneo().getId());
    	t.addFase(fase);
    	return true;    	
    	
    }
    */
    

}
