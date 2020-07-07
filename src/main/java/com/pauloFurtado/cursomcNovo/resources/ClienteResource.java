package com.pauloFurtado.cursomcNovo.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pauloFurtado.cursomcNovo.Services.ClienteService;
import com.pauloFurtado.cursomcNovo.domain.Cliente;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Optional<Cliente> obj = service.buscar(id);
		return ResponseEntity.ok(obj);
		
		
	}
}
