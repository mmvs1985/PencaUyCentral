package beans;

import beans.interfaces.CentralPersistenceLocal;
import beans.interfaces.CentralPersistenceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class CentralPersistence
 */
@Singleton
@Startup
@LocalBean
public class CentralPersistence implements CentralPersistenceRemote, CentralPersistenceLocal {

    /**
     * Default constructor. 
     */
    public CentralPersistence() {
        // TODO Auto-generated constructor stub
    }

}
