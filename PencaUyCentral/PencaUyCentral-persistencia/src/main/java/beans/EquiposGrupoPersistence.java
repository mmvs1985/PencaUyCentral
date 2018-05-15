package beans;

import beans.interfaces.EquiposGrupoPersistenceLocal;
import beans.interfaces.EquiposGrupoPersistenceRemote;
import entidades.Equipo;
import entidades.EquiposGrupo;
import entidades.Grupo;

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
public class EquiposGrupoPersistence implements EquiposGrupoPersistenceRemote, EquiposGrupoPersistenceLocal {
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public EquiposGrupoPersistence() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarEquiposGrupo(int equipo,int grupo) {
		//List<Equipo> le = em.createNamedQuery("Equipo.findByNombre", Equipo.class).setParameter("nombre", nombre).getResultList();
    	if (em.createQuery("SELECT e FROM "+ EquiposGrupo.class.getSimpleName()+" e WHERE e.equipo = " + equipo +" and e.grupo = "+grupo).getResultList().isEmpty()) {	
			EquiposGrupo eg = new EquiposGrupo();
			
			eg.setEquipo(em.find(Equipo.class, equipo));
			eg.setGrupo(em.find(Grupo.class, grupo));
			eg.setGolenContra(0);
			eg.setGolesFavor(0);
			eg.setPartidosEmpatados(0);
			eg.setPartidosGanados(0);
			eg.setPartidosJugados(0);
			eg.setPartidosPerdidos(0);
			eg.setPosicion(0);
			eg.setPuntos(0);
			
			em.persist(eg);
			return true;
		} else {
			return false;
		}		
	}	
	

}
