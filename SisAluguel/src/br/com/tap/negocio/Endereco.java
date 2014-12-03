package br.com.tap.negocio;

public class Endereco {

	private int idEnd;
	private String cep;
	private String bairro;
	private int numero;
	private String cidade;
	private String estado;
	private String complemento;
	private Cliente cliente;

	public Endereco() {

	}

	public Endereco(String cep, String bairro, int numero, String cidade,
			String estado, String complemento, Cliente cliente) {

		setCep(cep);
		setBairro(bairro);
		setNumero(numero);
		setCidade(cidade);
		setEstado(estado);
		setComplemento(complemento);
		setCliente(cliente);

	}

	public int getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(int idEnd) {
		this.idEnd = idEnd;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
		output.append("Cep: " + getCep() + "\n");
		output.append("Bairro: " + getBairro() + "\n");
		output.append("Número: " + getNumero() + "\n");
		output.append("Cidade: " + getCidade() + "\n");
		output.append("Estado: " + getEstado() + "\n");
		output.append("Complemento: " + getComplemento());
		return output.toString();
	}

}
