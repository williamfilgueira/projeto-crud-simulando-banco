package org.serratec.com.backend.projeto03.utils;

import org.serratec.com.backend.projeto03.exceptions.NumeroNaoEncontrado;
import org.serratec.com.backend.projeto03.exceptions.NumeroRepetido;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControlller {

	@ExceptionHandler(NumeroNaoEncontrado.class)
	public ResponseEntity<String> tratarNumeroNaoEncontrado(NumeroNaoEncontrado exception){
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(NumeroRepetido.class)
	public ResponseEntity<String> tratarNumeroRepetido(NumeroRepetido exception){
		return ResponseEntity.badRequest()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(SaldoInsuficiente.class)
	public ResponseEntity<String> tratarSaldoInsuficiente(SaldoInsuficiente exception){
		return ResponseEntity.badRequest()
					.header("x-error-msg",exception.getMessage())
					.build();
	}
	
}
