package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.interfaces.PartidoBusinessLocal;
import beans.interfaces.PartidoBusinessRemote;
import beans.interfaces.PartidoPersistenceRemote;
import entidades.Equipo;
import entidades.Partido;

/**
 * Session Bean implementation class PartidoBusiness
 */
@Stateless
@LocalBean
public class PartidoBusiness implements PartidoBusinessRemote, PartidoBusinessLocal {

	@EJB PartidoPersistenceRemote bean;
	
    /**
     * Default constructor. 
     */
    public PartidoBusiness() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean agregarPartido(int elocal, int evisita, int grupo, Date fecha) {
    	return bean.agregarPartido(elocal, evisita, grupo, fecha);
    }
    
    @Override
	public Partido obtenerPartido(int id) {
    	return bean.obtenerPartido(id);
    }
    
    @Override
	public boolean eliminarPartido(int id) {
    	return bean.eliminarPartido(id);
    }
    
    @Override
    public int obtenerPartidoPorGrupoEquipoLocalYEquipoVisitante(int idg, int idel, int idev) {
    	return bean.obtenerPartidoPorGrupoEquipoLocalYEquipoVisitante(idg, idel, idev);
    }
    
    @Override
    public List<Equipo> obtenerEquipoVisitantePartido(int idel, int idg) {
    	return bean.obtenerEquipoVisitantePartido(idel, idg);
    }

}
