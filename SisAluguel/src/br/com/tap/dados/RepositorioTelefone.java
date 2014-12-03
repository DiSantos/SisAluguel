package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tap.negocio.Telefone;

public class RepositorioTelefone implements IRepositorioTelefone {

	private Connection conexao = null;

	public RepositorioTelefone() throws Exception {
		this.conexao = SingletonConexaoDB.getInstance().conectar();

	}

	@Override
	public void inserirTel(Telefone telefone) throws Exception {
		if (telefone != null) {

			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				try {
					String sql = "INSERT INTO Telefone(id_fk_cli,tel_numero,tel_operadora) VALUES(?,?,?)";
					pstm = this.conexao.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
					pstm.setInt(1, telefone.getCliente().getIdCli());
					pstm.setString(2, telefone.getNumero());
					pstm.setString(3, telefone.getOperadora());

					pstm.executeUpdate();

					rs = pstm.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						telefone.setIdTelefone(id);
						System.out.println(telefone.getIdTelefone());
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
	public void atualizarTel(Telefone telefone) throws Exception {

		String sql = "UPDATE Telefone SET tel_numeto=?, tel_operadora=? WHERE id_tel=?";
		PreparedStatement pstm = null;

		if (telefone != null) {

			try {
				try {
					pstm = this.conexao.prepareStatement(sql);
					pstm.setString(1, telefone.getNumero());
					pstm.setString(2, telefone.getOperadora());
					pstm.setInt(3, telefone.getIdTelefone());

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
	public void removerTel(Integer id) throws Exception {

		if (id != null) {

			String sql = "DELETE FROM Telefone WHERE id_tel=?";
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
	public List<Telefone> buscaPorNumero(String numero) throws Exception {

		List<Telefone> telefones = new ArrayList<Telefone>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Telefone telefone = null;
		if (numero != null) {

			String sql = "SELECT * FROM Telefone WHERE tel_numero=?";
			pstm = this.conexao.prepareStatement(sql);
			pstm.setString(1, numero);

			rs = pstm.executeQuery();
			while (rs.next()) {
				telefone = new Telefone();
				telefone.setIdTelefone(rs.getInt(1));
				telefone.setNumero(rs.getString(2));
				telefone.setOperadora(rs.getString(3));

				telefones.add(telefone);
			}

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

		return telefones;
	}

	@Override
	public List<Telefone> listarPorCliente(Integer idCliente) throws Exception {

		Telefone telefone = null;
		List<Telefone> telefones = new ArrayList<Telefone>();
		if (idCliente != null) {
			String sql = "SELECT * FROM Telefones WHERE id_fk_cli=?";
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				try {
					pstm = this.conexao.prepareStatement(sql);
					pstm.setInt(1, idCliente);
					rs = pstm.executeQuery();

					while (rs.next()) {
						telefone = new Telefone();
						telefone.setIdTelefone(rs.getInt(1));
						telefone.setNumero(rs.getString(2));
						telefone.setOperadora(rs.getString(3));

						telefones.add(telefone);
					}

				} finally {
					if (pstm != null && !pstm.isClosed()) {
						pstm.close();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return telefones;
	}
}
