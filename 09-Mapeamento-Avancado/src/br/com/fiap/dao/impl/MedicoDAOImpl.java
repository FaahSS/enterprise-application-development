package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.entity.Medico;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Integer> implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

}
