package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Funcionario;

public class FuncionarioDAOImpl extends GenericDAOImpl<Funcionario, Integer> implements FuncionarioDAO{

	public FuncionarioDAOImpl(EntityManager em) {
		super(em);
	}

}
