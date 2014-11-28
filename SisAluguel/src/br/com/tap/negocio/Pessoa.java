package br.com.tap.negocio;

public class Pessoa {

	private String nome;
	private long cpf;

	public Pessoa() {
		this.nome = "";
		this.cpf = 0;
	}

	public Pessoa(String nome, long cpf) {
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

	public long getCpf() {
		return this.cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

}
