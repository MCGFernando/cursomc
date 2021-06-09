package co.ao.mfdesenvolvimento.services.exceptions;

import java.util.ArrayList;
import java.util.List;

import co.ao.mfdesenvolvimento.resources.exception.FieldsMessage;
import co.ao.mfdesenvolvimento.resources.exception.StandarcError;

public class ValidationError extends StandarcError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldsMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		
	}

	public ValidationError(Integer status, String msg, Long timestamp, List<FieldsMessage> list) {
		super(status, msg, timestamp);
		
	}

	public List<FieldsMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldsMessage(fieldName, message));
	}

	
	

}
