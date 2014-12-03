package br.com.tap.comunicacao;

import java.util.List;

import br.com.tap.controle.CCadastroFuncionario;
import br.com.tap.negocio.Funcionario;

public class Fachada implements IFachada {

	private CCadastroFuncionario cadastroFun;

	public Fachada() throws Exception {
		this.cadastroFun = new CCadastroFuncionario();
	}

	/* Funcionario */
	@Override
	public boolean inserirFuncionario(Funcionario funcionario) throws Exception {

		return this.cadastroFun.inserirFuncionario(funcionario);

	}

	@Override
	public void atualizarFuncionario(Funcionario funcionario) throws Exception {

	}

	@Override
	public boolean removerFuncionario(String cpf) throws Exception {

		return this.cadastroFun.removerFuncionario(cpf);

	}

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome) {
		return null;
	}

}
