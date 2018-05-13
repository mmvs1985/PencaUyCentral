package beans;

import beans.interfaces.TiposPremioPersistenceLocal;
import beans.interfaces.TiposPremioPersistenceRemote;
import entidades.TiposPremio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TiposPremioPersistence
 */
@Stateless
@LocalBean
public class TiposPremioPersistence implements TiposPremioPersistenceRemote, TiposPremioPersistenceLocal {
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private static EntityManager em;

    /**
     * Default constructor. 
     */
    public TiposPremioPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public boolean agregarTipoPremio(String nombre) {
		TiposPremio tp = (TiposPremio) em.createNamedQuery("TiposPremio.findByNombre", TiposPremio.class).setParameter("nombre", nombre).getSingleResult();
		if (tp == null) {	
			TiposPremio ntp = new TiposPremio();
			ntp.setNombre(nombre);
			em.persist(ntp);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public TiposPremio obtenerTipoPremio(int id) {
		return (TiposPremio) em.find(TiposPremio.class, id);
	}	
	
	@Override
	public List<TiposPremio> obtenerTiposPremio(){
		return (List<TiposPremio>) em.createNamedQuery("TiposPremio.findAll", TiposPremio.class).getResultList();
	}	
	
	@Override
	public boolean eliminarTipoPremio(int id) {
		TiposPremio tpe = em.find(TiposPremio.class, id);
		if (tpe != null) {				
			em.remove(tpe);
			return true;
		} else {
			return false;
		}	
	}


}
