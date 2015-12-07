package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * Le Classe ApplicationErrorMessageDialog.
 */
public class ApplicationErrorMessageDialog extends
		AbstractApplicationMessageDialog {

	/* (non-Javadoc)
	 * @see edu.iut.gui.listeners.AbstractApplicationMessageDialog#showMessage(java.lang.String, java.lang.String)
	 */
	@Override
	protected void showMessage(String level, String message) {
		JOptionPane.showMessageDialog(null, message, level, JOptionPane.ERROR_MESSAGE, null);
	}

}
