package co.ao.mfdesenvolvimento.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.ao.mfdesenvolvimento.domain.enums.TipoCliente;
import co.ao.mfdesenvolvimento.dto.ClienteNewDTO;
import co.ao.mfdesenvolvimento.resources.exception.FieldsMessage;
import co.ao.mfdesenvolvimento.services.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldsMessage> list = new ArrayList<>();

		if(objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldsMessage("cpfUoCnpj","CPF Inválido"));
		}
		
		if(objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldsMessage("cpfUoCnpj", "CNPJ Invalido"));
		}

		for (FieldsMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
