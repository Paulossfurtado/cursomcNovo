package com.pauloFurtado.cursomcNovo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloFurtado.cursomcNovo.Exceptions.ObjectNotFoundException;
import com.pauloFurtado.cursomcNovo.Repositories.ClienteRepository;
import com.pauloFurtado.cursomcNovo.domain.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return Optional.of(obj.orElseThrow());

	}

}