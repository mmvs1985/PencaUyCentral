package beans;

import java.util.ArrayList;
import java.util.List;

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
    @SuppressWarnings("unchecked")
    public List<Fase> obtenerFasesPorTorneo(int id){
    	List<Fase> list= new ArrayList();
    	list =(List<Fase>)em.createQuery( "Select d from "+ Fase.class.getSimpleName()+" d where d.torneo = "+id ).getResultList();
    	return list;
    }
    
    @SuppressWarnings("unchecked")
    public Fase obtenerFasePorNombreYTorneo(int id,String nombre){
    	List<Fase> list =(List<Fase>)em.createQuery( "Select d from "+ Fase.class.getSimpleName()+" d where d.torneo = "+id+" and d.nombre ='" + nombre +"'").getResultList();
    	if (!(list.isEmpty())) {
    		return list.get(0);
    	}else return null;
    }

}
