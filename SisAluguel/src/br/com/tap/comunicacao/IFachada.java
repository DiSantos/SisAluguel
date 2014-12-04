package br.com.tap.comunicacao;

import java.util.List;

import br.com.tap.negocio.Cliente;
import br.com.tap.negocio.Funcionario;

public interface IFachada {

	/*FUNCIONÁRIO */
	public boolean inserirFuncionario(Funcionario funcionario)	throws Exception;

	public void atualizarFuncionario(Funcionario funcionario) throws Exception;

	public boolean removerFuncionario(String cpf) throws Exception;

	public List<Funcionario> listarFuncionarioPorNome(String nome);
	
	
	
	/*CLIENTE*/
	public boolean inserirCliente(Cliente novoCliente) throws Exception;

	public boolean removerClientePorId(Integer id) throws Exception;

	public boolean alualizarCliente(Cliente cliente) throws Exception;

	public Cliente buscarPorId(Integer id) throws Exception;

	public List<Cliente> listarPorNome(String nome) throws Exception;

	public List<Cliente> listar() throws Exception;

}
