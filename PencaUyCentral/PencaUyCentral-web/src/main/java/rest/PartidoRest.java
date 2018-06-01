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
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Partido;
import entidades.Torneo;

@Path("/partidos")
public class PartidoRest {
	
	
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
    @Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public String getPartidoAll() {
		Gson g = new Gson();
		System.out.println("antes de  la lista");
		List<Partido> listaPartidos = beanPartido.obtenerTodos();
		System.out.println("obtuve la lista");
		JsonArray partidos = new JsonArray();
		int i = listaPartidos.size();	
		System.out.println("i es "+i);
		for (int j=0;j<i;j++) {					
			Partido p =beanPartido.obtenerPartido(listaPartidos.get(j).getId());		
			JsonObject partido = new JsonObject();
			partido.addProperty("id", p.getId() );
			partido.addProperty("fecha", p.getFecha().toString());
			partido.addProperty("estado", p.getEstado());			
			if (!(p.getEstado().equals("N/JUGADO"))){
				partido.addProperty("golesEquipoLocal", p.getGolesEquipoLocal());
				partido.addProperty("golesEquipoVisita", p.getGolesEquipoVisita());
				JsonObject eg = new JsonObject();
				eg.addProperty("id",listaPartidos.get(j).getEquipoGanador().getId());
				eg.addProperty("nombre",listaPartidos.get(j).getEquipoGanador().getNombre());
				partido.add("equipoGanador",eg);				
			}
			JsonObject el = new JsonObject();
			el.addProperty("id",listaPartidos.get(j).getEquipLocal().getId());
			el.addProperty("nombre",listaPartidos.get(j).getEquipLocal().getNombre());
			partido.add("equipoLocal",el);
			JsonObject ev = new JsonObject();
			ev.addProperty("id",listaPartidos.get(j).getEquipoVisitante().getId());
			ev.addProperty("nombre",listaPartidos.get(j).getEquipoVisitante().getNombre());
			partido.add("equipoVisita",ev);
			JsonObject gr = new JsonObject();
			gr.addProperty("id", listaPartidos.get(j).getGrupo().getId());
			gr.addProperty("nombre", listaPartidos.get(j).getGrupo().getNombre());
			partido.add("grupo", gr);
			partidos.add(partido);
			
		
		}
		return g.toJson(partidos);
		
	}
	
}
