package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Organizacion;
import entidades.Participante;
import entidades.Penca;
import entidades.TiposPremio;

@Remote
public interface OrganizacionPersistenceRemote {

	public boolean agregarOrganizacion(String nombre);
	public Organizacion obtenerOrganizacion(int id);
	public List<Penca> obtenerPencasOrganizacion(int id);
	public boolean eliminarOrganizacion(int id);	

}
