package com.rmp.MLuGG.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rmp.MLuGG.Models.Product;
import com.rmp.MLuGG.Repositories.PersonRespository;
import com.rmp.MLuGG.Repositories.ProductRepository;
import com.rmp.MLuGG.Repositories.ServiceOnRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/Products")
public class ProductsController {
	
	@Autowired	
	private PersonRespository personRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ServiceOnRepository serviceOnRepository;
	
	@ApiOperation(value = "Cadastra novo Produto", response = Iterable.class, tags = "ProductMLuGG")
	@PostMapping("/registerProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public Product postProduct(@RequestBody Product product){
		return productRepository.save(product);
	}
	
	@ApiOperation(value = "Deleta Produto", response = Iterable.class, tags = "ProductMLuGG")
	@DeleteMapping("/deleteProduct{id}")
	public void deleteProduct(@PathVariable Long id){
		productRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Altera todo o produto pelo ID", response = Iterable.class, tags = "ProductMLuGG")
	@PutMapping("/listProduct/alterate{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
		Product pro = productRepository.getOne(id);
		if(pro == null) {
			return null;
		}
		if(product.getCostperday() != null) {
			pro.setCostperday(product.getCostperday());
		}
		if(product.getCostperhour() != null) {
			pro.setCostperhour(product.getCostperhour());
		}
		if(product.getObs() != null) {
			pro.setObs(product.getObs());
		}
		if(product.getProduct() != null) {
			pro.setProduct(product.getProduct());
		}
		if(product.getState() != null) {
			pro.setState(product.getState());
		}
		return productRepository.save(pro);
	}
	
	@ApiOperation(value = "Retorna todos os produtos", response = Iterable.class, tags = "ProductMLuGG")
	@GetMapping("/listProducts")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}

}
