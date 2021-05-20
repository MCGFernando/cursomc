package co.ao.mfdesenvolvimento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import co.ao.mfdesenvolvimento.domain.Categoria;
import co.ao.mfdesenvolvimento.repositories.CategoriaRepository;
import co.ao.mfdesenvolvimento.services.exceptions.DataIntegrityException;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Categoria.class.getName()
						)
				);
	}
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel exluir categoria com Productos cadastrados");
		}
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
