package br.com.tap.dados;

import java.util.List;
import br.com.tap.negocio.Telefone;

public interface IRepositorioTelefone {

	public void inserirTel(Telefone telefone) throws Exception;

	public void atualizarTel(Telefone Telefone) throws Exception;

	public void removerTel(Integer id) throws Exception;

	public List<Telefone> listarPorCliente(Integer idCliente) throws Exception;
	
	public List<Telefone> buscaPorNumero(String numero) throws Exception;
}
