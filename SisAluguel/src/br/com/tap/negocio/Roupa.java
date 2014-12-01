package br.com.tap.negocio;

public class Roupa {

	private String descricao;
	private double valor;
	private long codigoRoupa;

	public Roupa() {

		this.descricao = "";
		this.valor = 0;
		this.codigoRoupa = 0;

	}

	public Roupa(String descricao, double valor, long codigoRoupa) {

		setDescricao(descricao);
		setValor(valor);
		setCodigoRoupa(codigoRoupa);

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getCodigoRoupa() {
		return codigoRoupa;
	}

	public void setCodigoRoupa(long codigoRoupa) {
		this.codigoRoupa = codigoRoupa;
	}
	
	

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("Descrição: " + getDescricao() + "\n");
		output.append("Valor: " + getValor() + "\n");
		output.append("Codigo da Roupa: " + getCodigoRoupa() + "\n");
		return output.toString();
	}

}
