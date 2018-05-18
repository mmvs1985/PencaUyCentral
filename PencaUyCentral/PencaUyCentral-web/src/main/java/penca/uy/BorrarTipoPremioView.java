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

import beans.interfaces.TiposPremioBusinessRemote;
import entidades.TiposPremio;

@ManagedBean(name="BorrarTipoPremioView")
@ViewScoped
public class BorrarTipoPremioView implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tipopremio;
	private List<String> tipospremio;

	@EJB
	TiposPremioBusinessRemote tipopremioBean;

	@PostConstruct
	public void init() {
		List<TiposPremio> lista = tipopremioBean.obtenerTiposPremio();
		int i = lista.size();
		tipospremio = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			tipospremio.add(lista.get(j).getNombre());
		}
	}

	public List<String> getTiposPremio() {
		return tipospremio;
	}

	public void setTiposPremio(List<String> tipospremio) {
		this.tipospremio = tipospremio;
	}

	public String getTipoPremio() {
		return tipopremio;
	}

	public void setTipoPremio(String tipopremio) {
		this.tipopremio = tipopremio;
	}

	public void borrar() {
		FacesMessage msg;
		if (tipopremio != null) {
			System.out.println("el tipo de premio no es null, es " + tipopremio);
			TiposPremio tp = tipopremioBean.obtenerTipoPremioPorNombre(tipopremio);
			tipopremioBean.eliminarTipoPremio(tp.getId());			
			msg = new FacesMessage("Se borró el tipo de premio " + tipopremio);
			
		} else {
			System.out.println("el tipo de premio es null");
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "El Tipo de Premio no es válido.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}


