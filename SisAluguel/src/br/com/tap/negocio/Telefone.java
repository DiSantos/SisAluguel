package br.com.tap.negocio;

public class Telefone {

	private int idTelefone;
	private Cliente cliente;
	private String numero;
	private String operadora;

	public Telefone() {

		this.idTelefone = 0;
		this.numero = "";
		this.operadora = "";

	}

	public Telefone(Cliente cliente, String numero, String operadora) {
		setNumero(numero);
		setOperadora(operadora);
		setCliente(cliente);

	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int id) {
		this.idTelefone = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();

		output.append("ID Telefone: " + getIdTelefone() + "\n");
		output.append("Numero: " + getNumero() + "\n");
		output.append("Operadora: " + getOperadora());

		return output.toString();
	}

}
