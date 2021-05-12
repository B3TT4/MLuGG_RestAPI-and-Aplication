package atosWebProjectRPretto.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.HeaderParam;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import atosWebProjectRPretto.models.Product;



@ManagedBean(name="productBean")
@RequestScoped
public class ProductBean {
	
	private Product product;
	private int productId;
	private String token;


	@PostConstruct
	public void init() {
	    product = new Product();
	}
	
	
	public List<Product> getProductsAPI() {
		//JsonObject toToken = new Gson().fromJson(token, JsonObject.class);
		//String value = "Bearer " + toToken.get("token").toString().substring(1);
		//value = StringUtils.chop(value);
		//System.out.println(value);
		
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Products/listProducts");
		//wr.header(value, "Authorization");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Product>>(){}.getType());
		
	}
	
	public void setExcludeProductAPI(int productId) {
		Client c = Client.create();
		WebResource wr = c.resource(
				"http://localhost:8080/Products/deleteProduct"+productId);
		        wr.delete();
	}
	
	public String getProduct(Product product) {
	      this.product =  product; 
	      return "AlterateProduct";
	   }
	
	public String setAlterateProductAPI(Product product) {
		Client c = Client.create();
		Gson gson = new Gson();
		int productId = product.getId();
		WebResource wr = c.resource(
				"http://localhost:8080/Products/listProduct/alterate"+productId);
		wr.type("application/json").accept("application/json")
        .put(gson.toJson(product));
		return "Products";
	}
	
	public String setSaveProductAPI(Product product) {
		Client c = Client.create();
		Gson gson = new Gson();
		WebResource wr = c.resource(
				"http://localhost:8080/Products/registerProduct");
		wr.type("application/json").accept("application/json")
        .post(gson.toJson(product));
		return "Products";
	}

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
