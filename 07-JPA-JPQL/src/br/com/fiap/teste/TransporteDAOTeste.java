package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Transporte;

class TransporteDAOTeste {

	private static TransporteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		dao = new TransporteDAOImpl(em);
	}
	
	@Test
	void pesquisarPorEmpresa() {
		List<Transporte> lista = dao.pesquisarPorEmpresa("GOL");
		assertEquals(1, lista.size());
	}
	
	@Test
	void pesquisa() {
		List<Transporte> lista = dao.pesquisar();
		assertEquals(3, lista.size());
	}
}
