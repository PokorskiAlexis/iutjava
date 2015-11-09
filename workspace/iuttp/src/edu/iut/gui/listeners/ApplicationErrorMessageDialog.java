package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public abstract class ApplicationErrorMessageDialog extends AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		//Boîte du message d'erreur
		JOptionPane jop;
		jop = new JOptionPane();
		jop.showMessageDialog(null, "Message d'erreur", "[" + level + "] " + message, JOptionPane.ERROR_MESSAGE);
	}

}
