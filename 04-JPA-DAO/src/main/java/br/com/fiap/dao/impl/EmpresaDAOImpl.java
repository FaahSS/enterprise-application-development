package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class EmpresaDAOImpl implements EmpresaDAO {
	
	//A Factory vai em quem vai usar 
	private EntityManager em;
	
	//Construtor
	public EmpresaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	//Métodos
	public void cadastrar(Empresa empresa) {
		em.persist(empresa);
	}

	public void atualizar(Empresa empresa) {
		em.merge(empresa);
	}

	public void excluir(int codigo) throws CodigoInexistenteException {
		Empresa e = em.find(Empresa.class, codigo);
		if (e == null) {
			throw new CodigoInexistenteException();
		} else {
		em.remove(e);
		}
	}

	public Empresa pesquisar(int codigo) {
		Empresa e = em.find(Empresa.class, codigo);
		return e;
	}
	
	public void commit() throws CommitException {
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
	
	

}
