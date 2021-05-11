package atosWebProjectRPretto.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import atosWebProjectRPretto.models.ClientM;


@ManagedBean(name="clientMBean")
@RequestScoped
public class ClientMBean {
	
	private ClientM clientM;
	private int clientId;
	
	@PostConstruct
	public void init() {
		clientM = new ClientM();
	}
	
	public List<ClientM> getClientsAPI() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Client/listClients");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<ClientM>>(){}.getType());
		
	}
	
	public void setExcludeClientAPI(int clientId) {
		Client c = Client.create();
		WebResource wr = c.resource(
				"http://localhost:8080/Client/deleteClient"+ clientId);
		        wr.delete();
	}
	
	public String getClientToAlterate(ClientM clientM) {
	      this.clientM =  clientM; 
	      return "AlterateClient";
	}
	
	public String getClientToInformation(ClientM clientM) {
	      this.clientM =  clientM; 
	      return "InfoClient";
	}
	
	public String setAlterateClientAPI(ClientM clientM) {
		Client c = Client.create();
		Gson gson = new Gson();
		int clientId = clientM.getId();
		WebResource wr = c.resource(
				"http://localhost:8080/Client/listClient/alterate"+clientId);
		wr.type("application/json").accept("application/json")
        .put(gson.toJson(clientM));
		return "Clients";
	}
	
	public String setSaveClientAPI(ClientM clientM) {
		Client c = Client.create();
		Gson gson = new Gson();
		WebResource wr = c.resource(
				"http://localhost:8080/Client/registerClient");
		wr.type("application/json").accept("application/json")
        .post(gson.toJson(clientM));
		return "Clients";
	}

	public ClientM getClientM() {
		return clientM;
	}

	public void setClientM(ClientM clientM) {
		this.clientM = clientM;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	
	
	

}
