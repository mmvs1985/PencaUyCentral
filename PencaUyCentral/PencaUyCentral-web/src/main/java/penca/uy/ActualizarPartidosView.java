package penca.uy;
 
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.EquiposGrupoPersistenceRemote;
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
 
@ManagedBean(name="ActualizarPartidosView")
@ViewScoped
public class ActualizarPartidosView implements Serializable {
     
 	private static final long serialVersionUID = 1L;	
 	
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
	@EJB
	EquiposGrupoPersistenceRemote equiposGrupoBean;

 	private String torneo;
 	private List<String> torneos;
 	private String fase;
 	private List<String> fases;
 	private String grupo;
 	private List<String> grupos;
	private List<PartidoString> partidos;

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public List<String> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<String> torneos) {
		this.torneos = torneos;
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

	public List<PartidoString> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<PartidoString> partidos) {
		this.partidos = partidos;
	}

	@PostConstruct
    public void init() {
		List<Torneo> listaTorneos = torneoBean.obtenerTodos();
		int i = listaTorneos.size();
		torneos = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			torneos.add(listaTorneos.get(j).getNombre());
		}       
    }
	
	public void onTorneoChange() {
        if (torneo !=null && !torneo.equals("")) {
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
        if (fase !=null && !fase.equals("")) {
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
 
    public void onGrupoChange() {
        if (grupo !=null && !grupo.equals("")) {
        	int idt = torneoBean.obtenerTorneoPorNombre(torneo);
        	int idf = faseBean.obtenerFasePorNombreYTorneo(idt, fase);
        	int idg = grupoBean.obtenerGrupoPorNombreYFase(grupo, idf);
        	List<Partido> listaPartidos = grupoBean.obtenerPartidosGrupo(idg);
        	List<PartidoString> listaPartidosString = new ArrayList<PartidoString>();
    	    for (Partido p : listaPartidos) {
    	    	PartidoString partido = new PartidoString();
    	    	partido.setId(p.getId());
    	    	partido.setEquipoLocal(p.getEquipLocal().getNombre());
    	    	partido.setEquipoVisita(p.getEquipoVisitante().getNombre());
    	    	partido.setFecha(p.getFecha());
    	    	partido.setHora(p.getHora());
    	    	partido.setGolesEquipoLocal(p.getGolesEquipoLocal());
    	    	partido.setGolesEquipoVisita(p.getGolesEquipoVisita());
    	    	partido.setGrupo(p.getGrupo().getNombre());
    	    	partido.setGrupoId(p.getGrupo().getId());
    	    	listaPartidosString.add(partido);
    	     }
    	     partidos = listaPartidosString;    	     
        }
    }

    public void onRowEdit(RowEditEvent event) {    	
    	FacesMessage msg;    	
		/*try {
			SimpleDateFormat formateadorfecha = new SimpleDateFormat("yyyy-MM-dd");  
			Date fechaactualdate = new Date();	    	
			String fechahoystring = new SimpleDateFormat("yyyy-MM-dd").format(fechaactualdate);
			Date fechaactual = formateadorfecha.parse(fechahoystring);
			Date fechapartidodate = ((PartidoString) event.getObject()).getFecha();
			String fechapartidostring = new SimpleDateFormat("yyyy-MM-dd").format(fechapartidodate);
			Date fechapartido = formateadorfecha.parse(fechapartidostring);
			
	    	SimpleDateFormat formateadorhora = new SimpleDateFormat("HH:mm");
	    	String horaactualstring = new SimpleDateFormat("HH:mm").format(fechaactualdate);
	    	System.out.println("Hora actual string: " + horaactualstring);
			Date horaactualdate = formateadorhora.parse(horaactualstring);
			System.out.println("Hora actual date: " + horaactualdate);
	    	long horaactual = horaactualdate.getTime();
	    	System.out.println("Hora actual ms: " + horaactual);	    	
	    	
	    	String horapartidostring = ((PartidoString) event.getObject()).getHora();
	    	System.out.println("Hora partido string: " + horapartidostring);
			Date horapartidodate = formateadorhora.parse(horapartidostring);
			System.out.println("Hora partido date: " + horapartidodate);
			long horapartido = horapartidodate.getTime();
			System.out.println("Hora partido ms: " + horapartido);    	
	    	if (fechaactual.before(fechapartido)) { 
				msg = new FacesMessage("No se puede actualizar el resultado antes de la fecha que se juega el partido.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				if (fechaactual.equals(fechapartido)) {
					if (horaactual < horapartido + 6000000) {
						msg = new FacesMessage("No se puede actualizar el resultado antes de finalizado el partido.");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
					else {*/
						int id = ((PartidoString) event.getObject()).getId();
						int golesel = ((PartidoString) event.getObject()).getGolesEquipoLocal();
						int golesev = ((PartidoString) event.getObject()).getGolesEquipoVisita();
						int grupo = ((PartidoString) event.getObject()).getGrupoId();
						int idgana;
						int el = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoLocal());
						int ev = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoVisita());
						if (golesel >= golesev) {
							idgana = el;
						} else {
							idgana = ev;
						}
						partidoBean.actualizarPartidoPorId(id, golesel, golesev, idgana);
						int egLocal = equiposGrupoBean.obtenerEquiposGrupoPorEquipoyGrupo(grupo,el).getId();
						int egVisita = equiposGrupoBean.obtenerEquiposGrupoPorEquipoyGrupo(grupo,ev).getId();
						equiposGrupoBean.actualizarEquiposGrupo(egLocal, golesev,golesel);
						equiposGrupoBean.actualizarEquiposGrupo(egVisita, golesel,golesev);
						msg = new FacesMessage("Partido Actualizado");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					/*}
				} else {
					int id = ((PartidoString) event.getObject()).getId();
					int golesel = ((PartidoString) event.getObject()).getGolesEquipoLocal();
					int golesev = ((PartidoString) event.getObject()).getGolesEquipoVisita();
					int grupo = ((PartidoString) event.getObject()).getGrupoId();
					int idgana;
					int el = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoLocal());
					int ev = equipoBean.obtenerEquipoPorNombre(((PartidoString) event.getObject()).getEquipoVisita());
					if (golesel >= golesev) {
						idgana = el;
					} else {
						idgana = ev;
					}
					partidoBean.actualizarPartidoPorId(id, golesel, golesev, idgana);
					int egLocal = equiposGrupoBean.obtenerEquiposGrupoPorEquipoyGrupo(grupo,el).getId();
					int egVisita = equiposGrupoBean.obtenerEquiposGrupoPorEquipoyGrupo(grupo,ev).getId();
					equiposGrupoBean.actualizarEquiposGrupo(egLocal, golesev,golesel);
					equiposGrupoBean.actualizarEquiposGrupo(egVisita, golesel,golesev);
					//equiposGrupoBean.actualizarEquiposGrupo(eg, golenc, golaf)
					msg = new FacesMessage("Partido Actualizado");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} */   	        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("No se Actualizó");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

 
}
