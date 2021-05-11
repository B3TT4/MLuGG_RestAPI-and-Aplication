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


import com.rmp.MLuGG.Models.Person;
import com.rmp.MLuGG.Models.Product;
import com.rmp.MLuGG.Models.ServiceOn;

import com.rmp.MLuGG.Repositories.PersonRespository;
import com.rmp.MLuGG.Repositories.ProductRepository;
import com.rmp.MLuGG.Repositories.ServiceOnRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/Person")
public class PersonController {
	
	@Autowired	
	private PersonRespository personRepository;
		
	
	@ApiOperation(value = "Cadastra novo usuário", response = Iterable.class, tags = "UserMLuGG")
	@PostMapping("/registerPerson")
	@ResponseStatus(HttpStatus.CREATED)
	public Person postPerson(@RequestBody Person person){
		return personRepository.save(person);
	}
	
	@ApiOperation(value = "Retorna todos os usuários", response = Iterable.class, tags = "UserMLuGG")
	@GetMapping("/listPerson")
	public List<Person> getPersons(){
		return personRepository.findAll();
	}
	
		
	@ApiOperation(value = "Altera todo o usuário pelo ID", response = Iterable.class, tags = "UserMLuGG")
	@PutMapping("/listPersons/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
		Person us = personRepository.getOne(id);
		if(us == null) {
			return null;
		}
		us.setUsername(person.getUsername());
		return personRepository.save(us);
	}
		
	@ApiOperation(value = "Deleta Person", response = Iterable.class, tags = "UserMLuGG")
	@DeleteMapping("/deletePerson{id}")
	public void deleteUser(@PathVariable Long id){
		personRepository.deleteById(id);
	}
		
}
	
	


