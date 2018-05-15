package beans;

import beans.interfaces.TiposPremioPersistenceLocal;
import beans.interfaces.TiposPremioPersistenceRemote;
import entidades.Equipo;
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
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public TiposPremioPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public boolean agregarTipoPremio(String nombre) {
		TiposPremio tp = obtenerTipoPremioPorNombre(nombre);
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
	public TiposPremio obtenerTipoPremioPorNombre(String nombre) {
		List<TiposPremio> ltp = em.createNamedQuery("TiposPremio.findByNombre", TiposPremio.class).setParameter("nombre", nombre).getResultList();
		if (ltp.isEmpty()){
			return null;
		}
		else {
			return ltp.get(0);
		}
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
