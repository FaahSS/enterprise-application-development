package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	Cliente pesquisarPorCpf(String cpf);
	
	long contarPorEstado(String estado);
	
	List<Cliente> pesquisar();
	
	List<Cliente> pesquisar(String nome);
	
	List<Cliente> pesquisarPorEstado(String estado);
	
	List<Cliente> pesquisarPorDiaReserva(int dias);

	List<Cliente> buscar(String nome, String cidade);

	List<Cliente> pesquisarPorEstados(List<String> estados);
	
}

