package penca.uy;
 
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beans.interfaces.TiposPremioBusinessRemote;
import entidades.TiposPremio;
 
@ManagedBean(name="TablaTiposPremioView")
//@ViewScoped
public class TablaTiposPremioView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TiposPremio> tipospremio;
     
    @EJB
    TiposPremioBusinessRemote tipopremioBean;
 
    @PostConstruct
    public void init() {
        tipospremio = tipopremioBean.obtenerTiposPremio();
    }
     
    public List<TiposPremio> getTiposPremio() {
        return tipospremio;
    }
 
}

