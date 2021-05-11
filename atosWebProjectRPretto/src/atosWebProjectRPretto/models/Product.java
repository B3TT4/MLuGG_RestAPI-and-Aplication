package atosWebProjectRPretto.models;


public class Product {
	
	private Integer id;
	private String product;
	private String obs;
	private String state;
	private Float costperday;
	private Float costperhour;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Float getCostperday() {
		return costperday;
	}
	public void setCostperday(Float costperday) {
		this.costperday = costperday;
	}
	public Float getCostperhour() {
		return costperhour;
	}
	public void setCostperhour(Float costperhour) {
		this.costperhour = costperhour;
	}

}
