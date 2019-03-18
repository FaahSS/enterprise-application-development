package br.com.fiap.dao;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO <T,K>{
	void cadastrar(T entidade);
	void atualizar(T entidade);
	void excluir (K codigo) throws CodigoInexistenteException;
	T pesquisar (K codigo) throws CodigoInexistenteException;
	void commit() throws CommitException;

}
