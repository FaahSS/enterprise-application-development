package br.com.fiap.bo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraBO extends Remote {
	int somar(int n1, int n2) throws RemoteException;
	
}
