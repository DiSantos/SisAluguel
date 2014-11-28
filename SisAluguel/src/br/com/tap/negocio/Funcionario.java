package br.com.tap.negocio;

public class Funcionario extends Pessoa {

	private String ctps;
	private double salario;

	public Funcionario() {

		this.ctps = "";
		this.salario = 0.0;
	}

	public Funcionario(String nome, String cpf, String ctps, double salario) {
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

	/* O método toString produz uma representação de string de qualquer objeto. */
	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("Nome: " + getNome() + "\n");
		output.append("CPF: " + getCpf() + "\n");
		output.append("CTPS: " + getCtps() + "\n");
		output.append("Salário: " + getSalario());
		return output.toString();
	}

	public static void main(String[] args) {

		Funcionario f = new Funcionario("Diego", "08271335456", "70.23502",
				800.00);

		System.out.println(f.toString());
	}

}
