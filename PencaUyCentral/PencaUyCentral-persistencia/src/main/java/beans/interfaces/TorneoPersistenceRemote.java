package beans.interfaces;

import java.util.Date;

import javax.ejb.Remote;

import entidades.Torneo;
@Remote
public interface TorneoPersistenceRemote {

	public boolean crearTorneo(Torneo t);
    public Torneo obtenerTorneo(int id);
    public boolean eliminarTorneo(Torneo t);
    //public boolean agregarFase(int id);

	
	
}
