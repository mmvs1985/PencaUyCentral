package penca.uy;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beans.interfaces.SincronizacionRemote;


@ManagedBean(name="SincronizacionView")
public class SincronizacionView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@EJB SincronizacionRemote sicronizacionBean;


	@PostConstruct
    public void init() {
    }

	public void sync() {
		sicronizacionBean.sincronizar();
	}
}