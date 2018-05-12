package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;
import entidades.TiposPremio;

@Remote
public interface OrganizacionPersistenceRemote {

	boolean agregarOrganizacion(String nombre);

	Organizacion obtenerOrganizacion(int id);

	List<Penca> obtenerPencasOrganizacion(int id);

	boolean eliminarOrganizacion(int id);	

}
