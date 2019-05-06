package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.ConsultaPK;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPK> implements ConsultaDAO{

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}

}
