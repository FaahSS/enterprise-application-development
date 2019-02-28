package br.com.fiap.exception;
@SuppressWarnings("all")
public class CodigoInexistenteException extends Exception {
	
	public CodigoInexistenteException() {
		super();
	}

	public CodigoInexistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CodigoInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodigoInexistenteException(String message) {
		super(message);
	}

	public CodigoInexistenteException(Throwable cause) {
		super(cause);
	}

}
