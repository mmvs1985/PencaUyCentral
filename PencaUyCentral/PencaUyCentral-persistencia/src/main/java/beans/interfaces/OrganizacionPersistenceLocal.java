package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;
import entidades.TiposPremio;

@Local
public interface OrganizacionPersistenceLocal {

	boolean agregarOrganizacion(String nombre);

	Organizacion obtenerOrganizacion(int id);
	
	List<Organizacion> obtenerOrganizaciones();

	List<Penca> obtenerPencasOrganizacion(int id);
	
	boolean eliminarOrganizacion(int id);
	
}
