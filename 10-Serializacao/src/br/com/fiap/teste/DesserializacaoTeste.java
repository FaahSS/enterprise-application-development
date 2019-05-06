package br.com.fiap.teste;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.fiap.entity.Cliente;

public class DesserializacaoTeste {
	public static void main(String[] args) throws Exception {
		//Ler o arquivo e recuperar o objeto cliente
		FileInputStream file = new FileInputStream("cliente.txt");
		ObjectInputStream input = new ObjectInputStream(file);
		
		Cliente cliente = (Cliente) input.readObject();
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCpf());
		System.out.println(cliente.getSaldo());
		
		input.close();
		file.close();
	}
}
