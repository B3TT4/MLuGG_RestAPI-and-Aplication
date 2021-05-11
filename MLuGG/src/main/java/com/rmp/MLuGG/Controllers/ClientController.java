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

import com.rmp.MLuGG.Models.Client;
import com.rmp.MLuGG.Models.Person;
import com.rmp.MLuGG.Models.Product;
import com.rmp.MLuGG.Repositories.ClientRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/Client")
public class ClientController {
	
	@Autowired	
	private ClientRepository clientRepository;
	
	
	@ApiOperation(value = "Cadastra novo cliente", response = Iterable.class, tags = "ClientMLuGG")
	@PostMapping("/registerClient")
	@ResponseStatus(HttpStatus.CREATED)
	public Client postClient(@RequestBody Client client){
		return clientRepository.save(client);
	}
	
	@ApiOperation(value = "Retorna todos os Clientes", response = Iterable.class, tags = "ClientMLuGG")
	@GetMapping("/listClients")
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	@ApiOperation(value = "Deleta Cliente", response = Iterable.class, tags = "ClientMLuGG")
	@DeleteMapping("/deleteClient{id}")
	public void deleteClient(@PathVariable Long id){
		clientRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Altera todo o Cliente pelo ID", response = Iterable.class, tags = "ClientMLuGG")
	@PutMapping("/listClient/alterate{id}")
	public Client updateClient(@RequestBody Client client, @PathVariable Long id) {
		Client cli = clientRepository.getOne(id);
		if(cli == null) {
			return null;
		}
		if(client.getName() != null) {
			cli.setName(client.getName());
		}
		if(client.getCity() != null) {
			cli.setCity(client.getCity());
		}
		if(client.getUf() != null) {
			cli.setUf(client.getUf());
		}
		if(client.getStreet() != null) {
			cli.setStreet(client.getStreet());
		}
		if(client.getComplement() != null) {
			cli.setComplement(client.getComplement());
		}
		if(client.getNumber() != null) {
			cli.setNumber(client.getNumber());
		}
		if(client.getPhonenumber() != null) {
			cli.setPhonenumber(client.getPhonenumber());
		}
		if(client.getCep() != null) {
			cli.setCep(client.getCep());
		}
		return clientRepository.save(cli);
	}
	
	@ApiOperation(value = "Busca um cliente pelo ID", response = Iterable.class, tags = "ClientMLuGG")
	@GetMapping("/listClient{id}")
	public Client getClient(@PathVariable Long id) {
		return clientRepository.getOne(id);
	}

}
