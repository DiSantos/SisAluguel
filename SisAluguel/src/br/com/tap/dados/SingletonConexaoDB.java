package br.com.tap.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Padrão Singleton*/
public class SingletonConexaoDB {

	public Connection connection = null;
	private String driverDeConexao = "";
	private String url = "";
	private String nomeBanco;

	/* variável de controle de instância */
	private static SingletonConexaoDB instanciaSingleton;

	private SingletonConexaoDB() {

		this.nomeBanco = "dbaluguel.sqlite";
		this.driverDeConexao = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:" + nomeBanco;

	}

	public static SingletonConexaoDB getInstance() {

		if (instanciaSingleton == null) {
			instanciaSingleton = new SingletonConexaoDB();
		}
		return instanciaSingleton;
	}

	public Connection conectar() throws Exception {

		/*
		 * A declaração "Class.forName" carrega e registra a classe que
		 * implementa o JDBC driver (neste caso será a JDBC do sqlite).
		 */
		Class.forName(driverDeConexao);

		/*
		 * A declaração "DriverManager.getConnection" prorcura pelo driver
		 * registrado anteriormente. Se a classe não registrada ou não foi
		 * encontrada, a conexão não será estabelecida.
		 */
		connection = DriverManager.getConnection(url);
		System.out.print("Conectar");
		System.out.println("\nOpened database sucessfully!!!");

		return connection;
	}

	public void desconectar(Connection con) throws Exception {

		System.out.println("\nDesconectar");
		if (con != null) {
			con.close();
		}
	}

	public void desconectar(Connection con, PreparedStatement pstm)
			throws Exception {

		System.out.println("\nDesconectar");
		if (pstm != null && !pstm.isClosed()) {
			pstm.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public void desconectar(Connection con, PreparedStatement pstm, ResultSet rs)
			throws Exception {
		System.out.println("\nDesconectar");
		if (pstm != null && !pstm.isClosed()) {
			pstm.close();
		}
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
