package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ao.mfdesenvolvimento.domain.Pedido;
import co.ao.mfdesenvolvimento.repositories.PedidoRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Pedido.class.getName()
						)
				);
	}
}
