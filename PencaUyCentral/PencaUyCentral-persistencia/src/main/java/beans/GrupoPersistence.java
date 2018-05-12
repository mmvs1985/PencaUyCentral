package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.interfaces.GrupoPersistenceLocal;
import beans.interfaces.GrupoPersistenceRemote;

/**
 * Session Bean implementation class GrupoPersistence
 */
@Stateless
@LocalBean
public class GrupoPersistence implements GrupoPersistenceRemote, GrupoPersistenceLocal {

    /**
     * Default constructor. 
     */
    public GrupoPersistence() {
        // TODO Auto-generated constructor stub
    }

}
