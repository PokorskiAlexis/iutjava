package edu.iut.gui.listeners;

import edu.iut.app.IApplicationLogListener;

// TODO: Auto-generated Javadoc
/**
 * La Classe AbstractApplicationMessageDialog.
 */
public abstract class AbstractApplicationMessageDialog implements
		IApplicationLogListener {

	/* (non-Javadoc)
	 * @see edu.iut.app.IApplicationLogListener#newMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void newMessage(String level, String message) {
	 showMessage(level, message);

	}
	
	/**
	 * Voir le message
	 *
	 * @param level le level
	 * @param message le message
	 */
	protected abstract void showMessage(String level, String message);

}
