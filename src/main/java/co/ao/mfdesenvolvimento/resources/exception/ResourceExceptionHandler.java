package co.ao.mfdesenvolvimento.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.ao.mfdesenvolvimento.services.exceptions.DataIntegrityException;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarcError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		StandarcError err = new StandarcError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandarcError> DataIntegrity(DataIntegrityException e, HttpServletRequest req){
		StandarcError err = new StandarcError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
