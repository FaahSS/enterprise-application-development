package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Motorista;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class MotoristaDAOImpl {
	EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Motorista motorista) {
		em.persist(motorista);
	}

	public void atualizar(Motorista motorista) {
		em.merge(motorista);
	}

	public void remover(int codigo) throws CodigoInexistenteException {
		Motorista motorista = em.find(Motorista.class, codigo);
		if (motorista == null) {
			throw new CodigoInexistenteException();
		}
		em.remove(motorista);
	}

	public Motorista pesquisar(int codigo) {
		return em.find(Motorista.class, codigo);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
