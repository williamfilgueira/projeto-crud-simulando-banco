package org.serratec.com.backend.projeto03.exceptions;



public class SaldoInsuficiente extends Exception {

//	criando as exception
	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente() {
		super();
	}

	public SaldoInsuficiente(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaldoInsuficiente(String message, Throwable cause) {
		super(message, cause);
	}

	public SaldoInsuficiente(String message) {
		super(message);
	}

	public SaldoInsuficiente(Throwable cause) {
		super(cause);
	}
	
	
	
	
}
