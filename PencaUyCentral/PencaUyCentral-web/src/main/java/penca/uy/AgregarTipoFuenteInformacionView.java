package penca.uy;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.interfaces.TiposFuenteInformacionPersistenceRemote;

@ManagedBean(name = "AgregarTipoFuenteInformacionView")
public class AgregarTipoFuenteInformacionView implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB TiposFuenteInformacionPersistenceRemote tipoFuenteInformacionBean;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void save() {
		System.out.println("save");
		if (tipoFuenteInformacionBean.agregarTipoFuenteInformacion(nombre)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Se ha agregado el tipo de fuente de información " + nombre));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ya existe un tipo de fuente de información con ese nombre"));
		}
	}
	

}

