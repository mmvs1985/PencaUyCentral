package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.EquiposGrupoPersistenceRemote;
import beans.interfaces.FasePersistenceRemote;
import beans.interfaces.GrupoPersistenceRemote;
import beans.interfaces.PartidoPersistenceRemote;
import beans.interfaces.TiposFuenteInformacionPersistenceRemote;
import beans.interfaces.TiposPremioPersistenceRemote;
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Equipo;
import entidades.EquiposGrupo;
import entidades.Fase;
import entidades.Grupo;
import entidades.Partido;
import entidades.TiposFuenteInformacion;
import entidades.TiposPremio;
import entidades.Torneo;

@Path("/api")
public class TorneoApi {
	
	@EJB
	TorneoPersistenceRemote beanTorneo;
	@EJB
	FasePersistenceRemote beanFase;
	@EJB
	GrupoPersistenceRemote beanGrupo;
	@EJB
	EquiposGrupoPersistenceRemote beanEquiposGrupo;
	@EJB
	EquipoPersistenceRemote beanEquipo;
	@EJB
	PartidoPersistenceRemote beanPartido;
	@EJB
	TiposPremioPersistenceRemote beanTiposPremio;
	@EJB
	TiposFuenteInformacionPersistenceRemote beanTiposFuenteInformacion;
	
	
	@GET
    @Path("/hello")
	@Produces({MediaType.TEXT_PLAIN})
    public String sayHello(){
		System.out.println("entre al get hello");
        return "Hola"
        		+ "";
    }
	
	
	@GET
	@Path("/tipospremio")
	@Produces({MediaType.APPLICATION_JSON})
	public String getTiposPremioAll() {
		Gson g = new Gson();
		List<TiposPremio> listaTiposPremio = beanTiposPremio.obtenerTiposPremio();
		return g.toJson(listaTiposPremio);	
		
	}
	
	
	@GET
	@Path("/tiposfuente")
	@Produces({MediaType.APPLICATION_JSON})
	public String getTiposFuenteInformacionAll() {
		Gson g = new Gson();
		List<TiposFuenteInformacion> listaTiposFuente = beanTiposFuenteInformacion.obtenerTiposFuenteInformacion();
		return g.toJson(listaTiposFuente);	
		
	}
	
	@GET
    @Path("/torneos")
	@Produces({MediaType.APPLICATION_JSON})
    public String getTorneos() {
		Gson gson = new Gson();
		List<Torneo> listaTorneos = beanTorneo.obtenerTodos();
		JsonArray torneosArray = new JsonArray();
		for(Torneo t : listaTorneos) {
			JsonObject torneoObject = new JsonObject();
			torneoObject.addProperty("id", t.getId());
			torneoObject.addProperty("nombre", t.getNombre());
			torneoObject.addProperty("tipo", t.getTipo());
			torneoObject.addProperty("comienzo", t.getComienzo().toString());
			torneosArray.add(torneoObject);
		}
		return gson.toJson(torneosArray);		
	}
	
	@GET
    @Path("/fases")
	@Produces({MediaType.APPLICATION_JSON})
    public String getFases() {
		Gson gson = new Gson();
		List<Fase> listaFases = beanFase.obtenerTodos();
		JsonArray fasesArray = new JsonArray();
		for(Fase f : listaFases) {
			JsonObject faseObject = new JsonObject();
			faseObject.addProperty("id", f.getId());
			faseObject.addProperty("nombre", f.getNombre());
			JsonObject torneoObj = new JsonObject();
			torneoObj.addProperty("id", f.getTorneo().getId());
			
			faseObject.add("torneo", torneoObj);
			fasesArray.add(faseObject);
		}
		return gson.toJson(fasesArray);		
	}
	
	@GET
    @Path("/grupos")
	@Produces({MediaType.APPLICATION_JSON})
    public String getGrupos() {
		Gson gson = new Gson();
		List<Grupo> listaGrupos = beanGrupo.obtenerTodos();
		JsonArray gruposArray = new JsonArray();
		for(Grupo g  : listaGrupos) {
			JsonObject grupoObject = new JsonObject();
			grupoObject.addProperty("id", g.getId());
			grupoObject.addProperty("nombre", g.getNombre());
			JsonObject faseObj = new JsonObject();
			faseObj.addProperty("id", g.getFase().getId());
			grupoObject.add("fase", faseObj);
			gruposArray.add(grupoObject);
		}
		return gson.toJson(gruposArray);		
	}
	
