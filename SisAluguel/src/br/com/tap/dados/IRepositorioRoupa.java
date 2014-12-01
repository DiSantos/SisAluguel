package br.com.tap.dados;



import java.util.List;

import br.com.tap.negocio.Roupa;

public interface IRepositorioRoupa {

	public void inserirRoupa(Roupa novaRoupa) throws Exception;

	public void atualizarRoupa(Roupa Roupa) throws Exception;

	public void removerRoupa(long codRoupa) throws Exception;

	public List<Roupa> listarRoupaPorNome(long codigoRoupa);  //inserir na tabela do banco
}
/*Criado a classe "Roupa", Projeto TAP P2 2014.2 Prof Allan

Criada as classes:
	- Roupa,
	- RepositorioRoupa

A Interface 
	- IRepositorioRoupa

//Adicionar campo, "codigoRoupa" na tabela do banco
 * DELETAR ISSO DEPOIS
 */