package br.com.fuctura.dao;

import java.sql.Connection;

import br.com.fuctura.entidade.Cliente;

public interface IClienteDAO {
	void salvar(Connection conn, Cliente c);
	void excluir(Connection conn, Cliente c);
}
