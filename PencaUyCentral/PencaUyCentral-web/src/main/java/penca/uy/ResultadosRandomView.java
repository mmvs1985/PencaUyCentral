package penca.uy;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.PartidoPersistenceRemote;
import beans.interfaces.RandomRemote;
import entidades.Partido;

@ManagedBean(name = "ResultadosRandomView")
public class ResultadosRandomView implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB PartidoPersistenceRemote partidoBean;
	@EJB RandomRemote randomBean;
	
	
	public void random() {
		
		List<Partido> listaPartidos = partidoBean.obtenerTodos();
		for(Partido p : listaPartidos) {
			if (!(p.getEstado().equals("JUGADO"))){
				List<Integer> listaRandom = randomBean.random();
				partidoBean.actualizarPartido(p.getGrupo().getId(), p.getEquipLocal().getId(),p.getEquipoVisitante().getId() , listaRandom.get(0), listaRandom.get(1), p.getEquipLocal().getId());
				
			}
		}
		if(!(listaPartidos.isEmpty() )) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Se actualizaron los resultados de los partidos"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No hay partidos para actualizar"));
		}
		
		
		
	}
	

}
