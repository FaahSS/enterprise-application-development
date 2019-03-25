package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl <T, K> implements GenericDAO<T, K>{
	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}
	
	@Override
	public void excluir(K id) throws CodigoInexistenteException{
		T entidade = pesquisar(id);
		em.remove(entidade);
	}
	
	@Override
	public T pesquisar(K id) throws CodigoInexistenteException{
		T entidade = em.find(clazz, id);
		if(entidade == null) {
			throw new CodigoInexistenteException();
		}
		return entidade;
	}
	
	public void commit() throws CommitException{
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
