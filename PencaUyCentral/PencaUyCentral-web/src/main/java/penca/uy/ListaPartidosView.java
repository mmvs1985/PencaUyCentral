package penca.uy;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.FasePersistenceRemote;
import beans.interfaces.GrupoPersistenceRemote;
import beans.interfaces.PartidoPersistenceRemote;
import beans.interfaces.TorneoPersistenceRemote;
import beans.interfaces.UsuarioPersistenceRemote;
import entidades.Fase;
import entidades.Grupo;
import entidades.Partido;
import entidades.Torneo;
import entidades.Usuario;
 
@ManagedBean(name="ListaPartidosView")
//@ViewScoped
public class ListaPartidosView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	

	private List<PartidoString> partidos;


	public List<PartidoString> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<PartidoString> partidos) {
		this.partidos = partidos;
	}

	@EJB
	TorneoPersistenceRemote torneoBean;
	@EJB
	FasePersistenceRemote faseBean;
	@EJB
	GrupoPersistenceRemote grupoBean;
	@EJB
	PartidoPersistenceRemote partidoBean;
	@EJB
	EquipoPersistenceRemote equipoBean;
	
 
    @PostConstruct
    public void init() {
    	List<Partido> listaPartidos = new ArrayList<Partido>();
    	List<Torneo> listaTorneos = torneoBean.obtenerTodos();
    	for(Torneo t : listaTorneos) {
    		List<Fase> listaFases = torneoBean.obtenerFasesTorneo(t.getId());
    		for(Fase f : listaFases) {
    			List<Grupo> listaGrupos = faseBean.obtenerGruposFase(f.getId());
    			for(Grupo g : listaGrupos) {
    				
    				List<Partido> listaPart = grupoBean.obtenerPartidosGrupo(g.getId());
    				for(Partido p : listaPart) {
    					listaPartidos.add(p);
    				}
    				
    			}
    		}
    	}
    	List<PartidoString> listaPartidosString = new ArrayList<PartidoString>();
    	System.out.println(listaPartidos.get(0).getId());
	       for(Partido p : listaPartidos) {
	    	   System.out.println("entre al for de partidos con partido "+p.getId());
	    	   PartidoString partido = new PartidoString();
	    	   partido.setId(p.getId());
	    	   partido.setEquipoLocal(p.getEquipLocal().getNombre());
	    	   partido.setEquipoVisita(p.getEquipoVisitante().getNombre());
	    	   partido.setFecha(p.getFecha());
	    	   partido.setGolesEquipoLocal(p.getGolesEquipoLocal());
	    	   partido.setGolesEquipoVisita(p.getGolesEquipoVisita());
	    	   partido.setGrupo(p.getGrupo().getNombre());
	    	   listaPartidosString.add(partido);
	       }
	     this.partidos = listaPartidosString;
       
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Partido Actualizado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int id = ((PartidoString) event.getObject()).getId();
        int golesel = ((PartidoString) event.getObject()).getGolesEquipoLocal();
        int golesev = ((PartidoString) event.getObject()).getGolesEquipoVisita();
        int idgana;
        if (golesel>=golesev) {
        	idgana = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoLocal());
        }else {
        	idgana = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoVisita());
        }
        partidoBean.actualizarPartidoPorId(id, golesel, golesev, idgana);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("No se Actualizó");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

 
}
