package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationWarningMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		JOptionPane jop;
		jop = new JOptionPane();
		jop.showMessageDialog(null, "Message d'erreur", "[" + level + "] " + message, JOptionPane.WARNING_MESSAGE);	
	}

}
