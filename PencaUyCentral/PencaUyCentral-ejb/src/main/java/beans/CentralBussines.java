package beans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.interfaces.CentralBussinesLocal;
import beans.interfaces.CentralBussinesRemote;

/**
 * Session Bean implementation class CentralBussines
 */
@Stateless
@LocalBean
public class CentralBussines implements CentralBussinesRemote, CentralBussinesLocal {

    /**
     * Default constructor. 
     */
	
//	@EJB TorneoPersistence beanTorneo;
	@EJB OrganizacionPersistence beanOrganizacion;
	@EJB EquipoPersistence beanEquipo;
	@EJB UsuarioPersistence beanUsuario;
	
    public CentralBussines() {
        // TODO Auto-generated constructor stub
    }

}
