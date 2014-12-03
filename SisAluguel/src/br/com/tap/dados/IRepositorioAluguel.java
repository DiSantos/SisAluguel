package br.com.tap.dados;

import br.com.tap.negocio.Aluguel;

public interface IRepositorioAluguel {

	public void inserirAluguel(Aluguel novoAluguel) throws Exception;

	public void atualizarAluguel(Aluguel aluguel) throws Exception;
}
