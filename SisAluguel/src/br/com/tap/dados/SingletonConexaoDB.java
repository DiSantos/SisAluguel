package br.com.tap.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Padr�o Singleton*/
public class SingletonConexaoDB {

	public Connection connection = null;
	private String driverDeConexao = "";
	private String url = "";
	private String nomeBanco;

	/* vari�vel de controle de inst�ncia */
	private static SingletonConexaoDB instanciaSingleton;

	private SingletonConexaoDB() {

		this.nomeBanco = "dbaluguel.sqlite";
		this.driverDeConexao = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:" + nomeBanco;

	}

	public static synchronized SingletonConexaoDB getInstance() {

		if (instanciaSingleton == null) {
			instanciaSingleton = new SingletonConexaoDB();
		}
		return instanciaSingleton;
	}

	public Connection conectar() throws Exception {
		

			/*
			 * A declara��o "Class.forName" carrega e registra a classe que
			 * implementa o JDBC driver (neste caso ser� a JDBC do sqlite).
			 */
			Class.forName(driverDeConexao);

			/*
			 * A declara��o "DriverManager.getConnection" prorcura pelo driver
			 * registrado anteriormente. Se a classe n�o registrada ou n�o foi
			 * encontrada, a conex�o n�o ser� estabelecida.
			 */
			connection = DriverManager.getConnection(url);
			System.out.print("Conectar");
			System.out.println("\nOpened database sucessfully!!!");


		return connection;
	}
	
	public void desconectar() throws Exception{
		
		System.out.println("\nDesconectar");
			if (connection != null) {
				connection.close();
			}

		
	}
	
	public static void main(String[] args) {
     try {
        Connection c = SingletonConexaoDB.getInstance().conectar();
    	PreparedStatement pstm = null;
    	String sql = "";
    	sql = "INSERT INTO Funcionario(fun_nome, fun_cpf, fun_ctps, fun_data_nasc) VALUES('Jos�', 01234567891, '70.88.abc', '21/11/1987')";
		pstm = c.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			SingletonConexaoDB.getInstance().desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
	}
	
	

}
