package org.serratec.com.backend.projeto03.controllers;

import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.NumeroNaoEncontrado;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.serratec.com.backend.projeto03.models.OperacaoEntity;
import org.serratec.com.backend.projeto03.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta") // criando endpoint
public class Controller {

	@Autowired
	ApiService service;

//retorna lista completa
	@GetMapping
	public ResponseEntity<List<ContaEntity>> readAll() {
		return new ResponseEntity<List<ContaEntity>>(service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/{numero}") // Response classe usada para retornar status.
	public ResponseEntity<ContaEntity> readCount(@PathVariable Integer numero) {
		return new ResponseEntity<ContaEntity>(service.readCount(numero), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ContaEntity> create(@RequestBody ContaEntity conta) {
		return new ResponseEntity<ContaEntity>(service.create(conta), HttpStatus.OK);
	}

	@DeleteMapping("/{numero}")
	public ResponseEntity<String> delete(@PathVariable Integer numero) throws NumeroNaoEncontrado {
		return new ResponseEntity<String>(service.delete(numero), HttpStatus.OK);
	}

	@PutMapping("/{numero}")
	public ResponseEntity<ContaEntity> update(@RequestBody ContaEntity conta, @PathVariable Integer numero) throws NumeroNaoEncontrado {
		return new ResponseEntity<ContaEntity>(service.update(conta, numero), HttpStatus.OK);
	}

	@PostMapping("/{numero}")
	public ResponseEntity<String> atualizaSaldo(@PathVariable Integer numero, @RequestBody OperacaoEntity operacao)
			throws SaldoInsuficiente, NumeroNaoEncontrado {
		return new ResponseEntity<String>(service.atualizaSaldo(numero, operacao), HttpStatus.OK);
	}

}
