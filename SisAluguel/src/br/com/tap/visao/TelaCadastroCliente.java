package br.com.tap.visao;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class TelaCadastroCliente extends JFrame {

	private PainelCadastroCliente painelCliente;
	private JTabbedPane tabbepane;

	public TelaCadastroCliente() throws Exception {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(610, 450);
		setLocationRelativeTo(null);
		setResizable(false);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		painelCliente = new PainelCadastroCliente();
		tabbepane = new JTabbedPane();
		tabbepane.addTab("Cadastro", painelCliente);
		container.add(tabbepane, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		TelaCadastroCliente t;
		try {
			t = new TelaCadastroCliente();
			t.setVisible(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
