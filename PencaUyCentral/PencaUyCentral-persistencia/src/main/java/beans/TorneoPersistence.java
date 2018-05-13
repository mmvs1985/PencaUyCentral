package beans;

import entidades.Fase;
import entidades.Organizacion;
import entidades.Torneo;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import beans.interfaces.TorneoPersistenceLocal;
import beans.interfaces.TorneoPersistenceRemote;
import controladores.OrganizacionController;
import controladores.TorneoController;

/**
 * Session Bean implementation class TorneoPersistence
 */
@Stateless

public class TorneoPersistence implements TorneoPersistenceRemote, TorneoPersistenceLocal {

		

		@PersistenceContext(unitName = "PencaUyCentral-persistencia")
		private EntityManager em;
	
		/*@EJB 
		Fase fase;*/
		
	    /**
	     * Default constructor. 
	     */
	    public TorneoPersistence() {    
	    	
	        // TODO Auto-generated constructor stub
	    }
	    @Override
	    public boolean crearTorneo(Torneo t) {
	    	em.persist(t);
	    	return true;
	    }
	    
	    @Override
	    public Torneo obtenerTorneo(int id) {
	    	Torneo t = em.find(Torneo.class, id);
	    	return t;
	    	
	    }
	    
	    @Override
	    public boolean eliminarTorneo(Torneo t) {    	
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
