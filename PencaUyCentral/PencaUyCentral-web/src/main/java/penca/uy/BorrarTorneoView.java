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

import beans.interfaces.TorneoBusinessRemote;
import entidades.Torneo;

@ManagedBean(name="BorrarTorneoView")
@ViewScoped
public class BorrarTorneoView implements Serializable {

	private static final long serialVersionUID = 1L;
	private String torneo;
	private List<String> torneos;

	@EJB 
	TorneoBusinessRemote torneoBean;

	@PostConstruct
	public void init() {
		List<Torneo> lista = torneoBean.obtenerTodos();
		int i = lista.size();
		torneos = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			torneos.add(lista.get(j).getNombre());
		}
	}

	public List<String> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<String> torneos) {
		this.torneos = torneos;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public void borrar() {
		FacesMessage msg;
		if (torneo != null) {
			System.out.println("el torneo no es null, es " + torneo);
			Torneo t = torneoBean.obtenerTorneoPorNombre(torneo);
			torneoBean.eliminarTorneo(t.getId());			
			msg = new FacesMessage("Se borró el torneo " + torneo);
			
		} else {
			System.out.println("el torneo es null");
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "El Torneo no es válido.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
