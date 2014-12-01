package br.com.tap.dados;

import java.util.List;

import br.com.tap.negocio.Funcionario;

public interface IRepositorioFuncionario {

	public void inserirFuncionario(Funcionario novoFuncionario)throws Exception;

	public void atualizarFuncionario(Funcionario funcionario) throws Exception;

	public void removerFuncionario(String cpf) throws Exception;

	public List<Funcionario> listarFuncionarioPorNome(String nome);

}
