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
	
	boolean agregarPenca(Organizacion o);
	
	Penca obtenerPenca(int id);
	
	List<Participante> obtenerParticipantesPenca(int id);

	boolean eliminarPenca(Penca p);
	
	boolean agregarParticipante(String usuario, Penca p);
	
	List<Participante> obtenerParticipantes();
	
	Participante obtenerParticipante(int id);
	
	boolean eliminarParticipante(Participante p);
	
	boolean agregarTipoPremio(String nombre);
	
	List<TiposPremio> obtenerTiposPremio();
	
	TiposPremio obtenerTipoPremio(int id);
	
	boolean eliminarTipoPremio(TiposPremio tp);

}
