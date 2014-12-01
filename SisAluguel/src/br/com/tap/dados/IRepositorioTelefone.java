package br.com.tap.dados;

import java.util.List;

import br.com.tap.negocio.Telefone;

public interface IRepositorioTelefone {
	
	public void inserirTel(Telefone telefone) throws Exception;

	public void atualizarTel (Telefone Telefone)throws Exception;
	
	public void removerTel (String numero) throws Exception;
	
	public  List<Telefone>  listarPorNumero (String numero) throws Exception;
}
