package br.com.fiap.teste;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fiap.bo.CalculadoraBOImpl;

public class RMIServerTeste {
	public static void main(String[] args) throws Exception {
		//publicar o objeto para o acesso remoto
		Registry registry = LocateRegistry.createRegistry(1234);
		registry.bind("churros", new CalculadoraBOImpl());
		System.out.println("Objeto publicado no server");
	}
}
