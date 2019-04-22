package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTeste {

	private static PacoteDAO pacoteDao;
	private static TransporteDAO transporteDao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		pacoteDao = new PacoteDAOImpl(em);
		transporteDao = new TransporteDAOImpl(em);
	}
	
	@Test
	void pesquisarPorDataTeste() {
		
		Calendar inicio = new GregorianCalendar(2017,Calendar.JANUARY,1);
		Calendar fim = new GregorianCalendar(2018,Calendar.JANUARY,1);
		
		List<Pacote> lista = pacoteDao.buscarPorDatas(inicio, fim);
		
		for (Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(inicio) &&
					pacote.getDataSaida().before(fim));
		}
		
	}
	
	@Test
	void pesquisarPorTransporteTeste() {
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> lista = pacoteDao.pesquisar(transporte);
		
		for (Pacote pacote : lista) {
			assertEquals(1, pacote.getTransporte().getId());
		}
		
	}
	
	@Test
	void somarPorPrecoTransporteTeste() {
		Transporte transporte = transporteDao.pesquisar(1);
		double soma = pacoteDao.somaPrecoPorTransporte(transporte);
		assertEquals(4300, soma);
	}
	
	@Test
	void buscarPorPrecoTeste() {
		List<Pacote> lista = pacoteDao.buscarPorPreco(1000);
		for(Pacote pacote : lista) {
		assertTrue(pacote.getPreco() < 1000);
		}
	}
	

}
