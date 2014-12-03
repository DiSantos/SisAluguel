package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import br.com.tap.negocio.Roupa;
import br.com.tap.negocio.Telefone;

/*Criado a classe "Roupa", Projeto TAP P2 2014.2 Prof Allan

 Criada as classes:
 - Roupa,
 - RepositorioRoupa

 A Interface 
 - IRepositorioRoupa

 //Adicionar campo, "codigoRoupa" na tabela do banco
 * DELETAR ISSO DEPOIS
 */
public class RepositorioRoupa implements IRepositorioRoupa {
	private Connection conexao = null;

	public RepositorioRoupa() throws Exception {
		this.conexao = SingletonConexaoDB.getInstance().conectar();
	}

	@Override
	public void inserirRoupa(Roupa novaRoupa) throws Exception {
		if (novaRoupa != null) {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				String sql;
				sql = "INSERT INTO Roupa()  VALUES(?,?,?)";

				pstm = this.conexao.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				pstm.setLong(1, novaRoupa.getCodigoRoupa());
				pstm.setString(2, novaRoupa.getDescricao());
				pstm.setDouble(3, novaRoupa.getValor());

				pstm.executeUpdate();

				rs = pstm.getGeneratedKeys();
				if (rs.next()) {
					int idRoupa = rs.getInt(1);
					novaRoupa.setIdRoupa(idRoupa);
				}

			} finally {

				if (pstm != null) {
					pstm.close();
				}
				if (rs != null) {
					rs.close();
				}
			}

		}
	}// fim do método inserir

	@Override
	public void atualizarRoupa(Roupa Roupa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerRoupa(long codRoupa) throws Exception {

		PreparedStatement pstm = null;
		try {
			String sql;
			sql = "DELETE FROM Roupa WHERE codigo_roupa = ?";
			pstm = this.conexao.prepareStatement(sql);
			pstm.setLong(1, codRoupa);
			pstm.executeUpdate();

		} finally {

			if (pstm != null) {
				pstm.close();
			}
		}
	}

	@Override
	public List<Roupa> listarRoupaPorNome(long codigoRoupa) {
		// TODO Auto-generated method stub
		return null;
	}

}
