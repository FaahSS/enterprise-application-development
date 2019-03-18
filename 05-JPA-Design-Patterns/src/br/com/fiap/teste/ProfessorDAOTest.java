package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {

	private static ProfessorDAO dao;
	private Professor prof;

	// Método que será exexutado antes de cada teste
	@BeforeEach
	public void arrange() {
		prof = new Professor("Parducci", null, "123.134.432-20");
		try {
			dao.cadastrar(prof);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
	}

	// Método que será excutado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfessorDAOImpl(em);
	}

	@Test
	@DisplayName("Teste de Cadastro de Professor com Sucesso")
	void cadastroTest() {
		// Arrange - Instanciar o Objeto
		// Act - Realizar a ação (chamar o método para teste)
		// Assert - Validar o resultado
		assertNotEquals(0, prof.getCodigo());

	}

	// Teste de atualizar
	@Test
	@DisplayName("Teste de Atualização de Professor com Sucesso")
	void atualizaTest() {
		try {
			dao.cadastrar(prof);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		// Atualizar o Professor
		Professor prof2 = new Professor(prof.getCodigo(), "Rafael", null, "321.123.543-20");
		try {
			dao.atualizar(prof2);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		// Assert - Validar o resultado
		// Pesquisa e valida se o valor foi alterado no banco
		try {
			Professor prof3 = dao.pesquisar(prof2.getCodigo());
			assertEquals("Rafael", prof2.getNome());
			assertEquals("321.123.543-20", prof2.getCpf());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
	}

	// Teste de Pesquisar
	@Test
	@DisplayName("Teste de Pesquisa de Professor com Sucesso")
	void pesquisaTest() {
		try {
			Professor pesquisa = dao.pesquisar(prof.getCodigo());
			assertNotNull(pesquisa);
			assertEquals("Parducci", pesquisa.getNome());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}

	// Teste de Excluir
	@Test
	@DisplayName("Teste de Exclusão de Professor com Sucesso")
	void deletaTest() {
		try {
			dao.excluir(prof.getCodigo());
			dao.commit();
		} catch (CodigoInexistenteException | CommitException e) {
			e.printStackTrace();
			fail("Falha no Teste...");
		}
		assertThrows(CodigoInexistenteException.class, () -> dao.pesquisar(prof.getCodigo()));
	}

}
