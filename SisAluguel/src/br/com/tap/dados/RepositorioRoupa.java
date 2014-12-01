package br.com.tap.dados;

import java.util.List;

import br.com.tap.negocio.Roupa;

/*Criado a classe "Roupa", Projeto TAP P2 2014.2 Prof Allan

Criada as classes:
	- Roupa,
	- RepositorioRoupa

A Interface 
	- IRepositorioRoupa

//Adicionar campo, "codigoRoupa" na tabela do banco
 * DELETAR ISSO DEPOIS
 */
public class RepositorioRoupa implements IRepositorioRoupa{

	@Override
	public void inserirRoupa(Roupa novaRoupa) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarRoupa(Roupa Roupa) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerRoupa(String roupa) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Roupa> listarRoupaPorNome(long codigoRoupa) {
		// TODO Auto-generated method stub
		return null;
	}

}

