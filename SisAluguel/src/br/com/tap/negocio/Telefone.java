package br.com.tap.negocio;

public class Telefone {
	private String numero;
	private String operadora;
	
	public Telefone(){
		this.numero="";
		this.operadora="";
	
	}

	public Telefone(String numero, String operadora){
		setNumero(numero);
		setOperadora(operadora);
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
}
