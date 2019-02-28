package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class VeiculoDAOImpl {
EntityManager em;
	
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
		
	}

	public void atualizar(Veiculo veiculo) {
		em.merge(veiculo);
		
	}

	public void remover(int codigo) throws CodigoInexistenteException {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if(veiculo == null) {
			throw new CodigoInexistenteException();
		}
		em.remove(veiculo);
		
	}

	public Veiculo pesquisar(int codigo) {
		return em.find(Veiculo.class, codigo);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
