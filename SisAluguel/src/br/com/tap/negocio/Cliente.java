package br.com.tap.negocio;

import java.util.List;

public class Cliente extends Pessoa {

	private int idCli;
	private String email;
	private List<Telefone> telefones;
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(String cpf, String nome, String email,
			List<Telefone> telefones, Endereco endereco) {

		super(cpf, nome);
		setEmail(email);
		setTelefones(telefones);
		setEndereco(endereco);

	}

	public Cliente(String cpf, String nome, String email) {
		super(cpf, nome);
		setEmail(email);

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
