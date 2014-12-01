package br.com.tap.controle;

import br.com.tap.dados.IRepositorioFuncionario;
import br.com.tap.dados.RepositorioFuncionario;
import br.com.tap.negocio.Funcionario;
import br.com.tap.util.UtilGUI;

public class CCadastroFuncionario {

	private IRepositorioFuncionario repositorioFun;

	public CCadastroFuncionario() throws Exception {
		this.repositorioFun = new RepositorioFuncionario();
	}

	/* inserir um funcionario */
	public boolean inserirFuncionario(Funcionario funcionario) {
		boolean result = false;

		try {
			this.repositorioFun.inserirFuncionario(funcionario);
			result = true;
		} catch (Exception e) {
			UtilGUI.erroMenssage("Casdastrar Funcionario",
					"Erro ao cadastrar funcionario");
		}
		return result;
	}

	public boolean removerFuncionario(String cpf) throws Exception {

		boolean result = false;

		try {
			if (cpf.equals("") || cpf == null) {
				UtilGUI.erroMenssage("Remover Funcionario", "Informe o Cpf");
				result = false;
			} else {
				repositorioFun.removerFuncionario(cpf);
				result = true;
			}
		} catch (Exception e) {
			UtilGUI.erroMenssage("Remover Funcionario",
					"Erro ao tentar remover funcionario!!!");
		}

		return result;
	}

}
