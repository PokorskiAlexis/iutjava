package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationInfoMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		JOptionPane jop;
		jop = new JOptionPane();
		jop.showMessageDialog(null, "Message d'erreur", "[" + level + "] " + message, JOptionPane.INFORMATION_MESSAGE);
	}
}
