package beans;


import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;

import beans.interfaces.RandomLocal;
import beans.interfaces.RandomRemote;



@Stateless
@LocalBean
public class Random implements RandomRemote, RandomLocal {

	public  List<Integer> random() {

		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("https://api.random.org/json-rpc/1/invoke");
			
			Gson gson = new Gson();
			VOJson vojson = new VOJson();
			VOParams voparams = new VOParams();
			voparams.setApiKey("f31b3580-6ce1-4af9-81cf-ac88118179ba");
			voparams.setN(2);
			voparams.setMin(0);
			voparams.setMax(5);
			vojson.setJsonrpc("2.0");
			vojson.setMethod("generateIntegers");
			vojson.setParams(voparams);
			vojson.setId(42);			
			
			Response response = target.request().post(Entity.entity(gson.toJson(vojson), MediaType.TEXT_PLAIN));
			System.out.println(response.getStatus());
			VOReturn retorno = gson.fromJson(response.readEntity(String.class), VOReturn.class);
			List<Integer> lista = retorno.getResult().getRandom().getData();
						
			response.close();
			
			return lista;
			//JsonElement result = gson.toJsonTree(response, VOResult.class);
			//System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}