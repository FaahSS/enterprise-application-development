package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.entity.Transporte;

public class TransporteDAOImpl extends GenericDAOImpl<Transporte,Integer> implements TransporteDAO{

	public TransporteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Transporte> pesquisar() {
		//criar a query com jpql
		TypedQuery<Transporte> query =
			em.createQuery("from Transporte",Transporte.class);
		//executar a query
		return query.getResultList();
	}

	@Override
	public List<Transporte> pesquisarPorEmpresa(String nome) {
		//Criar a TypedQuery
		TypedQuery<Transporte> query = em.createQuery(
			"from Transporte t where t.empresa = :e",
			Transporte.class);
		//passar o parametro para a query
		query.setParameter("e", nome);
		//Executar a TypedQuery
		return query.getResultList();
	}

}