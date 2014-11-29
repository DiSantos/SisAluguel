package br.com.tap.negocio;

public class Pessoa {
     
	private String cpf;
	private String nome;


	public Pessoa() {
		this.cpf = "";
		this.nome = "";
	
	}

	public Pessoa(String cpf, String nome) {
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
