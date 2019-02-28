package br.com.fiap.dao;

import br.com.fiap.entity.Motorista;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface MotoristaDAO {
	void cadastrar(Motorista motorista);

	void atualizar(Motorista motorista);

	void remover(int codigo) throws CodigoInexistenteException;

	Motorista pesquisar(int codigo);

	void commit() throws CommitException;

}
