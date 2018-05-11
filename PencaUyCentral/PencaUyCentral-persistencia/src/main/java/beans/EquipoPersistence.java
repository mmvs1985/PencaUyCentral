package beans;

import beans.interfaces.EquipoPersistenceLocal;
import beans.interfaces.EquipoPersistenceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EquipoPersistence
 */
@Stateless
@LocalBean
public class EquipoPersistence implements EquipoPersistenceRemote, EquipoPersistenceLocal {

    /**
     * Default constructor. 
     */
    public EquipoPersistence() {
        // TODO Auto-generated constructor stub
    }

}
