package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Organizacion;
import entidades.Penca;

@Remote
public interface OrganizacionPersistenceRemote {

	boolean agregarOrganizacion(String nombre);

	Organizacion obtenerOrganizacion(String nombre);

	List<Penca> obtenerPencasOrganizacion(String nombre);

	boolean agregarPencaEnOrganizacion(String nombre, Penca penca);

	boolean eliminarPencaEnOrganizacion(String nombre, Penca penca);

	boolean eliminarOrganizacion(String nombre);

}
