package br.com.tap.negocio;

public class Aluguel {

	private int idAluguel;
	private int idCliente; // referencia a chave estrangeira do cliente
	private int idFuncionario; // referencia a chave estrangeira do funcionario
	private double valorTotal;
	private String dataSaida;
	private String dataEntrega;

	public Aluguel() {

	}
	
	

	public int getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();

		output.append("ID Aluguel: " + getIdAluguel() + "\n");
		output.append("ID Cliente: " + getIdCliente() + "\n");
		output.append("ID Funcionario: " + getIdFuncionario() + "\n");
		output.append("Valor total: " + getValorTotal() + "\n");
		output.append("Data saída: " + getDataSaida() + "\n");
		output.append("Data entrega: " + getDataEntrega());

		return output.toString();
	}

}
