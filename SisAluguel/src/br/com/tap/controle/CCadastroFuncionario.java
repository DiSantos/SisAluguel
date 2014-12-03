package br.com.tap.controle;

import br.com.tap.dados.IRepositorioFuncionario;
import br.com.tap.dados.RepositorioFuncionario;
import br.com.tap.dados.SingletonConexaoDB;
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
			UtilGUI.erroMenssage("Cadastro-Funcionário",
					"Erro ao cadastrar funcionário");
		} finally {
			try {
				SingletonConexaoDB.getInstance().desconectar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean removerFuncionario(String cpf) {

		boolean result = false;

		try {
			if (cpf != null) {
				repositorioFun.removerFuncionario(cpf);
				result = true;
			}
		} catch (Exception e) {
			UtilGUI.erroMenssage("Remover Funcionario",
					"Erro ao tentar remover funcionario!!!");
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

	public boolean atualizarFuncionario(Funcionario funcionario)throws Exception{

		boolean result = false;
		
		try{
			try{
				
				
				
			}finally{
				
			}
		}catch(Throwable e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return result;

	}

}
