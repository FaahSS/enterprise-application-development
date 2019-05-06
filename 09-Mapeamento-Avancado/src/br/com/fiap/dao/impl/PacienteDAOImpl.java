package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Paciente;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{

	public PacienteDAOImpl(EntityManager em) {
		super(em);
	}

}
