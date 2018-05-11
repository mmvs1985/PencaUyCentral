package beans;

import beans.interfaces.TorneoPersistenceLocal;
import beans.interfaces.TorneoPersistenceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TorneoPersistence
 */
@Stateless
@LocalBean
public class TorneoPersistence implements TorneoPersistenceRemote, TorneoPersistenceLocal {

    /**
     * Default constructor. 
     */
    public TorneoPersistence() {
        // TODO Auto-generated constructor stub
    }

}
