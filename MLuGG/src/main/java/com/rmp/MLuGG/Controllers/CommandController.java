package com.rmp.MLuGG.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rmp.MLuGG.Models.Command;
import com.rmp.MLuGG.Repositories.CommandRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/Command")
public class CommandController {
	
	@Autowired
	private CommandRepository commandRepository;
	
	
	@ApiOperation(value = "Cadastra novo comando", response = Iterable.class, tags = "CommandMLuGG")
	@PostMapping("/registerCommand")
	@ResponseStatus(HttpStatus.CREATED)
	public Command postCommand(@RequestBody Command command){
		return commandRepository.save(command);
	}
	
	@ApiOperation(value = "Retorna todos os comandos", response = Iterable.class, tags = "CommandMLuGG")
	@GetMapping("/listCommands")
	public List<Command> getCommands(){
		return commandRepository.findAll();
	}

}
