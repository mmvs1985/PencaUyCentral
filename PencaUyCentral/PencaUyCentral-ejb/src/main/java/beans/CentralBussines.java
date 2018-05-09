package beans;

import beans.interfaces.CentralBussinesLocal;
import beans.interfaces.CentralBussinesRemote;
import beans.interfaces.CentralPersistenceLocal;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CentralBussines
 */
@Stateless
@LocalBean
public class CentralBussines implements CentralBussinesRemote, CentralBussinesLocal {

    /**
     * Default constructor. 
     */
	
	@EJB CentralPersistenceLocal bean;
	
    public CentralBussines() {
        // TODO Auto-generated constructor stub
    }

}
