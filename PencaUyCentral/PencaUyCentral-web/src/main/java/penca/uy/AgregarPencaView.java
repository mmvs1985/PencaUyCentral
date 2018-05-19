package penca.uy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.interfaces.OrganizacionBusinessRemote;
import beans.interfaces.PencaBusinessRemote;
import entidades.Organizacion;

@ManagedBean(name = "AgregarPencaView")
public class AgregarPencaView implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	PencaBusinessRemote pencaBean;
	
	
	@EJB
	OrganizacionBusinessRemote organizacionBean;
	
	private String nombre;
	private String organizacion;
	private List<String> organizaciones;

	@PostConstruct
	public void init() {
		List<Organizacion> lista = organizacionBean.obtenerOrganizaciones();
		int i = lista.size();
		organizaciones = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			organizaciones.add(lista.get(j).getNombre());
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}
	
	public List<String> getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(List<String> organizaciones) {
		this.organizaciones = organizaciones;
	}	

	public void save() {
		int ido = organizacionBean.obtenerOrganizacionPorNombre(organizacion);
		if (pencaBean.agregarPenca(nombre, ido)){				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Se ha agregado la Penca " + nombre + " al la organizacion " + organizacion));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("La Penca " + nombre + " ya existe en la organizacion " + organizacion));
			}
	}

}
