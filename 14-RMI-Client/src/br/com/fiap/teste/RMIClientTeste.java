package br.com.fiap.teste;

import java.rmi.Naming;

import br.com.fiap.bo.CalculadoraBO;

public class RMIClientTeste {
	public static void main(String[] args) throws Exception {
		//Chamar o método que está implementado no projeto 13
		CalculadoraBO bo = (CalculadoraBO) Naming.lookup("rmi://localhost:1234/churros");
		int soma = bo.somar(10, 10);
		System.out.println(soma);
	}

}
