package br.com.fiap.exception;

public class CodigoInexistenteException extends Exception{
	
	public CodigoInexistenteException() {
		super();
	}

	public CodigoInexistenteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public CodigoInexistenteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CodigoInexistenteException(String arg0) {
		super(arg0);
	}

	public CodigoInexistenteException(Throwable arg0) {
		super(arg0);
	}
}
