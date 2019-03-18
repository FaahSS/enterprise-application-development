package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.entity.Departamento;

public class DepartamentoDAOImpl extends GenericDAOImpl<Departamento, Integer> implements DepartamentoDAO{

	public DepartamentoDAOImpl(EntityManager em) {
		super(em);
	}
	

}
