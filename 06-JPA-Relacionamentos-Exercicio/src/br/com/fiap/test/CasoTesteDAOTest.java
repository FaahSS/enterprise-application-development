package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

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
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CodigoInexistenteException;
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
			
			Sistema s1 = new Sistema("Sistema do Fah");
			
			casoTeste.setSistema(s1);
			
			Usuario u1 = new Usuario("Victor Yuki");
			Usuario u2 = new Usuario("Gabriel Matos");
			Usuario u3 = new Usuario("Lais Perini");
			Usuario u4 = new Usuario("Fabio Salgarella");
			
			List<Usuario> usuarios = new ArrayList<>();
			usuarios.add(u1);
			usuarios.add(u2);
			usuarios.add(u3);
			usuarios.add(u4);
			
			itemTeste.setUsuarios(usuarios);
			
			List<ItemTeste> itens = new ArrayList<>();
			itens.add(itemTeste);
			
			casoTeste.setItens(itens);
			
			casoDao.cadastrar(casoTeste);
			casoDao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			fail("Falha...");
		}
	}

	@Test
	void cadastro() {
		assertNotEquals(0, casoTeste.getCodigo());
		assertNotEquals(0, itemTeste.getCodigo());
		
	}
	
	@Test
	void pesquisa() {
		try {
			CasoTeste caso = casoDao.pesquisar(casoTeste.getCodigo());
			assertNotNull(caso);
			assertNotNull(caso.getSistema());
		}catch(CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}

}
