package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public void inserirFuncionario(Funcionario novoFuncionario)
			throws Exception {

		if (novoFuncionario != null) {
			String sql = "INSERT INTO Funcionario VALUES(?,?,?,?,?)";
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				try {

					pstm = this.conexao.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
					pstm.setString(2, novoFuncionario.getCpf());
					pstm.setString(3, novoFuncionario.getNome());
					pstm.setString(4, novoFuncionario.getCtps());
					pstm.setDouble(5, novoFuncionario.getSalario());
					pstm.executeUpdate();

					rs = pstm.getGeneratedKeys();
					if (rs.next()) {
						int idFun = rs.getInt(1);
						novoFuncionario.setIdFun(idFun);
					}

				} finally {
					if (pstm != null) {
						pstm.close();
					}
					if (rs != null) {
						rs.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}

	}// fim do método inserir

	@Override
	public void atualizarFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario != null) {

			String sql = "UPDATE Funcionario SET fun_cpf=?, fun_nome=?, fun_ctps=?, fun_salario=? WHERE id=_fun=?";
			PreparedStatement pstm = null;
			try {

				try {
					pstm = this.conexao.prepareStatement(sql);
					pstm.setString(1, funcionario.getCpf());
					pstm.setString(2, funcionario.getNome());
					pstm.setString(3, funcionario.getCtps());
					pstm.setDouble(4, funcionario.getSalario());
					pstm.setInt(5, funcionario.getIdFun());
					pstm.executeUpdate();
				} finally {

					if (pstm != null && !pstm.isClosed()) {

						pstm.close();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e);
			}

		}
	}// fim do atualizar

	@Override
	public void removerFuncionario(String cpf) throws Exception {

		if (cpf != null) {
			PreparedStatement pstm = null;
			try {
				try {
					String sql;
					sql = "DELETE FROM Funcionario WHERE fun_cpf=?";
					pstm = this.conexao.prepareStatement(sql);
					pstm.setString(1, cpf);
					pstm.executeUpdate();
				} finally {
					if (pstm != null) {
						pstm.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
	}// fim do método remover

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome)
			throws Exception {
		List<Funcionario> funcionarios = new ArrayList<>();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			try {
				String sql;
				sql = "SELECT * FROM Funcionario WHERE fun_nome LIKE ?";
				pstm = this.conexao.prepareStatement(sql);

				pstm.setString(1, "%" + nome + "%");

				rs = pstm.executeQuery();

				while (rs.next()) {
					Funcionario fun = new Funcionario();
					fun.setCpf(rs.getString(1));
					fun.setCtps(rs.getString(2));
					fun.setNome(rs.getString(3));
					fun.setSalario(rs.getDouble(4));
					funcionarios.add(fun);

				}

			} finally {
				if (pstm != null && !pstm.isClosed()) {
					pstm.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return funcionarios;
	}

	public static void main(String[] args) {

		/*
		 * Funcionario fun1 = new Funcionario("78954996", "José Santos","78500",
		 * 590.96);
		 */

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			RepositorioFuncionario rep = new RepositorioFuncionario();
			// rep.inserirFuncionario(fun1);
			funcionarios = rep.listarFuncionarioPorNome("Santos");
			for (Funcionario f : funcionarios) {
				System.out.println(f);
			}
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
