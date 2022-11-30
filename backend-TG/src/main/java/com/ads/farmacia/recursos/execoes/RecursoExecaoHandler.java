package com.ads.farmacia.recursos.execoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@ControllerAdvice
public class RecursoExecaoHandler {

	@ExceptionHandler(EntidadeNaoEncontrada.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada (EntidadeNaoEncontrada e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(IntegridadeDatabase.class)
	public ResponseEntity<ErroPadrao> database (IntegridadeDatabase e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Exeção do banco");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	
	
}
