package atosWebProjectRPretto.models;


public class ServicesOn {
	
	private Integer id;
	private String serviceon;
	private String obs;
	private String dayinn;
	private String dayout;
	private ClientM client;
	private Float cost;
	private String location;
	private Product product;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceon() {
		return serviceon;
	}
	public void setServiceon(String serviceon) {
		this.serviceon = serviceon;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getDayinn() {
		return dayinn;
	}
	public void setDayinn(String dayinn) {
		this.dayinn = dayinn;
	}
	public String getDayout() {
		return dayout;
	}
	public void setDayout(String dayout) {
		this.dayout = dayout;
	}
	public ClientM getClient() {
		return client;
	}
	public void setClient(ClientM client) {
		this.client = client;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
