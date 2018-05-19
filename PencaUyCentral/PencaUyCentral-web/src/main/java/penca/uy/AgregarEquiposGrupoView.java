package penca.uy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.EquiposGrupoBusiness;
import beans.interfaces.EquipoBusinessRemote;
import beans.interfaces.FaseBusinessRemote;
import beans.interfaces.GrupoBusinessRemote;
import beans.interfaces.TorneoBusinessRemote;
import entidades.Equipo;
import entidades.Fase;
import entidades.Grupo;
import entidades.Torneo;



@ManagedBean(name="AgregarEquiposGrupoView")
@ViewScoped
public class AgregarEquiposGrupoView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String torneo;
	private List<String> torneos;
	private String fase;
	private List<String> fases;
	private String grupo;
	private List<String> grupos;
	private String equipo;
	private List<String> equipos;
	

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public List<String> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<String> equipos) {
		this.equipos = equipos;
	}

	@EJB
	TorneoBusinessRemote torneoBean;
	
	@EJB
	FaseBusinessRemote faseBean;
	
	@EJB
	GrupoBusinessRemote grupoBean;
	
	@EJB 
	EquipoBusinessRemote equipoBean;
	
	@EJB
	EquiposGrupoBusiness equiposGrupoBean;

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}

	@PostConstruct
	public void init() {
		List<Torneo> lista = torneoBean.obtenerTodos();
		int i = lista.size();
		torneos = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			torneos.add(lista.get(j).getNombre());
		}
		
		List<Equipo> listaEquipos = equipoBean.obtenerEquipos();
		int z = listaEquipos.size();
		equipos = new ArrayList<String>();
		for (int j = 0; j < z; j++) {
			equipos.add(listaEquipos.get(j).getNombre());
		}
	}

	public List<String> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<String> torneos) {
		this.torneos = torneos;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}
	

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public List<String> getFases() {
		return fases;
	}

	public void setFases(List<String> fases) {
		this.fases = fases;
	}
	
	 public void onTorneoChange() {
	        if(torneo !=null && !torneo.equals("")) {
	        	System.out.println("Este es el torneo "+ torneo);
	        	int idt = torneoBean.obtenerTorneoPorNombre(torneo);
	        	List<Fase> listaFases = faseBean.obtenerFasesPorTorneo(idt);
	        	int x = listaFases.size();
	    		fases = new ArrayList<String>();
	    		for (int j = 0; j < x; j++) {
	    			fases.add(listaFases.get(j).getNombre());
	    		}
	        }
	   }
	 
	 public void onFaseChange() {
		 System.out.println("entre al onFaseChange");
		 if(fase !=null && !fase.equals("")) {
	        	System.out.println("Esta es la fase "+ fase);
	        	int idt = torneoBean.obtenerTorneoPorNombre(torneo);
	        	int idf = faseBean.obtenerFasePorNombreYTorneo(idt, fase);
	        	List<Grupo> listaGrupos = grupoBean.obtenerGruposPorFase(idf);
	        	int z = listaGrupos.size();
	    		grupos = new ArrayList<String>();
	    		for (int y = 0; y < z; y++) {
	    			grupos.add(listaGrupos.get(y).getNombre());
	    		}
	        }
	   }

	public void save() {
		FacesMessage msg;
		if ((grupo != null) && (equipo != null)) {
			System.out.println("el grupo "+grupo+" no es null, la fase "+fase+ "no es null");
			int idt = torneoBean.obtenerTorneoPorNombre(torneo);			
			int idf = faseBean.obtenerFasePorNombreYTorneo(idt, fase);
			int idg = grupoBean.obtenerGrupoPorNombreYFase(grupo, idf);
			int ide = equipoBean.obtenerEquipoPorNombre(equipo);			
			equiposGrupoBean.agregarEquiposGrupo(ide,idg);
			msg = new FacesMessage("Se añadió el equipo  " + equipo + " en el grupo "+ grupo);
			
		} else {
			System.out.println("el torneo es null");
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "El Torneo no es válido.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
