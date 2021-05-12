package atosWebProjectRPretto.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import atosWebProjectRPretto.models.Person;



@ManagedBean(name="personBean")
@RequestScoped
public class PersonBean {
	
	private Person person;
	
	@PostConstruct
	public void init() {
		person = new Person();
	}
	
	public List<Person> getPersonsAPI() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Person/listPerson");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
		
	}
	
	public String setAlteratePersonAPI(Person person) {
		Client c = Client.create();
		Gson gson = new Gson();
		int personId = person.getId();
		WebResource wr = c.resource(
				"http://localhost:8080/Person/listPersons/"+personId);
		wr.type("application/json").accept("application/json")
        .put(gson.toJson(person));
		return "Registers";
	}
	
	public String setSavePersonAPI(Person person) {
		Client c = Client.create();
		Gson gson = new Gson();
		WebResource wr = c.resource(
				"http://localhost:8080/Person/registerPerson");
		wr.type("application/json").accept("application/json")
        .post(gson.toJson(person));
		return "Registers";
	}	
	
	public String getPersonToAlterate(Person person) {
	      this.person =  person; 
	      return "AlterateRegister";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	
	
}
