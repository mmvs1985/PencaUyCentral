package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import beans.interfaces.EquipoPersistenceRemote;
import beans.interfaces.EquiposGrupoPersistenceRemote;
import beans.interfaces.FasePersistenceRemote;
import beans.interfaces.GrupoPersistenceRemote;
import beans.interfaces.PartidoPersistenceRemote;
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Equipo;
import entidades.EquiposGrupo;
import entidades.Fase;
import entidades.Grupo;
import entidades.Partido;
import entidades.Torneo;



@Path("/torneos")
public class TorneoRest {
	
	
	@EJB
	TorneoPersistenceRemote beanTorneo;
	@EJB
	FasePersistenceRemote beanFase;
	@EJB
	GrupoPersistenceRemote beanGrupo;
	@EJB
	EquiposGrupoPersistenceRemote beanEquiposGrupo;
	@EJB
	EquipoPersistenceRemote beanEquipos;
	@EJB
	PartidoPersistenceRemote beanPartido;
	

	@GET
    @Path("/hello")
	@Produces({MediaType.TEXT_PLAIN})
    public String sayHello(){
		System.out.println("entre al get hello");
        return "Hola pelotudos";
    }
	
	@GET
    @Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
    public String getTorneo(@PathParam("id") int id) {
		Gson g = new Gson();
		Torneo t = new Torneo();		
		t =beanTorneo.obtenerTorneo(id);		
		JsonObject torneo = new JsonObject();
		torneo.addProperty("id", t.getId());
		torneo.addProperty("nombre", t.getNombre());
		torneo.addProperty("tipo", t.getTipo());
		torneo.addProperty("comienzo", t.getComienzo().toString());
		List<Fase> listaFase = beanTorneo.obtenerFasesTorneo(id);
		int i = listaFase.size();
		System.out.println("i es "+i);
		JsonArray fases = new JsonArray();
		
		for (int j=0;j<i;j++) {
			JsonObject fase = new JsonObject();		
			fase.addProperty("id",listaFase.get(j).getId());
			fase.addProperty("nombre", listaFase.get(j).getNombre());
			List<Grupo> listaGrupo = beanFase.obtenerGruposFase(listaFase.get(j).getId());
			int x = listaGrupo.size();
			JsonArray grupos = new JsonArray();
			
			for (int k=0;k<x;k++) {
				List<EquiposGrupo> listaEquiposGrupo = new ArrayList<EquiposGrupo>();
				System.out.println("j de fases es "+j);
				System.out.println("k de grupos es "+k);
				JsonObject grupo = new JsonObject();
				grupo.addProperty("id", listaGrupo.get(k).getId());
				grupo.addProperty("nombre", listaGrupo.get(k).getNombre());				
				JsonArray equiposGrupo = new JsonArray();				

				System.out.println(listaGrupo.get(k).getId());
					
				listaEquiposGrupo = beanGrupo.obtenerEquiposGrupo(listaGrupo.get(k).getId());
				if (listaEquiposGrupo != null) {
					int y = listaEquiposGrupo.size();
					System.out.println("y es "+y);
					for (int l=0;l<y;l++) {
						System.out.println("j de fases es "+j);
						System.out.println("k de grupos es "+k);
						System.out.println("l de equiposgrupo es "+l);
						JsonObject equipoGrupo = new JsonObject();
						equipoGrupo.addProperty("id", listaEquiposGrupo.get(l).getId());
						equipoGrupo.addProperty("equipoid", listaEquiposGrupo.get(l).getEquipo().getId());
						equipoGrupo.addProperty("golenContra", listaEquiposGrupo.get(l).getGolenContra());
						equipoGrupo.addProperty("golesFavor", listaEquiposGrupo.get(l).getGolesFavor());
						equipoGrupo.addProperty("partidosEmpatados", listaEquiposGrupo.get(l).getPartidosEmpatados());
						equipoGrupo.addProperty("partidosGanados", listaEquiposGrupo.get(l).getPartidosGanados());
						equipoGrupo.addProperty("partidosJugados", listaEquiposGrupo.get(l).getPartidosJugados());
						equipoGrupo.addProperty("partidosPerdidos", listaEquiposGrupo.get(l).getPartidosPerdidos());
						equipoGrupo.addProperty("posicion",listaEquiposGrupo.get(l).getPosicion());
						equipoGrupo.addProperty("puntos", listaEquiposGrupo.get(l).getPuntos());
			
						JsonObject eq = new JsonObject();
						eq.addProperty("id",listaEquiposGrupo.get(l).getEquipo().getId());
						eq.addProperty("nombre",listaEquiposGrupo.get(l).getEquipo().getNombre());
						equipoGrupo.add("equipo",eq);
						System.out.println(listaEquiposGrupo.get(l).getEquipo().getNombre());
						
						equiposGrupo.add(equipoGrupo);
					}			
					grupo.add("equiposGrupo", equiposGrupo);
				}
				JsonArray partidos = new JsonArray();
				List<Partido> listaPartido = new ArrayList<>();				
				listaPartido = beanGrupo.obtenerPartidosGrupo(listaGrupo.get(k).getId());
				if (!(listaPartido.isEmpty())) {
					int r = listaPartido.size();
					for (int s = 0;s<r;s++) {
						Partido p =beanPartido.obtenerPartido(listaPartido.get(s).getId());
						JsonObject partido = new JsonObject();
						partido.addProperty("id", p.getId() );
						partido.addProperty("fecha", p.getFecha().toString());
						partido.addProperty("estado", p.getEstado());			
						if (!(p.getEstado().equals("N/JUGADO"))){
							partido.addProperty("golesEquipoLocal", p.getGolesEquipoLocal());
							partido.addProperty("golesEquipoVisita", p.getGolesEquipoVisita());
							JsonObject eg = new JsonObject();
							eg.addProperty("id",listaPartido.get(s).getEquipoGanador().getId());
							eg.addProperty("nombre",listaPartido.get(s).getEquipoGanador().getNombre());
							partido.add("equipoGanador",eg);				
						}
						JsonObject el = new JsonObject();
						el.addProperty("id",listaPartido.get(s).getEquipLocal().getId());
						el.addProperty("nombre",listaPartido.get(s).getEquipLocal().getNombre());
						partido.add("equipoLocal",el);
						JsonObject ev = new JsonObject();
						ev.addProperty("id",listaPartido.get(s).getEquipoVisitante().getId());
						ev.addProperty("nombre",listaPartido.get(s).getEquipoVisitante().getNombre());
						partido.add("equipoVisita",ev);
						JsonObject gr = new JsonObject();
						gr.addProperty("id", listaPartido.get(s).getGrupo().getId());
						gr.addProperty("nombre", listaPartido.get(s).getGrupo().getNombre());
						partido.add("grupo", gr);
						partidos.add(partido);
						
					}
					grupo.add("partidos", partidos);
					
				}			
				
				grupos.add(grupo);
							
			}	
			fase.add("grupos", grupos);
			fases.add(fase);
		}
		
		torneo.add("fases", fases);
		return g.toJson(torneo);
		
		
		/*
		 *GsonBuilder convierte automaticamente nuestro Torneo a json 
		 *
		GsonBuilder gsonBuilder = new GsonBuilder();
		new GraphAdapterBuilder()
		    .addType(Torneo.class)
		    .addType(Fase.class)
		    .addType(Grupo.class)
		    .addType(EquiposGrupo.class)
		    .addType(Equipo.class)
		    .registerOn(gsonBuilder);
		Gson gson = gsonBuilder.create();
		
		return gson.toJson(t);
		*/
			
    }
	
	
	
