package br.com.marney.springexercises.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marney.springexercises.model.entities.Client;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {
	
	@GetMapping(path = "/any")
	public Client returnClient() {
		return new Client(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Client getClientById1(@PathVariable int id) {
		return new Client(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping
	public Client getClientById2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Client(id, "João Augusto", "111.222.333-00");
	}

}
