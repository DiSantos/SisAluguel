package br.com.tap.controle;

import br.com.tap.dados.IRepositorioRoupa;
import br.com.tap.dados.RepositorioRoupa;
import br.com.tap.dados.SingletonConexaoDB;
import br.com.tap.negocio.Roupa;
import br.com.tap.util.UtilGUI;

public class CCadastroRoupa {

	private IRepositorioRoupa repositorioRoupa;

	public CCadastroRoupa() throws Exception {

		this.repositorioRoupa = new RepositorioRoupa();

	}

	public boolean inserirRoupa(Roupa novaRoupa) {
		boolean result = false;
		try {
			this.repositorioRoupa.inserirRoupa(novaRoupa);
			result = true;

		} catch (Exception e) {
			UtilGUI.erroMenssage("Cadastro-Roupa", "Erro ao cadastrar roupa!!!");

		} finally {
			try {
				SingletonConexaoDB.getInstance().desconectar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean removerRoupa(long codRoupa) {
		boolean result = false;
		try {
			repositorioRoupa.removerRoupa(codRoupa);
			result = true;

		} catch (Exception e) {
			UtilGUI.erroMenssage("REMOVER ROUPA",
					"ERRO AO TENTAR REMOVER ROUPA");

		} finally {
			try {
				SingletonConexaoDB.getInstance().desconectar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
}
