package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO{

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

}
