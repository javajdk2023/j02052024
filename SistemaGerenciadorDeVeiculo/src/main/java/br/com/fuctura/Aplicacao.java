package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.fuctura.dao.ClienteDAOImpl;
import br.com.fuctura.dao.IClienteDAO;
import br.com.fuctura.entidade.Cliente;

public class Aplicacao {

	public static void main(String[] args) throws IOException {
		
		//Carregar arquivo do classpath
		InputStream input = Aplicacao
				.class
				.getClassLoader()
				.getResourceAsStream("config.properties");

		Properties prop = new Properties();

		// carregar arquivo de propriedades
		prop.load(input);

		try {
			//DriverManager.getConnection("", "", "");
			//DriverManager.getConnection(url, user, password);
			Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop);
			
			//Construir o menu com syso e scanner aqui na classe Aplicacao
			
			IClienteDAO daoCliente = new ClienteDAOImpl();
			
			Cliente cliente = new Cliente();
			
			cliente.setNome("Carlos");
			cliente.setCelular("81922222222");
			cliente.setCpf("12345678900");
			
			daoCliente.salvar(conn, cliente);
			
			Cliente cliente2 = new Cliente();
			cliente2.setCodigo(1);

			daoCliente.excluir(conn, cliente2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Conectado com sucesso!");
	}

}
