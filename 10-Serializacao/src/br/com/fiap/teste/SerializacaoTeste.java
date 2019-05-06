package br.com.fiap.teste;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.entity.Cliente;

public class SerializacaoTeste {
	public static void main(String[] args) throws Exception {
		//Serializar um objeto em um arquivo
		Cliente cliente = new Cliente("João", "12646446", 500);
		
		FileOutputStream file = new FileOutputStream("cliente.txt");
		ObjectOutputStream output = new ObjectOutputStream(file);
		
		output.writeObject(cliente);
		System.out.println("Serializando o objeto cliente!");
		
		output.close();
		file.close();
	}

}
