package com.pauloFurtado.cursomcNovo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloFurtado.cursomcNovo.Exceptions.ObjectNotFoundException;
import com.pauloFurtado.cursomcNovo.Repositories.CategoriaRepository;
import com.pauloFurtado.cursomcNovo.domain.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return Optional.ofNullable(obj.orElseThrow());

	}

}