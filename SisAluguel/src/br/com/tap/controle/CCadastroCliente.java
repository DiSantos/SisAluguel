package br.com.tap.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.dados.IRepositorioCliente;
import br.com.tap.dados.IRepositorioEndereco;
import br.com.tap.dados.IRepositorioTelefone;
import br.com.tap.dados.RepositorioCliente;
import br.com.tap.dados.RepositorioEndereco;
import br.com.tap.dados.RepositorioTelefone;
import br.com.tap.dados.SingletonConexaoDB;
import br.com.tap.negocio.Cliente;
import br.com.tap.negocio.Endereco;
import br.com.tap.negocio.Telefone;
import br.com.tap.util.UtilGUI;

public class CCadastroCliente {

	private IRepositorioCliente cadastroCli;
	private IRepositorioTelefone cadastroTel;
	private IRepositorioEndereco cadastroEnd;

	public CCadastroCliente() throws Exception {

		this.cadastroCli = new RepositorioCliente();
		this.cadastroTel = new RepositorioTelefone();
		this.cadastroEnd = new RepositorioEndereco();
	}

	public boolean inserirCliente(Cliente cliente) {

		boolean result = false;

		try {

			this.cadastroCli.inserirCliente(cliente);
			if (cliente.getEndereco() != null) {

				this.cadastroEnd.inserirEndereco(cliente.getEndereco());
			}
			if (cliente.getTelefones() != null) {
				for (Telefone tel : cliente.getTelefones()) {
					this.cadastroTel.inserirTel(tel);
					System.out.println(tel.toString());
				}
			}

			result = true;

		} catch (Exception e) {

			System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
			UtilGUI.erroMenssage("Cadastro-Cliente",
					"Erro ao cadastrar cliente!!!");

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

	public boolean removerClientePorId(Integer id) {
		boolean result = false;

		try {

			Cliente cliente = this.cadastroCli.buscarPorId(id);
			System.out.println(cliente.toString());
			System.out.println(id);

			System.out.println("antes tel");
			for (Telefone tel : this.cadastroTel.listarPorCliente(cliente.getIdCli())) {
				System.out.println("durante tel");
				this.cadastroTel.removerTel(tel.getIdTelefone());
			}
			System.out.println("depois tel");
			this.cadastroEnd.removerPorId(id);
			this.cadastroCli.removerClientePorId(id);

			result = true;

		} catch (Exception e) {
			System.err.println("Erro ao tentar remover cliente: "
					+ e.getMessage());
			UtilGUI.erroMenssage("Cadastro-Cliente",
					"Erro ao tentar remover cliente!!");
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

	public Cliente buscarPorId(Integer id) throws Exception {
		Cliente cliente = null;
		try {
			cliente = this.cadastroCli.buscarPorId(id);
			if (cliente != null) {

				buscarEnderecoTelefone(cliente);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			SingletonConexaoDB.getInstance().desconectar();
		}
		return cliente;
	}

	private void buscarEnderecoTelefone(Cliente cliente) throws Exception {

		cliente.setTelefones(this.cadastroTel.listarPorCliente(cliente
				.getIdCli()));
		cliente.setEndereco(this.cadastroEnd.buscarPorIdCliente(cliente
				.getIdCli()));
	}

	public boolean alualizarCliente(Cliente cliente) {
		boolean result = false;
		return result;
	}

	public static void main(String[] args) {

		List<Telefone> tels = new ArrayList<Telefone>();

		try {
			CCadastroCliente cadCliente = new CCadastroCliente();
			Cliente cliente = new Cliente("08271335456", "Diego Santos",
					"@gmail.com");

			Telefone tel = new Telefone(cliente, "32698834", "GVT");
			Telefone tel2 = new Telefone(cliente, "32698834", "oi");

			tels.add(tel);
			tels.add(tel2);

			Endereco end = new Endereco("5250036", "Vasco da Gama", 325,
					"Recife", "PE", "AP", cliente);
			cliente.setTelefones(tels);
			cliente.setEndereco(end);
			if (cadCliente.inserirCliente(cliente)) {
				UtilGUI.sucessoMensagem("Cadastro de Cliente", "Sucesso!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
