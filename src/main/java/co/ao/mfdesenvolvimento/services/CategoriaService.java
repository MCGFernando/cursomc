package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ao.mfdesenvolvimento.domain.Categoria;
import co.ao.mfdesenvolvimento.repositories.CategoriaRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Categoria.class.getName()
						)
				);
	}
}
