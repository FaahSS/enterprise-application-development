package br.com.fiap.exception;

public class CommitException extends Exception {

	public CommitException() {
		super();
	}

	public CommitException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CommitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommitException(String arg0) {
		super(arg0);
	}

	public CommitException(Throwable arg0) {
		super(arg0);
	}
	
}
