package br.com.tap.comunicacao;

import java.util.List;

import br.com.tap.negocio.Funcionario;

public interface IFachada {

	/* Interface da Fachada para o Funcionario!!! */
	public void inserirFuncionario(Funcionario novoFuncionario)
			throws Exception;

	public void atualizarFuncionario(Funcionario funcionario) throws Exception;

	public void removerFuncionario(String cpf) throws Exception;

	public List<Funcionario> listarFuncionarioPorNome(String nome);

}
