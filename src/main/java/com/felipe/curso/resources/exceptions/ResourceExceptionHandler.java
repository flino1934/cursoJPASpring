package com.felipe.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipe.curso.services.exceptions.DatabaseExceptions;
import com.felipe.curso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
//Vai interceptar as exceções e tratar um possivel erro
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	//Quando interceptar a exceção ela vai cair aqui
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Código não encontrado ";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DatabaseExceptions.class)
	//Quando interceptar a exceção ela vai cair aqui
	public ResponseEntity<StandardError> database(DatabaseExceptions e, HttpServletRequest request){
		String error = "Erro no banco de dados  ";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	

}
