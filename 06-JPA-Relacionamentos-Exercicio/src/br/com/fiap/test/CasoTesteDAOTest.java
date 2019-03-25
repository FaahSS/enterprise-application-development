package br.com.fiap.test;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.dao.ItemTesteDAO;
import br.com.fiap.dao.impl.CasoTesteDAOImpl;
import br.com.fiap.dao.impl.ItemTesteDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class CasoTesteDAOTest {
	private static CasoTesteDAO casoDao;
	private static ItemTesteDAO itemDao;
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		casoDao = new CasoTesteDAOImpl(em);
		itemDao = new ItemTesteDAOImpl(em);
	
	}
	private CasoTeste casoTeste;
	private ItemTeste itemTeste;
	
	@BeforeEach
	public void cadastrarAntesDosTeste() {
		try {
			casoTeste = new CasoTeste("Teste Cadastrar", "Esse Teste é para Cadastro");
			itemTeste = new ItemTeste("Um item essencial", casoTeste);
			
		}catch(Exception e) {
			e.printStackTrace();
			fail("Falha...");
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
