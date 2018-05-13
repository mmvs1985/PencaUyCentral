package beans.interfaces;

import javax.ejb.Local;

import entidades.Torneo;

@Local
public interface TorneoPersistenceLocal {
	public boolean crearTorneo(Torneo t);
    public Torneo obtenerTorneo(int id);
    public boolean eliminarTorneo(Torneo t);

}
