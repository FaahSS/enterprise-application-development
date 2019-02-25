package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitException;

public class CadastroTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		//Cadastrar uma Empresa
		
		
		Empresa e = new Empresa("FaahSS Productions", new GregorianCalendar(2010, Calendar.FEBRUARY, 21), Status.ATIVO, "123.645.321/0001-89");
		
		try {
			dao.cadastrar(e);
			dao.commit();
			System.out.println("Cadastrado com Sucesso!");
		} catch (CommitException e1) {
			e1.printStackTrace();
			System.err.println("Erro ao Cadastrar!");
		}
		
		em.close();
		fabrica.close();
	}
}
