package br.com.tap.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.tap.negocio.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {

	private Connection con = null;
	private PreparedStatement pstm = null;

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
		// TODO Auto-generated method stub
	}

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

	}
}
