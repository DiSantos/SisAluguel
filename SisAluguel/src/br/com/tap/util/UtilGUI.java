package br.com.tap.util;

import javax.swing.JOptionPane;

public class UtilGUI {

	public UtilGUI() {
	}

	public final static void sucessoMensagem(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo,
				JOptionPane.INFORMATION_MESSAGE);

	}

	public final static void erroMenssage(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo,
				JOptionPane.ERROR_MESSAGE);
	}
}
