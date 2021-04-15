package co.ao.mfdesenvolvimento.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ao.mfdesenvolvimento.domain.Categoria;

@RestController	
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		List<Categoria> lst = new ArrayList<>();
		lst.add(cat1);
		lst.add(cat2);
		return lst;
	}
}
