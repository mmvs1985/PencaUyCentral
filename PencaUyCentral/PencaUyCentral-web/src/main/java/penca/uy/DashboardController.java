package penca.uy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.EquiposGrupoPersistenceRemote;
import beans.interfaces.FasePersistenceRemote;
import beans.interfaces.GrupoPersistenceRemote;
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Equipo;
import entidades.Grupo;

@ManagedBean(name = "DashboardController")
@SessionScoped
public class DashboardController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DashboardModel model;

	private List<GrupoString> grupos;
	


	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}

	public List<GrupoString> getGrupos() {
		return grupos;
	}

	public void setGrupo(List<GrupoString> grupos) {
		this.grupos = grupos;
	}


	@EJB
	TorneoPersistenceRemote torneoBean;
	@EJB
	EquipoPersistenceRemote equipoBean;
	@EJB
	FasePersistenceRemote faseBean;
	@EJB
	GrupoPersistenceRemote grupoBean;
	@EJB
	EquiposGrupoPersistenceRemote equiposGrupoBean;
	

	@PostConstruct
	public void init() {
		
		List<Grupo> listaGrupos = faseBean.obtenerGruposFase(2);
		List<GrupoString> gruposList = new ArrayList<GrupoString>();
		
		
		for(Grupo g : listaGrupos) {
			System.out.println("entro al primer for");
			GrupoString grupoString = new GrupoString();
			List<String> listaEquiposString = new ArrayList<String>();
			grupoString.setNombre(g.getNombre());
			grupoString.setId(g.getId());
			
			List<Equipo> listaEquipos = equiposGrupoBean.obtenerEquiposPorGrupo(g.getId());
			for(Equipo e : listaEquipos) {
				System.out.println("entre al segundo for");
				listaEquiposString.add(e.getNombre());
			}
			grupoString.setEquipos(listaEquiposString);
			gruposList.add(grupoString);
		}
		grupos = gruposList;

		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		DashboardColumn column3 = new DefaultDashboardColumn();
		for (int i = 0; i < (gruposList.size() /2); i++) {
			System.out.println(grupos.get(i).getId());
			column1.addWidget("panel" + grupos.get(i).getId());
		}
		for (int j = (gruposList.size() /2); j < gruposList.size(); j++) {
			System.out.println(grupos.get(j).getId());
			column2.addWidget("panel" + grupos.get(j).getId());
		}

		model.addColumn(column1);
		model.addColumn(column2);
	}

}