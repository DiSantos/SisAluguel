package br.com.tap.dados;

import br.com.tap.negocio.Endereco;

public interface IRepositorioEndereco {

	public void inserirEndereco(Endereco novoEndereco) throws Exception;

	public void removerPorId(Integer id) throws Exception;

	public void atualizarEndereco(Endereco endereco) throws Exception;

	public Endereco buscarPorIdCliente(Integer idCliente) throws Exception;
}
