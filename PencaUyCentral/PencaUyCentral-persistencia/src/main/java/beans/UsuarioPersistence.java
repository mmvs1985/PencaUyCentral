package beans;

import beans.interfaces.UsuarioPersistenceLocal;
import beans.interfaces.UsuarioPersistenceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UsuarioPersistence
 */
@Stateless
@LocalBean
public class UsuarioPersistence implements UsuarioPersistenceRemote, UsuarioPersistenceLocal {

    /**
     * Default constructor. 
     */
    public UsuarioPersistence() {
        // TODO Auto-generated constructor stub
    }

}
