package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.tap.negocio.Aluguel;

public class RepositorioAluguel implements IRepositorioAluguel {

	private Connection conexao;

	public RepositorioAluguel() throws Exception {

		this.conexao = SingletonConexaoDB.getInstance().conectar();
	}

	@Override
	public void inserirAluguel(Aluguel novoAluguel) throws Exception {
		if (novoAluguel != null) {

			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {

				String sql = "INSERT INTO Aluguel(id_cli_fk, id_fun_fk, valor_total_alug, data_saida_alug, data_entrega_alug)"
						+ "VALUES(?,?,?,?,?)";
				pstm = this.conexao.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
				pstm.setInt(1,novoAluguel.getIdCliente());
				pstm.setInt(2, novoAluguel.getIdFuncionario());
				pstm.setDouble(3, novoAluguel.getValorTotal());
				pstm.setString(4, novoAluguel.getDataSaida());
				pstm.setString(5, novoAluguel.getDataEntrega());
				
				pstm.executeUpdate();
				
				
				rs = pstm.getGeneratedKeys();
				if(rs.next()){
					int idAlug = rs.getInt(1);
					novoAluguel.setIdAluguel(idAlug);
				}

				
			} finally {

				SingletonConexaoDB.getInstance().desconectar(conexao, pstm, rs);
			}

		}
		
	}

	@Override
	public void atualizarAluguel(Aluguel aluguel) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
	
		try {
			RepositorioAluguel repo = new RepositorioAluguel();
			Aluguel aluguel  = new Aluguel();
			aluguel.setIdCliente(30);
			aluguel.setIdFuncionario(4);
			aluguel.setDataSaida("20/12/2014");
			aluguel.setDataEntrega("27/12/2014");
			aluguel.setValorTotal(1050.50);
			
			repo.inserirAluguel(aluguel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
