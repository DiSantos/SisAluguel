import br.com.tap.comunicacao.Fachada;
import br.com.tap.comunicacao.IFachada;
import br.com.tap.negocio.Funcionario;
import br.com.tap.util.UtilGUI;

public class Main {

	public static void main(String[] args) {

		// Funcionario fun1 = new Funcionario("08271335456", "Diego", "2100",
		// 789);
		Funcionario fun2 = new Funcionario("02831745365", "Taynan", "1200", 500);
		try {
			IFachada fachada = new Fachada();

			if (fachada.removerFuncionario("08271335456")) {
				UtilGUI.sucessoMensagem("Sucesso",
						"Funcionario Removido com Sucesso!!!");
			}

			/*
			 * if (fachada.inserirFuncionario(fun1)) {
			 * UtilGUI.sucessoMensagem("Sucesso",
			 * "Funcionario Cadastrado com Sucesso!!!"); }
			 * 
			 * if (fachada.inserirFuncionario(fun2)) {
			 * UtilGUI.sucessoMensagem("Sucesso",
			 * "Funcionario Cadastrado com Sucesso!!!"); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
