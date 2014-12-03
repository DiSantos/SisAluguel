package br.com.tap.negocio;

public class Funcionario extends Pessoa {

	private int idFun;
	private String ctps;
	private double salario;

	public Funcionario() {

		this.ctps = "";
		this.salario = 0.0;
	}

	public Funcionario(String cpf, String nome, String ctps, double salario) {
		super(cpf, nome);
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

	public int getIdFun() {
		return idFun;
	}

	public void setIdFun(int idFun) {
		this.idFun = idFun;
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
}
