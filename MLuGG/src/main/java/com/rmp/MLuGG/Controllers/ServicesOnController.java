package com.rmp.MLuGG.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rmp.MLuGG.Models.Client;
import com.rmp.MLuGG.Models.Product;
import com.rmp.MLuGG.Models.ServiceOn;
import com.rmp.MLuGG.Repositories.ClientRepository;
import com.rmp.MLuGG.Repositories.PersonRespository;
import com.rmp.MLuGG.Repositories.ProductRepository;
import com.rmp.MLuGG.Repositories.ServiceOnRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/ServicesOn")
public class ServicesOnController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ServiceOnRepository serviceOnRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@ApiOperation(value = "Cadastra novo serviço", response = Iterable.class, tags = "ServiceOnMLuGG")
	@PostMapping("/registerServiceOn/Product{idProduct}Client{idClient}")
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOn postServiceOn(@PathVariable Long idProduct, @PathVariable Long idClient, @RequestBody ServiceOn service){
		try {
			Optional<Product> product = productRepository.findById(idProduct);
			Optional<Client> client = clientRepository.findById(idClient);
			service.setClient(client.get());
			service.setProduct(product.get());
			return serviceOnRepository.save(service);
		}
			catch  (Exception e){
				return null;
			}
	}
	
	@ApiOperation(value = "Retorna todos os serviços", response = Iterable.class, tags = "ServiceOnMLuGG")
	@GetMapping("/listServicesOn")
	public List<ServiceOn> getServicesOn(){
		return serviceOnRepository.findAll();
	}
	
	@ApiOperation(value = "Altera todo o serviço pelo ID", response = Iterable.class, tags = "ServiceOnMLuGG")
	@PutMapping("/listService/{id}")
	public ServiceOn updateServiceOn(@RequestBody ServiceOn service, @PathVariable Long id) {
		ServiceOn serv = serviceOnRepository.getOne(id);
		if(serv == null) {
			return null;
		}
		if(service.getObs() != null) {
			serv.setObs(service.getObs());
		}
		if(service.getServiceon() != null) {
			serv.setServiceon(service.getServiceon());
		}
		if(service.getDayinn() != null) {
			serv.setDayinn(service.getDayinn());
		}
		if(service.getDayout() != null) {
			serv.setDayout(service.getDayout());
		}
		if(service.getClient() != null) {
			serv.setClient(service.getClient());
		}
		if(service.getCost() != null) {
			serv.setCost(service.getCost());
		}
		if(service.getLocation() != null) {
			serv.setLocation(service.getLocation());
		}
		if(service.getProduct() != null) {
			serv.setProduct(service.getProduct());
		}
		return serviceOnRepository.save(serv);
	}
	
	@ApiOperation(value = "Deleta Serviço", response = Iterable.class, tags = "ServiceOnMLuGG")
	@DeleteMapping("/deleteService{id}")
	public void deleteService(@PathVariable Long id){
		serviceOnRepository.deleteById(id);
	}

}