	@GET
    @Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
    public String getTorneoAll() {
		Gson g = new Gson();
		List<Torneo> listaTorneo = beanTorneo.obtenerTodos();
		
		JsonArray torneos = new JsonArray();
		int h = listaTorneo.size();	
		for (int z=0;z<h;z++) {					
			Torneo t =beanTorneo.obtenerTorneo(listaTorneo.get(z).getId());		
			JsonObject torneo = new JsonObject();
			torneo.addProperty("id", t.getId());
			torneo.addProperty("nombre", t.getNombre());
			torneo.addProperty("tipo", t.getTipo());
			torneo.addProperty("comienzo", t.getComienzo().toString());

			List<Fase> listaFase = beanTorneo.obtenerFasesTorneo(listaTorneo.get(z).getId());
			int i = listaFase.size();
			System.out.println("i es "+i);
			JsonArray fases = new JsonArray();
			
			for (int j=0;j<i;j++) {
				JsonObject fase = new JsonObject();		
				fase.addProperty("id",listaFase.get(j).getId());
				fase.addProperty("nombre", listaFase.get(j).getNombre());
				List<Grupo> listaGrupo = beanFase.obtenerGruposFase(listaFase.get(j).getId());
				int x = listaGrupo.size();
				JsonArray grupos = new JsonArray();
				
				for (int k=0;k<x;k++) {
					List<EquiposGrupo> listaEquiposGrupo = new ArrayList<EquiposGrupo>();
					System.out.println("j de fases es "+j);
					System.out.println("k de grupos es "+k);
					JsonObject grupo = new JsonObject();
					grupo.addProperty("id", listaGrupo.get(k).getId());
					grupo.addProperty("nombre", listaGrupo.get(k).getNombre());				
					JsonArray equiposGrupo = new JsonArray();				

					System.out.println(listaGrupo.get(k).getId());
						
					listaEquiposGrupo = beanGrupo.obtenerEquiposGrupo(listaGrupo.get(k).getId());
					if (listaEquiposGrupo != null) {
						int y = listaEquiposGrupo.size();
						System.out.println("y es "+y);
						for (int l=0;l<y;l++) {
							System.out.println("j de fases es "+j);
							System.out.println("k de grupos es "+k);
							System.out.println("l de equiposgrupo es "+l);
							JsonObject equipoGrupo = new JsonObject();
							equipoGrupo.addProperty("id", listaEquiposGrupo.get(l).getId());
							equipoGrupo.addProperty("equipoid", listaEquiposGrupo.get(l).getEquipo().getId());
							equipoGrupo.addProperty("golenContra", listaEquiposGrupo.get(l).getGolenContra());
							equipoGrupo.addProperty("golesFavor", listaEquiposGrupo.get(l).getGolesFavor());
							equipoGrupo.addProperty("partidosEmpatados", listaEquiposGrupo.get(l).getPartidosEmpatados());
							equipoGrupo.addProperty("partidosGanados", listaEquiposGrupo.get(l).getPartidosGanados());
							equipoGrupo.addProperty("partidosJugados", listaEquiposGrupo.get(l).getPartidosJugados());
							equipoGrupo.addProperty("partidosPerdidos", listaEquiposGrupo.get(l).getPartidosPerdidos());
							equipoGrupo.addProperty("posicion",listaEquiposGrupo.get(l).getPosicion());
							equipoGrupo.addProperty("puntos", listaEquiposGrupo.get(l).getPuntos());
							JsonObject eq = new JsonObject();
							eq.addProperty("id",listaEquiposGrupo.get(l).getEquipo().getId());
							eq.addProperty("nombre",listaEquiposGrupo.get(l).getEquipo().getNombre());
							equipoGrupo.add("equipo",eq);
							System.out.println(listaEquiposGrupo.get(l).getId());
							
							equiposGrupo.add(equipoGrupo);
						}			
						grupo.add("equiposGrupo", equiposGrupo);
						
					}	
					JsonArray partidos = new JsonArray();
					List<Partido> listaPartido = new ArrayList<>();				
					listaPartido = beanGrupo.obtenerPartidosGrupo(listaGrupo.get(k).getId());
					if (!(listaPartido.isEmpty())) {
						int r = listaPartido.size();
						for (int s = 0;s<r;s++) {
							Partido p =beanPartido.obtenerPartido(listaPartido.get(s).getId());
							JsonObject partido = new JsonObject();
							partido.addProperty("id", p.getId() );
							partido.addProperty("fecha", p.getFecha().toString());
							partido.addProperty("estado", p.getEstado());			
							if (!(p.getEstado().equals("N/JUGADO"))){
								partido.addProperty("golesEquipoLocal", p.getGolesEquipoLocal());
								partido.addProperty("golesEquipoVisita", p.getGolesEquipoVisita());
								partido.addProperty("equipoGanador", p.getEquipoGanador().getId());				
							}
							JsonObject el = new JsonObject();
							el.addProperty("id",listaPartido.get(s).getEquipLocal().getId());
							el.addProperty("nombre",listaPartido.get(s).getEquipLocal().getNombre());
							partido.add("equipoLocal",el);
							JsonObject ev = new JsonObject();
							ev.addProperty("id",listaPartido.get(s).getEquipoVisitante().getId());
							ev.addProperty("nombre",listaPartido.get(s).getEquipoVisitante().getNombre());
							partido.add("equipoVisita",ev);
							JsonObject gr = new JsonObject();
							gr.addProperty("id", listaPartido.get(s).getGrupo().getId());
							gr.addProperty("nombre", listaPartido.get(s).getGrupo().getNombre());
							partido.add("grupo", gr);						
							partidos.add(partido);
							
						}
						grupo.add("partidos", partidos);
					}
					
					
					grupos.add(grupo);
								
				}	
				fase.add("grupos", grupos);
				fases.add(fase);
			}
			
			torneo.add("fases", fases);
			torneos.add(torneo);
		}	
		
		return 	g.toJson(torneos);
	}
	
}


