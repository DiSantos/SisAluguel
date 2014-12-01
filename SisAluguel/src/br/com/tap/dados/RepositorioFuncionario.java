package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.tap.negocio.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	/*
	 * construtor: um objeto deve ser construído cada vez que chamamos a classe.
	 * E a responsabilidade de fazer é do construtor, ou seja o método
	 * construtor cria uma nova instancia do objeto RepositorioFuncionario.
	 */
	public RepositorioFuncionario() {

	}

	@Override
	public void inserirFuncionario(Funcionario novoFuncionario)
			throws Exception {

		if (novoFuncionario != null) {
			try {
				String sql = "INSERT INTO Funcionario VALUES(?,?,?,?,?)";
				this.con = SingletonConexaoDB.getInstance().conectar();
				this.pstm = this.con.prepareStatement(sql);
				this.pstm.setString(2, novoFuncionario.getCpf());
				this.pstm.setString(3, novoFuncionario.getNome());
				this.pstm.setString(4, novoFuncionario.getCtps());
				this.pstm.setDouble(5, novoFuncionario.getSalario());
				this.pstm.executeUpdate();

			} finally {
				SingletonConexaoDB.getInstance().desconectar();
			}
		}

	}// fim do método inserir

	@Override
	public void atualizarFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario != null) {
		}
	}// fim do atualizar

	@Override
	public void removerFuncionario(String cpf) throws Exception {
		try {
			if (cpf != null) {

				this.con = SingletonConexaoDB.getInstance().conectar();
				String sql;
				sql = "DELETE FROM Funcionario WHERE fun_cpf=" + cpf;
				this.pstm = this.con.prepareStatement(sql);
				this.pstm.executeUpdate();
			}
		} finally {
			SingletonConexaoDB.getInstance().desconectar();
			if (this.pstm != null) {
				this.pstm.close();
			}
		}
	}

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome) {
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario fun;
		try {
			this.con = SingletonConexaoDB.getInstance().conectar();
			String sql;
			sql = "SELECT * FROM Funcionario WHERE fun_nome= " + nome;
			this.pstm = this.con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				fun = new Funcionario();
				fun.setCpf(rs.getString(1));
				fun.setCtps(rs.getString(2));
				fun.setNome(rs.getString(3));
				fun.setSalario(rs.getDouble(4));
				funcionarios.add(fun);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionarios;
	}

	public static void main(String[] args) {
		/*
		 * try { Funcionario funcionario = new Funcionario();
		 * funcionario.setCpf("1234"); funcionario.setCtps("45568");
		 * funcionario.setNome("WALTSON"); funcionario.setSalario(2325);
		 * 
		 * RepositorioFuncionario reporFun = new RepositorioFuncionario();
		 * 
		 * reporFun.inserirFuncionario(funcionario); } catch (Exception e) {
		 * 
		 * }
		 */

		/*
		 * try { RepositorioFuncionario reporFun = new RepositorioFuncionario();
		 * reporFun.removerFuncionario("1234"); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		RepositorioFuncionario reporFun = new RepositorioFuncionario();
		System.out.println(reporFun.listarFuncionarioPorNome("Diego"));
	}
}
