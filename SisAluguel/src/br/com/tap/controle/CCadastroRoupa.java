package br.com.tap.controle;

import br.com.tap.dados.IRepositorioRoupa;
import br.com.tap.dados.RepositorioRoupa;
import br.com.tap.negocio.Roupa;
import br.com.tap.util.UtilGUI;

public class CCadastroRoupa {

	private IRepositorioRoupa repositorioRoupa;

	public CCadastroRoupa() throws Exception {

		this.repositorioRoupa = new RepositorioRoupa();

	}

	public boolean inserirRoupa(Roupa novaRoupa) throws Exception {
		boolean result = false;
		try {
			this.repositorioRoupa.inserirRoupa(novaRoupa);
			result = true;

		} catch (Exception e) {
			UtilGUI.erroMenssage("CADASTRAR ROUPA", "ERRO AO CADASTRAR ROUPA");

		}

		return result;

	}

	public boolean removerRoupa(long codRoupa) throws Exception {
		boolean result = false;
		try {
				UtilGUI.erroMenssage("REMOVER ROUPA", "INFORME CÓDIGO DA ROUPA");
				repositorioRoupa.removerRoupa(codRoupa);
				result = true;
			
		} catch (Exception e) {
			UtilGUI.erroMenssage("REMOVER ROUPA",
					"ERRO AO TENTAR REMOVER ROUPA");

		}
		return result;

	}
}
