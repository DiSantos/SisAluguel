package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.tap.negocio.Cliente;

public class RepositorioCliente implements IRepositorioCliente {

	private Connection conexao;

	public RepositorioCliente() throws Exception {

		this.conexao = SingletonConexaoDB.getInstance().conectar();
	}

	@Override
	public void inserirCliente(Cliente novoCliente) throws Exception {

		if (novoCliente != null) {
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				try {
					String sql = "INSERT INTO Cliente(cli_nome,cli_cpf,cli_email) VALUES(?,?,?)";
					pstm = this.conexao.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);

					pstm.setString(1, novoCliente.getNome());
					pstm.setString(2, novoCliente.getCpf());
					pstm.setString(3, novoCliente.getEmail());

					pstm.executeUpdate();

					rs = pstm.getGeneratedKeys();

					if (rs.next()) {
						int idCli = rs.getInt(1);
						novoCliente.setIdCli(idCli);
					}
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

	}

	@Override
	public void removerCliente(String cpf) throws Exception {

		if (cpf != null) {

			PreparedStatement pstm = null;
			try {
				try {

				} finally {
					if (pstm != null && !pstm.isClosed()) {
						pstm.close();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}

	}

	@Override
	public void alualizarCliente(Cliente cliente) throws Exception {

		if (cliente != null) {
			PreparedStatement pstm = null;

			try {
				try {

				} finally {
					if (pstm != null && !pstm.isClosed()) {
						pstm.close();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
	}

	@Override
	public Cliente buscarPorId(Integer id) throws Exception {

		if (id != null) {
			PreparedStatement pstm = null;
			try {
				try {

				} finally {
					if (pstm != null && !pstm.isClosed()) {
						pstm.close();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		return null;
	}

	@Override
	public List<Cliente> listarPorNome(String nome) throws Exception {

		if (nome != null) {
			PreparedStatement pstm = null;

			try {
				try {

				} finally {
					if (pstm != null && !pstm.isClosed()) {
						pstm.close();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		return null;
	}

	@Override
	public List<Cliente> listar() throws Exception {

		PreparedStatement pstm = null;

		try {
			try {

			} finally {
				if (pstm != null && !pstm.isClosed()) {
					pstm.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return null;
	}
}
