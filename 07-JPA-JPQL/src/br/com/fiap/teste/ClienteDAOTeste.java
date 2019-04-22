package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTeste {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton
							.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void pesquisarPorEstados() {
		
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("BA");
		
		List<Cliente> lista = dao.pesquisarPorEstados(estados);
		
		for (Cliente cliente : lista) {
			assertTrue(estados.contains(cliente.getEndereco()
											.getCidade().getUf()));
		}
		
	}
	
	@Test
	void pesquisarPorNomeCidadeTest() {
		
		List<Cliente> lista = dao.buscar("Lea","Lon");
		
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Lea") &&
				cliente.getEndereco().getCidade().getNome().contains("Lon"));
		}
		
	}
	
	@Test
	void pesquisarPorDiasReserva() {
		List<Cliente> lista = dao.pesquisarPorDiaReserva(10);
		assertEquals(4, lista.size());
	}
	
	@Test
	void pesquisarPorEstadoTeste() {
		List<Cliente> lista = dao.pesquisarPorEstado("BA");
		
		for (Cliente cliente : lista) {
			assertEquals("BA", cliente.getEndereco().
					getCidade().getUf());
		}
		
	}
	
	@Test
	void pesquisarPorNomeTeste() {
		List<Cliente> lista = dao.pesquisar("mAr");
		//valida se a lista de cliente está correta
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Mar"));
		}
	}
	
	@Test
	void pesquisarTeste() {
		List<Cliente> lista = dao.pesquisar();
		assertEquals(10, lista.size());
	}
	
	@Test
	void contarPorEstado() {
		long qtd = dao.contarPorEstado("SP");
		assertEquals(1, qtd);
	}
	
	@Test
	void pesquidarPorCpfTeste() {
		Cliente c = dao.pesquisarPorCpf("98728018736");
		assertEquals("98728018736", c.getCpf());
	}

}

