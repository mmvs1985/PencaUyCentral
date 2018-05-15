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

import beans.interfaces.OrganizacionPersistenceRemote;
import entidades.Organizacion;

@ManagedBean(name="BorrarOrganizacionView")
@ViewScoped
public class BorrarOrganizacionView implements Serializable {

	private static final long serialVersionUID = 1L;
	private String organizacion;
	private List<String> organizaciones;

	@EJB
	OrganizacionPersistenceRemote organizacionBean;

	@PostConstruct
	public void init() {
		List<Organizacion> lista = organizacionBean.obtenerOrganizaciones();
		int i = lista.size();
		organizaciones = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			organizaciones.add(lista.get(j).getNombre());
		}
	}

	public List<String> getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(List<String> organizaciones) {
		this.organizaciones = organizaciones;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public void borrar() {
		FacesMessage msg;
		if (organizacion != null) {
			System.out.println("la organizacion no es null, es " + organizacion);
			Organizacion o = organizacionBean.obtenerOrganizacionPorNombre(organizacion);
			organizacionBean.eliminarOrganizacion(o.getId());			
			msg = new FacesMessage("Se borró la organización " + organizacion);
			
		} else {
			System.out.println("La organizacion es null");
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "La organizacion no es válida.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}


