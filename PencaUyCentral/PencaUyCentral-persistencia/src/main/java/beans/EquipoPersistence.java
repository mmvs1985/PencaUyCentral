package beans;

import beans.interfaces.EquipoPersistenceLocal;
import beans.interfaces.EquipoPersistenceRemote;
import entidades.Equipo;

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
	private static EntityManager em;

    /**
     * Default constructor. 
     */
    public EquipoPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarEquipo(String nombre) {
		Equipo e = (Equipo) em.createNamedQuery("Equipo.findByNombre", Equipo.class).setParameter("nombre", nombre).getSingleResult();
		if (e == null) {		
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
	public List<Equipo> obtenerEquipos(){
		return (List<Equipo>) em.createNamedQuery("Equipo.findAll", Equipo.class).getResultList();
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
