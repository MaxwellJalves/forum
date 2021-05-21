package br.com.alura.forum.config.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.forum.controller.dto.ExceptionHablerDTO;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
@Autowired
private MessageSource msg;
@ResponseStatus(code=HttpStatus.BAD_REQUEST)	
@ExceptionHandler(MethodArgumentNotValidException.class)	
public List<ExceptionHablerDTO> getErro(MethodArgumentNotValidException exception){
	List<ExceptionHablerDTO> dto = new ArrayList<>();
	List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
	fieldError.forEach( e ->{
		String m =msg.getMessage(e, LocaleContextHolder.getLocale());
		ExceptionHablerDTO erro = new ExceptionHablerDTO(e.getField(),m);
		dto.add(erro);
	});
	
	return dto;
}

}
