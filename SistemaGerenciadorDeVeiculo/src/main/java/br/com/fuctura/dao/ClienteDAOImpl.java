package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fuctura.entidade.Cliente;

public class ClienteDAOImpl implements IClienteDAO {

	@Override
	public void salvar(Connection conn, Cliente c) {

		try {

			String comandoInsert = "insert into cliente ( nome, cpf, celular )\r\n" + "values (?, ?, ?);";

			PreparedStatement psmt = conn.prepareStatement(comandoInsert);

			psmt.setString(1, c.getNome());
			psmt.setString(3, c.getCelular());
			psmt.setString(2, c.getCpf());

			psmt.execute(); // play

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Connection conn, Cliente c) {
		// delete from cliente where codigo = ?

		try {

			String comandoDelete = "delete from cliente where codigo = ?";

			PreparedStatement psmt = conn.prepareStatement(comandoDelete);

			psmt.setInt(1, c.getCodigo());

			psmt.execute(); // play

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
