package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * La Classe ApplicationInfoMessageDialog.
 */
public class ApplicationInfoMessageDialog extends
		AbstractApplicationMessageDialog {

	/* (non-Javadoc)
	 * @see edu.iut.gui.listeners.AbstractApplicationMessageDialog#showMessage(java.lang.String, java.lang.String)
	 */
	@Override
	protected void showMessage(String level, String message) {
		JOptionPane.showMessageDialog(null, message, level, JOptionPane.INFORMATION_MESSAGE, null);
	}
}
