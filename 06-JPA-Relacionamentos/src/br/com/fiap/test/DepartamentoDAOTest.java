package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.GerenteDAO;
import br.com.fiap.dao.impl.DepartamentoDAOImpl;
import br.com.fiap.dao.impl.GerenteDAOImpl;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Gerente;
import br.com.fiap.entity.Nivel;
import br.com.fiap.entity.Projeto;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class DepartamentoDAOTest {
	private static DepartamentoDAO depDao;
	private static GerenteDAO gerenteDao;
	
	//Método que executa antes de todos os testes
	@BeforeAll
	public static void inicializar(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		depDao = new DepartamentoDAOImpl(em);
		gerenteDao = new GerenteDAOImpl(em);
		
	}
	
	private Departamento departamento;
	private Gerente gerente;
	
	//Método que executa antes de cada teste
	@BeforeEach
	public void cadastrarAntesDosTestes() {
		try {
			gerente = new Gerente("Thiago Yamamoto", Nivel.SENIOR);
			departamento = new Departamento(gerente, "Enterprise Development", Status.ATIVO);
			
			Funcionario f1 = new Funcionario("Victor Yuki Stati", Calendar.getInstance(), 1000);
			Funcionario f2 = new Funcionario("Gabriel Matos Rodrigues", Calendar.getInstance(), 1000);
			
			departamento.addFuncionario(f1);
			departamento.addFuncionario(f2);
			
			Projeto p1 = new Projeto("Projeto Churros", Status.ATIVO, Calendar.getInstance(), new GregorianCalendar(2019, Calendar.OCTOBER, 10));
			Projeto p2 = new Projeto("Projeto AM", Status.ATIVO, Calendar.getInstance(), new GregorianCalendar(2019, Calendar.OCTOBER, 10));
			
			//associar os projetos no funcionário
			List<Projeto> projetos = new ArrayList<>();
			projetos.add(p1);
			projetos.add(p2);
			
			f1.setProjetos(projetos);
			
			//gerenteDao.cadastrar(gerente);
			depDao.cadastrar(departamento);
			depDao.commit();
		    
		}catch(Exception e){
			e.printStackTrace();
			fail("Errou...");
		}
	}
	
	
	@Test
	void cadastro() {
		assertNotEquals(0, gerente.getCodigo());
		assertNotEquals(0, departamento.getCodigo());
	}
	
	@Test
	void pesquisa() {
		try {
			Departamento pesquisa = depDao.pesquisar(departamento.getCodigo());
			assertNotNull(pesquisa);
			assertNotNull(pesquisa.getGerente());
		}catch(CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}
	

}
