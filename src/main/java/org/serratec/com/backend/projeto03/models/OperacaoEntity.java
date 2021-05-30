package org.serratec.com.backend.projeto03.models;

public class OperacaoEntity {

	private TipoEnum tipo;
	private Double valor;
	
//	construtor
	public OperacaoEntity(TipoEnum tipo, Double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}
// get and sets

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
