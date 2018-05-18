package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entidades.Fase;

@Remote
public interface FaseBusinessRemote {
	public boolean agregarFase(String nombre,int torneoId);
    public Fase obtenerFase(int id);
    public boolean eliminarFase(int id);
    public List<Fase> obtenerFasesPorTorneo(int id);
    public Fase obtenerFasePorNombreYTorneo(int id,String nombre);
}
