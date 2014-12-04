package br.com.tap.comunicacao;

import java.util.List;

import br.com.tap.controle.CCadastroCliente;
import br.com.tap.controle.CCadastroFuncionario;
import br.com.tap.negocio.Cliente;
import br.com.tap.negocio.Funcionario;

public class Fachada implements IFachada {

	private CCadastroFuncionario cadastroFun = null;
	private CCadastroCliente cadastroCli = null;

	public Fachada() throws Exception {
		this.cadastroFun = new CCadastroFuncionario();
		this.cadastroCli = new CCadastroCliente();
	}

	/* FUNCIONÁRIO */
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
	
	/*CLIENTE*/
	@Override
	public boolean inserirCliente(Cliente novoCliente) throws Exception {

		return this.cadastroCli.inserirCliente(novoCliente);
	}

	@Override
	public boolean removerClientePorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.cadastroCli.removerClientePorId(id);
	}

	@Override
	public boolean alualizarCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente buscarPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarPorNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