	@GET
    @Path("/equiposgrupo")
	@Produces({MediaType.APPLICATION_JSON})
    public String getEquiposGrupo() {
		Gson gson = new Gson();
		List<EquiposGrupo> listaEquiposGrupo = beanEquiposGrupo.obtenerTodos();
		JsonArray equiposGrupoArray = new JsonArray();
		for(EquiposGrupo eg  : listaEquiposGrupo) {
			JsonObject equipoGrupoObject = new JsonObject();
			
			
			
			equipoGrupoObject.addProperty("id", eg.getId());
			JsonObject equipoObj = new JsonObject();
			equipoObj.addProperty("id", eg.getEquipo().getId());
			equipoGrupoObject.add("equipo", equipoObj);
			JsonObject grupoObj = new JsonObject();
			grupoObj.addProperty("id", eg.getGrupo().getId());
			equipoGrupoObject.add("grupo", grupoObj);
			equipoGrupoObject.addProperty("golenContra", eg.getGolenContra());
			equipoGrupoObject.addProperty("golesFavor", eg.getGolesFavor());
			equipoGrupoObject.addProperty("partidosEmpatados", eg.getPartidosEmpatados());
			equipoGrupoObject.addProperty("partidosGanados", eg.getPartidosGanados());
			equipoGrupoObject.addProperty("partidosJugados", eg.getPartidosJugados());
			equipoGrupoObject.addProperty("partidosPerdidos", eg.getPartidosPerdidos());
			equipoGrupoObject.addProperty("posicion",eg.getPosicion());
			equipoGrupoObject.addProperty("puntos", eg.getPuntos());
						
			equiposGrupoArray.add(equipoGrupoObject);		
		}
		return gson.toJson(equiposGrupoArray);		
	}
	
	@GET
    @Path("/equipos")
	@Produces({MediaType.APPLICATION_JSON})
    public String getEquipos() {
		Gson gson = new Gson();
		List<Equipo> listaEquipos = beanEquipo.obtenerEquipos();
		JsonArray equiposArray = new JsonArray();
		for(Equipo e : listaEquipos) {
			JsonObject equipoObject = new JsonObject();
			equipoObject.addProperty("id", e.getId());
			equipoObject.addProperty("nombre", e.getNombre());
			equiposArray.add(equipoObject);
		}
		return gson.toJson(equiposArray);		
	}
	
	
	@GET
    @Path("/partidos")
	@Produces({MediaType.APPLICATION_JSON})
    public String getPartidos() {
		Gson gson = new Gson();
		List<Partido> listaPartidos = beanPartido.obtenerTodos();
		JsonArray partidosArray = new JsonArray();
		for(Partido p  : listaPartidos) {
			JsonObject partidoObject = new JsonObject();
			
			
			
			partidoObject.addProperty("id", p.getId());
			
			partidoObject.addProperty("fecha", p.getFecha().toString());
			partidoObject.addProperty("estado", p.getEstado());			
			if (!(p.getEstado().equals("N/JUGADO"))){
				partidoObject.addProperty("golesEquipoLocal", p.getGolesEquipoLocal());
				partidoObject.addProperty("golesEquipoVisita", p.getGolesEquipoVisita());
				JsonObject egObj = new JsonObject();
				egObj.addProperty("id",p.getEquipoGanador().getId());
				partidoObject.add("equipoGanador",egObj);				
			}
			JsonObject elObj = new JsonObject();
			elObj.addProperty("id",p.getEquipLocal().getId());
			partidoObject.add("equipoLocal",elObj);
			JsonObject evObj = new JsonObject();
			evObj.addProperty("id",p.getEquipoVisitante().getId());
			partidoObject.add("equipoVisita",evObj);
			JsonObject grObj = new JsonObject();
			grObj.addProperty("id", p.getGrupo().getId());
			partidoObject.add("grupo", grObj);
									
			partidosArray.add(partidoObject);		
		}
		return gson.toJson(partidosArray);		
	}
	
	
}
