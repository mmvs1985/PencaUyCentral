package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import beans.interfaces.EquipoPersistenceRemote;
import entidades.Equipo;
import entidades.EquiposGrupo;
import entidades.Fase;
import entidades.Grupo;
import entidades.Torneo;


@Path("/equipos")
public class EquipoRest {

	
	
	@EJB
	EquipoPersistenceRemote equipoBean;
	
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
	public String getEquipo(@PathParam("id") int id) {
		System.out.println("entre al get equipo");
		Equipo e = new Equipo();		
		e =equipoBean.obtenerEquipo(id);
		JsonObject equipo = new JsonObject();
		equipo.addProperty("id", e.getId());
		equipo.addProperty("nombre", e.getNombre());	
		Gson gson = new Gson();	
		return gson.toJson(equipo);
	}	
	
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public String getEquipoAll() {
		List<Equipo> listaEquipo = equipoBean.obtenerEquipos();
		JsonArray equipos = new JsonArray();
		Gson gson = new Gson();
		int i = listaEquipo.size();
		for (int j = 0;j<i;j++) {
			JsonObject equipo = new JsonObject();
			equipo.addProperty("id", listaEquipo.get(j).getId());
			equipo.addProperty("nombre", listaEquipo.get(j).getNombre());			
			equipos.add(equipo);
		}
		
		return gson.toJson(equipos);
	}
	
}
