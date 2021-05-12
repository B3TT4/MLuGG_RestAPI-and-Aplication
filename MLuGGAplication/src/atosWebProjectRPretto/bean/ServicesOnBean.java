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
import atosWebProjectRPretto.models.Product;
import atosWebProjectRPretto.models.ServicesOn;


@ManagedBean(name="servicesOnBean")
@RequestScoped
public class ServicesOnBean {
	
	private Integer clientId;
	private ServicesOn service;
	private Integer productId;
	private Product product;
	
	@PostConstruct
	public void init() {
		service = new ServicesOn();
	}
	
	
	public String setSaveServiceOnAPI(Long productId, Long clientId, ServicesOn service) {
		Client c = Client.create();
		Gson gson = new Gson();
		WebResource wr = c.resource(
				"http://localhost:8080/ServicesOn/registerServiceOn/Product"+ productId +"Client" + clientId);
		wr.type("application/json").accept("application/json")
        .post(gson.toJson(service));
		return "Services";
	}
	
	public List<ServicesOn> getServicesOnAPI() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/ServicesOn/listServicesOn");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<ServicesOn>>(){}.getType());
		
	}
	
	public String setAlterateServiceAPI(ServicesOn service) {
		Client c = Client.create();
		Gson gson = new Gson();
		int serviceId = service.getId();
		WebResource wr = c.resource(
				"http://localhost:8080/ServicesOn/listService/"+serviceId);
		wr.type("application/json").accept("application/json")
        .put(gson.toJson(service));
		return "Services";
	}
	
	public String getServiceOnToAlterate(ServicesOn service) {
	      this.service =  service; 
	      return "AlterateService";
	}
	
	public String getServiceOnToInfo(ServicesOn service) {
	      this.service =  service; 
	      return "InfoService";
	}
	
	public void setExcludeServiceAPI(Long serviceId) {
		Client c = Client.create();
		WebResource wr = c.resource(
				"http://localhost:8080/ServicesOn/deleteService"+ serviceId);
		        wr.delete();
	}
	
	

	public Integer getClientId() {
		return clientId;
	}


	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getProductId() {
		return productId;
	}

	public ServicesOn getService() {
		return service;
	}

	public void setService(ServicesOn service) {
		this.service = service;
	}
	
	
	
}
