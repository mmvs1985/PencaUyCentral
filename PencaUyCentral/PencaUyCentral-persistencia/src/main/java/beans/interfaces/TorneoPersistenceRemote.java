package beans.interfaces;

import java.util.Date;

import javax.ejb.Remote;

import entidades.Torneo;

@Remote
public interface TorneoPersistenceRemote {

	public boolean crearTorneo(String nombre, String tipo, Date comienzo);
    public Torneo obtenerTorneo(int id);
    public boolean eliminarTorneo(int id);
    //public boolean agregarFase(int id);

	
	
}
