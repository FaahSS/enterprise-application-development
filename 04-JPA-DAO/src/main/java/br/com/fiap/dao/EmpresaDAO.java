package br.com.fiap.dao;

import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface EmpresaDAO {

	// Empresa ou void
	void cadastrar(Empresa empresa);

	void atualizar(Empresa empresa);

	void excluir(int codigo) throws CodigoInexistenteException;

	Empresa pesquisar(int codigo);

	void commit() throws CommitException;

}
