package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.negocio.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {

	private Connection conexao = null;

	/*
	 * construtor: um objeto deve ser construído cada vez que chamamos a classe.
	 * E a responsabilidade de fazer é do construtor, ou seja o método
	 * construtor cria uma nova instancia do objeto RepositorioFuncionario.
	 */
	public RepositorioFuncionario() throws Exception {
		this.conexao = SingletonConexaoDB.getInstance().conectar();
	}

	@Override
	public void inserirFuncionario(Funcionario novoFuncionario)throws Exception {

		if (novoFuncionario != null) {
			String sql = "INSERT INTO Funcionario VALUES(?,?,?,?,?)";
			PreparedStatement pstm = null;
			try {

				pstm = this.conexao.prepareStatement(sql);
				pstm.setString(2, novoFuncionario.getCpf());
				pstm.setString(3, novoFuncionario.getNome());
				pstm.setString(4, novoFuncionario.getCtps());
				pstm.setDouble(5, novoFuncionario.getSalario());
				pstm.executeUpdate();

			} finally {
				SingletonConexaoDB.getInstance()
						.desconectar(this.conexao, pstm);
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

		if (cpf != null) {
			PreparedStatement pstm = null;

			try {
				this.conexao = SingletonConexaoDB.getInstance().conectar();
				String sql;
				sql = "DELETE FROM Funcionario WHERE fun_cpf=?";
				pstm = this.conexao.prepareStatement(sql);
				pstm.setString(1, cpf);
				pstm.executeUpdate();
			} finally {
				SingletonConexaoDB.getInstance()
						.desconectar(this.conexao, pstm);
			}
		}

	}// fim do método remover

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome) {
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario fun;

		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql;
			sql = "SELECT * FROM Funcionario WHERE fun_nome= " + nome;
			pstm = this.conexao.prepareStatement(sql);
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

		Funcionario fun1 = new Funcionario("78954200", "Paula Roberta",
				"78522", 590.96);
		try {
			RepositorioFuncionario rep = new RepositorioFuncionario();
			rep.inserirFuncionario(fun1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		/*
		 * RepositorioFuncionario reporFun = new RepositorioFuncionario();
		 * System.out.println(reporFun.listarFuncionarioPorNome("Diego"));
		 */
	}
}
