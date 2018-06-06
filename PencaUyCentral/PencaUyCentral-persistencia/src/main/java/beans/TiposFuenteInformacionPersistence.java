package beans;

import beans.interfaces.TiposFuenteInformacionPersistenceLocal;
import beans.interfaces.TiposFuenteInformacionPersistenceRemote;
import entidades.TiposFuenteInformacion;
import entidades.TiposPremio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TiposFuenteInformacion
 */
@Stateless
@LocalBean
public class TiposFuenteInformacionPersistence implements TiposFuenteInformacionPersistenceRemote, TiposFuenteInformacionPersistenceLocal {

	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TiposFuenteInformacionPersistence() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean agregarTipoFuenteInformacion(String nombre) {
		int idtfi = obtenerTipoFuenteInformacionPorNombre(nombre);
		if (idtfi == -1) {	
			TiposFuenteInformacion ntfi = new TiposFuenteInformacion();
			ntfi.setNombre(nombre);
			em.persist(ntfi);
			return true;
		} else {
			return false;
		}		
	}

	@Override
	public List<TiposFuenteInformacion> obtenerTiposFuenteInformacion() {
		return (List<TiposFuenteInformacion>) em.createNamedQuery("TiposFuenteInformacion.findAll", TiposFuenteInformacion.class).getResultList();
	}

	@Override
	public TiposFuenteInformacion obtenerTipoFuenteInformacion(int id) {
		return (TiposFuenteInformacion) em.find(TiposFuenteInformacion.class, id);
	}

	@Override
	public int obtenerTipoFuenteInformacionPorNombre(String nombre) {
		List<TiposFuenteInformacion> ltfi = em.createNamedQuery("TiposFuenteInformacion.findByNombre", TiposFuenteInformacion.class).setParameter("nombre", nombre).getResultList();
		if (ltfi.isEmpty()){
			return -1;
		}
		else {
			return ltfi.get(0).getId();
		}
	}

	@Override
	public boolean eliminarTipoFuenteInformacion(int id) {
		TiposFuenteInformacion tfie = em.find(TiposFuenteInformacion.class, id);
		if (tfie != null) {				
			em.remove(tfie);
			return true;
		} else {
			return false;
		}	
	}

}
