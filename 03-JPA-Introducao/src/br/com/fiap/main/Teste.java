package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String[] args) {
		//Criar um gerenciador de entidades:
		//Primeiro cria a Fábrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Depois a fabrica cria os Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		em.close();
		fabrica.close();
	}

}
