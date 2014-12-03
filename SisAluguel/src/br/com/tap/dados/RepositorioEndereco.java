package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.tap.negocio.Endereco;

public class RepositorioEndereco implements IRepositorioEndereco {

	private Connection conexao = null;

	public RepositorioEndereco() throws Exception {
		this.conexao = SingletonConexaoDB.getInstance().conectar();
	}

	@Override
	public void inserirEndereco(Endereco novoEndereco) throws Exception {

		if (novoEndereco != null) {
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				try {

					String sql = "INSERT INTO Endereco(id_cli_fk, cep_end, bairro_end, numero_end, cidade_end, estado_end, complemento_end) VALUES(?,?,?,?,?,?,?)";
					pstm = this.conexao.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
					pstm.setInt(1, novoEndereco.getCliente().getIdCli());
					pstm.setString(2, novoEndereco.getCep());
					pstm.setString(3, novoEndereco.getBairro());
					pstm.setInt(4, novoEndereco.getNumero());
					pstm.setString(5, novoEndereco.getCidade());
					pstm.setString(6, novoEndereco.getEstado());
					pstm.setString(7, novoEndereco.getComplemento());

					pstm.executeUpdate();

					rs = pstm.getGeneratedKeys();
					if (rs.next()) {
						int idEnd = rs.getInt(1);
						novoEndereco.setIdEnd(idEnd);
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

	}// fim do método inserir

	@Override
	public void removerPorId(Integer id) throws Exception {

		if (id != null) {

			String sql = "DELETE FROM Endereco WHERE id_end=?";
			PreparedStatement pstm = null;

			try {

				try {
					pstm = this.conexao.prepareStatement(sql);
					pstm.setInt(1, id);
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

	}

	@Override
	public void atualizarEndereco(Endereco endereco) throws Exception {

		if (endereco != null) {

			String sql = "UPDATE Endereco SET cep_end=?, bairro_end=?, numero_end=?, cidade_end=?, estado_end=?, complemento_end=?, WHERE id_cli_fk=?";
			PreparedStatement pstm = null;

			try {
				try {
					pstm = this.conexao.prepareStatement(sql);

					pstm.setString(1, endereco.getCep());
					pstm.setString(2, endereco.getBairro());
					pstm.setInt(3, endereco.getNumero());
					pstm.setString(4, endereco.getCidade());
					pstm.setString(5, endereco.getEstado());
					pstm.setString(6, endereco.getComplemento());
					pstm.setInt(7, endereco.getCliente().getIdCli());
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
	}

	@Override
	public Endereco buscarPorIdCliente(Integer idCliente) throws Exception {

		if (idCliente != null) {

			String sql = "SELECT * FROM Endereco WHERE id_cli_fk=?";
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Endereco end = null;
			try {
				try {

					pstm = this.conexao.prepareStatement(sql);
					rs = pstm.executeQuery();

					if (rs.next()) {
						end = new Endereco();
						end.setIdEnd(rs.getInt(1));
						end.setCep(rs.getString(2));
						end.setBairro(rs.getString(3));
						end.setNumero(rs.getInt(4));
						end.setCidade(rs.getString(5));
						end.setEstado(rs.getString(6));
						end.setComplemento(rs.getString(7));
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

		return null;
	}

}
