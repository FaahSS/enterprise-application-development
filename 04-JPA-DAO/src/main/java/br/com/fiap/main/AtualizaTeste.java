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

public class AtualizaTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		Empresa empresa = new Empresa(1,"FIAP", new GregorianCalendar(2009, Calendar.MARCH, 12), Status.ATIVO, "123.987.123/0002-99");
		
		try {
			dao.atualizar(empresa);
			dao.commit();
			System.out.println("Atualizado com Sucesso!");
		} catch (CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao Atualizar!");
		}
		
		em.close();
		fabrica.close();
	}

}
