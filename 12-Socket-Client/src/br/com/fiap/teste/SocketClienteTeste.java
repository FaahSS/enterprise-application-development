package br.com.fiap.teste;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.entity.Vingador;

public class SocketClienteTeste {
	public static void main(String[] args) throws Exception {
		//Enviar um objeto para o server
		Socket socket = new Socket("localhost", 1234);
		
		Vingador vingador = new Vingador ("Homem de Ferro", "Tony Stark", "Eu te amo 3000");
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		
		output.writeObject(vingador);
		
		System.out.println("Objeto enviado!");
		
		output.close();
		socket.close();
	}

}
