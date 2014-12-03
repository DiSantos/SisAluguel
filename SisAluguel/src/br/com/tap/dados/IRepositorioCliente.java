package br.com.tap.dados;

import java.util.List;

import br.com.tap.negocio.Cliente;

public interface IRepositorioCliente {

	public void inserirCliente(Cliente novoCliente) throws Exception;

	public void removerCliente(String cpf) throws Exception;

	public void alualizarCliente(Cliente cliente) throws Exception;

	public Cliente buscarPorId(Integer id) throws Exception;

	public List<Cliente> listarPorNome(String nome) throws Exception;

	public List<Cliente> listar() throws Exception;
}
