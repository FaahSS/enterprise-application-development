package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface VeiculoDAO {
	void cadastrar(Veiculo veiculo);

	void atualizar(Veiculo veiculo);

	void remover(int codigo) throws CodigoInexistenteException;

	Veiculo pesquisar(int codigo);

	void commit() throws CommitException;
}
