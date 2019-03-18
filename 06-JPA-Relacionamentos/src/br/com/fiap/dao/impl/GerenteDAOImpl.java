package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GerenteDAO;
import br.com.fiap.entity.Gerente;

public class GerenteDAOImpl extends GenericDAOImpl<Gerente, Integer> implements GerenteDAO {

	public GerenteDAOImpl(EntityManager em) {
		super(em);
	}
	
}
