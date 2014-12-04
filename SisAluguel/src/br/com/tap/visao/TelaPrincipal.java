package br.com.tap.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuCadastro;
	private JMenu subMenuCliente;
	private JMenuItem jmiCliCad;
	private JPanel painelPaiBotOpocoes;
	private JPanel painelFilhoBotOpcoes;
	private JButton jbtCliente;
	private JButton jbtFuncionario;
	private JButton jbtRoupa;
	private JButton jbtAluguel;

	public TelaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);

		this.openFrame();

	}

	private void openFrame() {

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		menuBar = new JMenuBar();

		menuCadastro = new JMenu();
		menuCadastro.setText("Cadastro");

		subMenuCliente = new JMenu("Cliente");

		jmiCliCad = new JMenuItem("Inserir");

		subMenuCliente.add(jmiCliCad);
		menuCadastro.add(subMenuCliente);
		menuBar.add(menuCadastro);

		painelPaiBotOpocoes = new JPanel();
		painelPaiBotOpocoes.setLayout(new BorderLayout());

		painelFilhoBotOpcoes = new JPanel();
		painelFilhoBotOpcoes.setLayout(new GridLayout());

		jbtCliente = new JButton("Cliente");
		jbtCliente.addActionListener(new TratarEventos());
		jbtFuncionario = new JButton("Funcionário");
		jbtRoupa = new JButton("Roupa");
		jbtAluguel = new JButton("Aluguel");

		painelFilhoBotOpcoes.add(jbtCliente);
		painelFilhoBotOpcoes.add(jbtFuncionario);
		painelFilhoBotOpcoes.add(jbtRoupa);
		painelFilhoBotOpcoes.add(jbtAluguel);
		painelPaiBotOpocoes.add(painelFilhoBotOpcoes, BorderLayout.NORTH);
		container.add(menuBar, BorderLayout.NORTH);
		container.add(painelPaiBotOpocoes, BorderLayout.CENTER);

	}

	private class TratarEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == jbtCliente) {

				try {
					new TelaCadastroCliente().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	public static void main(String[] args) {

		TelaPrincipal tp = new TelaPrincipal();
		tp.setVisible(true);

	}

}
