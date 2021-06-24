package co.ao.mfdesenvolvimento.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.ao.mfdesenvolvimento.domain.Cliente;
import co.ao.mfdesenvolvimento.domain.enums.TipoCliente;
import co.ao.mfdesenvolvimento.dto.ClienteNewDTO;
import co.ao.mfdesenvolvimento.repositories.ClienteRepository;
import co.ao.mfdesenvolvimento.resources.exception.FieldsMessage;
import co.ao.mfdesenvolvimento.services.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldsMessage> list = new ArrayList<>();

		if(objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldsMessage("cpfOuCnpj","CPF Inválido"));
		}
		
		if(objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldsMessage("cpfOuCnpj", "CNPJ Invalido"));
		}
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		if(aux !=null) {
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
