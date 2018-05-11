package beans;

import beans.interfaces.OrganizacionPersistenceLocal;
import beans.interfaces.OrganizacionPersistenceRemote;
import controladores.OrganizacionController;
import entidades.Organizacion;
import entidades.Penca;

import java.io.Serializable;
import java.math.BigDecimal;
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
	
	/**
     * Default constructor. 
     */
    public OrganizacionPersistence() {
        // TODO Auto-generated constructor stub
    	
    }
    
	@Override
	public boolean agregarOrganizacion(String nombre) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().addOrganizacion(nombre);		
	}
	
	
	@Override
	public Organizacion obtenerOrganizacion(String nombre) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getOrganizacion(nombre);	
	}
	
	@Override
	public List<Penca> obtenerPencasOrganizacion(String nombre) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getPencasOrganizacion(nombre);	
	}	
	
	@Override
	public boolean agregarPencaEnOrganizacion(String nombre, Penca penca) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().addPencaEnOrganizacion(nombre, penca);	
	}
	
	@Override
	public boolean eliminarPencaEnOrganizacion(String nombre, Penca penca) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().removePencaEnOrganizacion(nombre, penca);	
	}
	
	@Override
	public boolean eliminarOrganizacion(String nombre) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().removeOrganizacion(nombre);	
	}
	
	
	
	
	
	
	
	

}
