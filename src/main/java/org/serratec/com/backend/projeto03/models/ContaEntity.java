package org.serratec.com.backend.projeto03.models;

public class ContaEntity {
	private Integer numero;
	private String titular;
	private Double saldo;
	
	
//	CONSTRUTOR
	public ContaEntity(Integer numero, String titular, Double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

//GET AND SETS
	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
//
	
}
