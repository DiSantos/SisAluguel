package br.com.tap.visao;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

import br.com.tap.comunicacao.Fachada;
import br.com.tap.comunicacao.IFachada;
import br.com.tap.negocio.Cliente;
import br.com.tap.negocio.Endereco;
import br.com.tap.negocio.Telefone;
import br.com.tap.util.UtilGUI;

public class PainelCadastroCliente extends JPanel {
	private final JPanel panel = new JPanel();
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textFone;
	private JTextField textCel;
	private JTextField textOperadoraCel;
	private JTextField textOperadoraFone;
	private JTextField textCep;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textEstado;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JButton btnSair;

	private IFachada fachada;

	public PainelCadastroCliente() throws Exception {

		this.fachada = new Fachada();

		setLayout(new BorderLayout(0, 0));
		panel.setBorder(new TitledBorder(null, "Cadastro-Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 40, 46, 14);
		panel.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(66, 37, 293, 20);
		panel.add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(369, 40, 46, 14);
		panel.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setBounds(396, 37, 194, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(20, 78, 46, 14);
		panel.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(66, 75, 189, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblFone = new JLabel("Fone:");
		lblFone.setBounds(20, 117, 46, 14);
		panel.add(lblFone);

		textFone = new JTextField();
		textFone.setBounds(66, 114, 118, 20);
		panel.add(textFone);
		textFone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cel:");
		lblNewLabel.setBounds(20, 155, 46, 14);
		panel.add(lblNewLabel);

		textCel = new JTextField();
		textCel.setColumns(10);
		textCel.setBounds(66, 152, 118, 20);
		panel.add(textCel);

		textOperadoraCel = new JTextField();
		textOperadoraCel.setColumns(10);
		textOperadoraCel.setBounds(285, 152, 118, 20);
		panel.add(textOperadoraCel);

		JLabel lblOperadoraCel = new JLabel("Operadora Cel:");
		lblOperadoraCel.setBounds(194, 155, 106, 14);
		panel.add(lblOperadoraCel);

		JLabel lblOperadoraFone = new JLabel("Operadora Fone:");
		lblOperadoraFone.setBounds(194, 117, 106, 14);
		panel.add(lblOperadoraFone);

		textOperadoraFone = new JTextField();
		textOperadoraFone.setColumns(10);
		textOperadoraFone.setBounds(297, 114, 118, 20);
		panel.add(textOperadoraFone);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 192, 46, 14);
		panel.add(lblCep);

		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(66, 189, 118, 20);
		panel.add(textCep);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(194, 192, 74, 14);
		panel.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(247, 189, 118, 20);
		panel.add(textCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(377, 192, 57, 14);
		panel.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(428, 189, 162, 20);
		panel.add(textBairro);

		JLabel lblNmero = new JLabel("N\u00FAmero: ");
		lblNmero.setBounds(20, 230, 79, 14);
		panel.add(lblNmero);

		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(76, 227, 75, 20);
		panel.add(textNumero);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(177, 230, 106, 14);
		panel.add(lblComplemento);

		textComplemento = new JTextField();
		textComplemento.setColumns(10);
		textComplemento.setBounds(268, 227, 135, 20);
		panel.add(textComplemento);

		JLabel lblNewLabel_1 = new JLabel("Estado:");
		lblNewLabel_1.setBounds(415, 230, 57, 14);
		panel.add(lblNewLabel_1);

		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(472, 227, 118, 20);
		panel.add(textEstado);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Opera\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(20, 259, 570, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(75, 53, 89, 23);
		btnSalvar.addActionListener(new TrataEventos());
		panel_1.add(btnSalvar);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(239, 53, 89, 23);
		panel_1.add(btnNovo);

		btnSair = new JButton("Sair");
		btnSair.setBounds(403, 53, 89, 23);
		panel_1.add(btnSair);

	}

	private class TrataEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				if (e.getSource() == btnSalvar) {
					String nome = textNome.getText();
					String cpf = textCpf.getText();
					String email = textEmail.getText();
					String fone = textFone.getText();
					String cel = textCel.getText();
					String operadoraFone = textOperadoraFone.getText();
					String operadoraCel = textOperadoraCel.getText();
					String cep = textCep.getText();
					String cidade = textCidade.getText();
					String bairro = textBairro.getText();
					int numero = Integer.parseInt(textNumero.getText());
					String complemento = textComplemento.getText();
					String estado = textEstado.getText();
					List<Telefone> telefones = new ArrayList<Telefone>();

					Cliente cliente = new Cliente(cpf, nome, email);
					Endereco end = new Endereco(cep, bairro, numero, cidade,
							estado, complemento, cliente);
					Telefone telCel = new Telefone(cliente, cel, operadoraCel);
					Telefone telFone = new Telefone(cliente, fone,
							operadoraFone);
					telefones.add(telCel);
					telefones.add(telFone);
					cliente.setEndereco(end);
					cliente.setTelefones(telefones);

					if (fachada.inserirCliente(cliente)) {
						UtilGUI.sucessoMensagem("Cadastro-Cliente", "Cliente "
								+ cliente.getNome()
								+ "\ncadastrado com sucesso!!!");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
