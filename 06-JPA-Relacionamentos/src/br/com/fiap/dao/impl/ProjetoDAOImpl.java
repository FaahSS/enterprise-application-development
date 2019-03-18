package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.entity.Projeto;

public class ProjetoDAOImpl extends GenericDAOImpl<Projeto, Integer> implements ProjetoDAO {
	public ProjetoDAOImpl(EntityManager em) {
		super(em);
	}
}
