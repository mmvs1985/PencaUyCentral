package beans.interfaces;

import javax.ejb.Local;

import entidades.Fase;

@Local
public interface FasePersistenceLocal {
	public boolean crearFase(String nombre,int torneoId);
    public Fase obtenerFase(int id);
    public boolean eliminarFase(int id);

}
