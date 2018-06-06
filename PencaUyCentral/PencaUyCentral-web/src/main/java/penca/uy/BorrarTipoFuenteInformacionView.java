package penca.uy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.interfaces.TiposFuenteInformacionPersistenceRemote;
import entidades.TiposFuenteInformacion;

@ManagedBean(name="BorrarTipoFuenteInformacionView")
@ViewScoped
public class BorrarTipoFuenteInformacionView implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tipofuenteinfo;
	private List<String> tiposfuenteinfo;

	@EJB
	TiposFuenteInformacionPersistenceRemote tipofuenteinformacionBean;

	@PostConstruct
	public void init() {
		List<TiposFuenteInformacion> lista = tipofuenteinformacionBean.obtenerTiposFuenteInformacion();
		int i = lista.size();
		tiposfuenteinfo = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			tiposfuenteinfo.add(lista.get(j).getNombre());
		}
	}
	
	public String getTipoFuenteInformacion() {
		return tipofuenteinfo;
	}


	public void setTipoFuenteInformacion(String tipofuenteinfo) {
		this.tipofuenteinfo = tipofuenteinfo;
	}


	public List<String> getTiposFuenteInformacion() {
		return tiposfuenteinfo;
	}


	public void setTiposFuenteInformacion(List<String> tiposdefuente) {
		this.tiposfuenteinfo = tiposdefuente;
	}

	public void borrar() {
		FacesMessage msg;
		if (tipofuenteinfo != null) {
			int idtfi = tipofuenteinformacionBean.obtenerTipoFuenteInformacionPorNombre(tipofuenteinfo);
			tipofuenteinformacionBean.eliminarTipoFuenteInformacion(idtfi);			
			msg = new FacesMessage("Se borró el tipo de fuente de información " + tipofuenteinfo);			
		} else {
			System.out.println("el tipo de premio es null");
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "El tipo de fuente de información no es válido.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}


