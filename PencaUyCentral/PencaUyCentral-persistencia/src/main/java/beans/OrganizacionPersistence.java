package beans;

import beans.interfaces.OrganizacionPersistenceLocal;
import beans.interfaces.OrganizacionPersistenceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrganizacionPersistence
 */
@Stateless
@LocalBean
public class OrganizacionPersistence implements OrganizacionPersistenceRemote, OrganizacionPersistenceLocal {

    /**
     * Default constructor. 
     */
    public OrganizacionPersistence() {
        // TODO Auto-generated constructor stub
    }

}
