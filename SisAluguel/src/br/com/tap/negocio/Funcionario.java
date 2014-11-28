package br.com.tap.negocio;

public class Funcionario extends Pessoa {

	private String ctps;
	private double salario;

	public Funcionario() {

		this.ctps = "";
		this.salario = 0.0;
	}

	public Funcionario(String nome, long cpf, String ctps, double salario) {
		super(nome, cpf);
		setCtps(ctps);
		setSalario(salario);
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	/* O m�todo toString produz uma representa��o de string de qualquer objeto. */
	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("Nome: " + getNome() + "\n");
		output.append("CPF: " + getCpf() + "\n");
		output.append("CTPS: " + getCtps() + "\n");
		output.append("Sal�rio: " + getSalario());
		return output.toString();
	}
}
