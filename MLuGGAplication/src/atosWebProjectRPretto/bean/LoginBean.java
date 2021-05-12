package atosWebProjectRPretto.bean;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;


import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

import atosWebProjectRPretto.models.Person;
import atosWebProjectRPretto.models.ToLogin;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {
	
	private ToLogin toLogin;
	public String token;
	
	@PostConstruct
	public void init() {
		toLogin = new ToLogin();
	}
	
	public String postAuthenticate(ToLogin login) {
		Client c = Client.create();
		Gson gson = new Gson();
		WebResource wr = c.resource("http://localhost:8080/authenticate");
		ClientResponse response = wr.type("application/json")
		           .post(ClientResponse.class, gson.toJson(login));
		
		if (response.getStatus() != 200) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Erro ao Logar, verifique as credenciais");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

        }
		setToken(response.getEntity(String.class));
		return("Products");
	}



	public ToLogin getToLogin() {
		return toLogin;
	}

	public void setToLogin(ToLogin toLogin) {
		this.toLogin = toLogin;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

	

}
