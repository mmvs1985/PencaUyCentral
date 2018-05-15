package penca.uy;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.interfaces.OrganizacionPersistenceRemote;


@ManagedBean
@SessionScoped
public class OrganizacionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB private OrganizacionPersistenceRemote bean;
	
	private int id;
	private String nombre;
	
	public OrganizacionBean() {		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregar() {
		bean.agregarOrganizacion(this.getNombre());
	}
	
	

}
