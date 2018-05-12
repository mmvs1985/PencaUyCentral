package beans.interfaces;

import javax.ejb.Remote;

import entidades.Fase;

@Remote
public interface FasePersistenceRemote {

	public boolean crearFase(String nombre );
    public Fase obtenerFase(int id);
    public boolean eliminarFase(int id);

}
