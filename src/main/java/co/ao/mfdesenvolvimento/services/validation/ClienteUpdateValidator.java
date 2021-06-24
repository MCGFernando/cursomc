package co.ao.mfdesenvolvimento.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import co.ao.mfdesenvolvimento.domain.Cliente;
import co.ao.mfdesenvolvimento.domain.enums.TipoCliente;
import co.ao.mfdesenvolvimento.dto.ClienteDTO;
import co.ao.mfdesenvolvimento.dto.ClienteNewDTO;
import co.ao.mfdesenvolvimento.repositories.ClienteRepository;
import co.ao.mfdesenvolvimento.resources.exception.FieldsMessage;
import co.ao.mfdesenvolvimento.services.utils.BR;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		List<FieldsMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		if(aux !=null && !aux.getId().equals(uriId)) {
			list.add(new FieldsMessage("email", "Email ja existe"));
		}
		

		for (FieldsMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
