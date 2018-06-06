package penca.uy;
 
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beans.interfaces.TiposFuenteInformacionPersistenceRemote;
import entidades.TiposFuenteInformacion;
 
@ManagedBean(name="TablaTiposFuenteInformacionView")
public class TablaTiposFuenteInformacionView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TiposFuenteInformacion> tiposfuenteinformacion;
     
    @EJB
    TiposFuenteInformacionPersistenceRemote tipofuenteinformacionBean;
 
    @PostConstruct
    public void init() {
        tiposfuenteinformacion = tipofuenteinformacionBean.obtenerTiposFuenteInformacion();
    }
     
    public List<TiposFuenteInformacion> getTiposFuenteInformacion() {
        return tiposfuenteinformacion;
    }
 
}

