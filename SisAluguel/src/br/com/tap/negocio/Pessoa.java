package br.com.tap.negocio;

public class Pessoa {

	private String nome;
	private String cpf;

	public Pessoa() {
		this.nome = "";
		this.cpf = "";
	}

	public Pessoa(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	/* get && set */
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
