package co.ao.mfdesenvolvimento.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ao.mfdesenvolvimento.domain.Cliente;
import co.ao.mfdesenvolvimento.services.ClienteService;

@RestController	
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listar(){
		Cliente cat1 = new Cliente(1, "Informatica");
		Cliente cat2 = new Cliente(2, "Escritorio");
		List<Cliente> lst = new ArrayList<>();
		lst.add(cat1);
		lst.add(cat2);
		return lst;
	}*/
}
