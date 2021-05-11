package atosWebProjectRPretto.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import atosWebProjectRPretto.models.Product;


@ManagedBean(name="productBean")
@RequestScoped
public class ProductBean {
	
	private Product product;
	private int productId;
	
	@PostConstruct
	public void init() {
	    product = new Product();
	}
	
	public List<Product> getProductsAPI() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Products/listProducts");
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
