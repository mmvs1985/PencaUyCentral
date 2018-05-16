package beans;

import beans.interfaces.EquipoPersistenceLocal;
import beans.interfaces.EquipoPersistenceRemote;
import entidades.Equipo;
import entidades.Grupo;
import entidades.Organizacion;
import entidades.Torneo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EquipoPersistence
 */
@Stateless
@LocalBean
public class EquipoPersistence implements EquipoPersistenceRemote, EquipoPersistenceLocal {
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public EquipoPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarEquipo(String nombre) {
		//List<Equipo> le = em.createNamedQuery("Equipo.findByNombre", Equipo.class).setParameter("nombre", nombre).getResultList();
    	if (em.createQuery("SELECT e FROM "+ Equipo.class.getSimpleName()+" e WHERE e.nombre = '" + nombre +"'").getResultList().isEmpty()) {	
			Equipo ne = new Equipo();
			ne.setNombre(nombre);		
			em.persist(ne);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Equipo obtenerEquipo(int id) {
		return (Equipo) em.find(Equipo.class, id);
	}	
	
	@Override
	public Equipo obtenerEquipoPorNombre(String nombre) {
		List<Equipo> le = em.createNamedQuery("Equipo.findByNombre", Equipo.class).setParameter("nombre", nombre).getResultList();
		if (le.isEmpty()) {
			return null;
		}
		else {
			return le.get(0);
		}
	}		
	
	@Override
	//@SuppressWarnings("unchecked")
	public List<Equipo> obtenerEquipos(){
		return (List<Equipo>) em.createNamedQuery("Equipo.findAll", Equipo.class).getResultList();
		/*List<Equipo> le = em.createQuery( "SELECT e FROM "+ Equipo.class.getSimpleName()+" e").getResultList();
    	return le;*/
	}
	

	
	@Override
	public boolean eliminarEquipo(int id) {
		Equipo e = em.find(Equipo.class, id);
		if (e != null) {				
			em.remove(e);
			return true;
		} else {
			return false;
		}	
	}


}
