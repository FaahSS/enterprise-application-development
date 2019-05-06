package br.com.fiap.bo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraBOImpl extends UnicastRemoteObject implements CalculadoraBO {

	public CalculadoraBOImpl() throws RemoteException {
		super();
	}

	@Override
	public int somar(int n1, int n2) throws RemoteException {
		System.out.println("Somando...");
		return n1+n2;
	}

}
