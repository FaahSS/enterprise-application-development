package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//1-atributo estatico que será unico
	private static EntityManagerFactory fabrica;
	
	//2-criar o construtor privado
	private EntityManagerFactorySingleton() {}
	
	//3-metodo estatico que retorna a unica instancia
	public static EntityManagerFactory getInstance() {
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}
