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
	public void removerClientePorId(Integer id) throws Exception {

		if (id != null) {

			PreparedStatement pstm = null;
			try {

				String sql = "DELETE FROM Cliente WHERE id_cli=?";
				pstm = this.conexao.prepareStatement(sql);

				pstm.setInt(1, id);
				pstm.executeUpdate();

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
					String sql = "UPDATE Cliente SET cli_nome=?,cli_cpf=?,cli_email=? WHERE id_cli=?";
					pstm = this.conexao.prepareStatement(sql);

					pstm.setString(1, cliente.getNome());
					pstm.setString(2, cliente.getCpf());
					pstm.setString(3, cliente.getEmail());

					pstm.executeUpdate();
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

		Cliente cliente = null;

		if (id != null) {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				try {

					String sql = "SELECT * FROM Cliente WHERE id_cli=?";
					pstm = this.conexao.prepareStatement(sql);
					pstm.setInt(1, id);

					rs = pstm.executeQuery();

					if (rs.next()) {
						cliente = new Cliente();
						cliente.setIdCli(id);
						cliente.setNome(rs.getString(2));
						cliente.setCpf(rs.getString(3));
						cliente.setEmail(rs.getString(4));
					}

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
		return cliente;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) throws Exception {

		Cliente cliente = null;

		if (cpf != null) {

			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				try {

					String sql = "SELECT * FROM Cliente WHERE cli_cpf=?";
					pstm = this.conexao.prepareStatement(sql);
					pstm.setString(1, cpf);
					rs = pstm.executeQuery();

					if (rs.next()) {
						cliente = new Cliente();
						cliente.setCpf(cpf);
						cliente.setNome(rs.getString(2));
						cliente.setEmail(rs.getString(3));
					}

				} finally {
					if (pstm != null) {
						pstm.close();
					}
					if (rs != null) {
						rs.close();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		return cliente;
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

	public static void main(String[] args) {

		try {
			RepositorioCliente r = new RepositorioCliente();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
