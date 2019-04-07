package jp.imanaga.demo.spring.mvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoExceptionHandlerAdvice {

	@Autowired
	MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> requestBodyBindException(MethodArgumentNotValidException ex) {
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			// fieldErrorには１）検証アノテーションクラス情報、２）検証アノテーションに設定されている属性情報（アスキー文字列順）が設定されている。
			System.out.println(messageSource.getMessage(fieldError, Locale.getDefault()));
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
