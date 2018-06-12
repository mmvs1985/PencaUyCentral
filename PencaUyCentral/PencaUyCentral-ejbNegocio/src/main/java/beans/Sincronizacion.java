package beans;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.interfaces.OrganizacionPersistenceRemote;
import beans.interfaces.ParticipantePersistenceRemote;
import beans.interfaces.PencaPersistenceRemote;
import beans.interfaces.SincronizacionLocal;
import beans.interfaces.SincronizacionRemote;
import entidades.ParticipanteString;

@Stateless
@LocalBean
public class Sincronizacion implements SincronizacionRemote, SincronizacionLocal {

	@EJB
	ParticipantePersistenceRemote participanteBean;
	@EJB
	PencaPersistenceRemote pencaBean;
	@EJB
	OrganizacionPersistenceRemote organizacionBean;


	public Sincronizacion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sincronizar() {

		try {
			//Obtengo los Participantes
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:9080/PencaUyLocal-Backoffice-servicios/rest/api/listado/pencausuario");
			Response response = target.request().get();
			Gson gson = new Gson();
			Type participanteStringListType = new TypeToken<ArrayList<ParticipanteString>>() {}.getType();
			List<ParticipanteString> listaParticipantes = gson.fromJson(response.readEntity(String.class), participanteStringListType);
			
			// Persistir los Participantes
			for (ParticipanteString p : listaParticipantes) {
				//Participante participante = new Participante();
				//participante.set
				
				int penca = pencaBean.obtenerPencaPorNombre(p.getPenca());
				System.out.println("esta es la penca "+penca);
				if (penca == -1) {
					System.out.println(p.getOrganizacion());
					int orgId = organizacionBean.obtenerOrganizacionPorNombre(p.getOrganizacion());
					System.out.println("esta es la organizacion "+orgId);
					pencaBean.agregarPenca(p.getPenca(), orgId);	
					penca = pencaBean.obtenerPencaPorNombre(p.getPenca());
					
				}
				participanteBean.agregarParticipante(p.getUsuario(), penca);
				
				participanteBean.actualizarPuntaje(p.getUsuario(),p.getPuntos());
			}
			System.out.println("Participantes cargados con exito");
			response.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
