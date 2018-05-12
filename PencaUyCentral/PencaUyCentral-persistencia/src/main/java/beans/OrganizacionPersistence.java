package beans;

import beans.interfaces.OrganizacionPersistenceLocal;
import beans.interfaces.OrganizacionPersistenceRemote;
import controladores.OrganizacionController;
import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;
import entidades.TiposPremio;
import entidades.Torneo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class OrganizacionPersistence
 */
@Stateless
@LocalBean
public class OrganizacionPersistence implements OrganizacionPersistenceRemote, OrganizacionPersistenceLocal, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PencaUyCentral-persistencia")
	private static EntityManager em;
	
	/**
     * Default constructor. 
     */
    public OrganizacionPersistence() {
        // TODO Auto-generated constructor stub    	
    }     	
    
	@Override
	public boolean agregarOrganizacion(String nombre) {
		Organizacion o = obtenerOrganizacionPorNombre(nombre);
		if (o == null) {		
			Organizacion no = new Organizacion();
			no.setNombre(nombre);
			em.persist(no);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Organizacion obtenerOrganizacion(int id) {
		return (Organizacion) em.find(Organizacion.class, id);
	}	
	
	@Override
	public List<Organizacion> obtenerOrganizaciones(){
		return (List<Organizacion>) em.createNamedQuery("Organizacion.findAll", Organizacion.class).getResultList();
	}
	
	public Organizacion obtenerOrganizacionPorNombre(String nombre) {
		return (Organizacion) em.createNamedQuery("Organizacion.findByNombre", Organizacion.class).setParameter("nombre", nombre).getSingleResult();
	}	
	
	@Override
	public List<Penca> obtenerPencasOrganizacion(int id) {
		Organizacion o = obtenerOrganizacion(id);
		if (o != null) {
			List<Penca> lp = (List<Penca>) em.createNamedQuery("Penca.findByOrganizacion", Penca.class).setParameter("organizacion", o).getResultList();
			return lp;
		} else {
			return null;
		}	
	}	
	
	/*@Override
	public boolean agregarPencaEnOrganizacion(int id, Penca penca) {
		Organizacion o = obtenerOrganizacion(id);
		if (o != null) {
			em.getTransaction().begin();
			penca.setOrganizacion(o);			
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}		
	}
	
	@Override
	public boolean eliminarPencaEnOrganizacion(int id, Penca penca) {
		Organizacion o = obtenerOrganizacion(id);
		if (o != null) {	
			em.getTransaction().begin();
			penca.setOrganizacion(null);			
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}	
	}*/
	
	@Override
	public boolean eliminarOrganizacion(int id) {
		Organizacion o = obtenerOrganizacion(id);
		if (o != null) {				
			em.remove(o);
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public boolean agregarPenca(Organizacion o) {
		Organizacion org = obtenerOrganizacion(o.getId());
		if (org != null) {	
			Penca p = new Penca();
			p.setOrganizacion(o);
			em.persist(p);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Penca obtenerPenca(int id) {
		return (Penca) em.find(Penca.class, id);
	}	
	
	@Override
	public List<Penca> obtenerPencas(){
		return (List<Penca>) em.createNamedQuery("Penca.findAll", Penca.class).getResultList();
	}
	
	@Override
	public List<Participante> obtenerParticipantesPenca(int id){
		Penca p = em.find(Penca.class, id);
		if (p != null) {
			List<Participante> lp = (List<Participante>) em.createNamedQuery("Participante.findByPenca", Participante.class).setParameter("penca", p).getResultList();
			return lp;
		} else {
			return null;
		}	
	}
	
	@Override
	public boolean eliminarPenca(Penca p) {
		Penca po = em.find(Penca.class, p.getId());
		if (po != null) {				
			em.remove(po);
			return true;
		} else {
			return false;
		}	
	}
	
	@Override
	public boolean agregarParticipante(String usuario, Penca p) {
		Penca pe = em.find(Penca.class, p.getId());
		if (pe != null) {	
			Participante pa = new Participante();
			pa.setUsuario(usuario);
			pa.setPuntos(0);
			pa.setPenca(p);
			em.persist(pa);
			return true;
		} else {
			return false;
		}		
	}	
	
	@Override
	public Participante obtenerParticipante(int id) {
		return (Participante) em.find(Participante.class, id);
	}	
	
	@Override
	public List<Participante> obtenerParticipantes(){
		return (List<Participante>) em.createNamedQuery("Participante.findAll", Participante.class).getResultList();
	}	
	
	@Override
	public boolean eliminarParticipante(Participante p) {
		Participante pa = em.find(Participante.class, p.getId());
		if (pa != null) {				
			em.remove(pa);
			return true;
		} else {
			return false;
		}	
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
	public boolean eliminarTipoPremio(TiposPremio tp) {
		TiposPremio tpe = em.find(TiposPremio.class, tp.getId());
		if (tpe != null) {				
			em.remove(tp);
			return true;
		} else {
			return false;
		}	
	}

}
