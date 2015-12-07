package edu.iut.app;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La classe AbstractApplicationLog.
 */
public abstract class AbstractApplicationLog implements IApplicationLog {

	/** Le message. */
	protected String message;
	
	/** Le tableau "listeners" d'IApplicationLogListener */
	protected ArrayList<IApplicationLogListener> listeners;
	
	/**
	 * Initialisation des variables.
	 */
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}
	
	/* (non-Javadoc)
	 * @see edu.iut.app.IApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public abstract void setMessage(String message);

	/* (non-Javadoc)
	 * @see edu.iut.app.IApplicationLog#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see edu.iut.app.IApplicationLog#addListener(edu.iut.app.IApplicationLogListener)
	 */
	@Override
	public void addListener(IApplicationLogListener listener) {
		listeners.add(listener);

	}
	
	/* (non-Javadoc)
	 * @see edu.iut.app.IApplicationLog#getApplicationLogListeners()
	 */
	@Override
	public IApplicationLogListener[] getApplicationLogListeners() {
		return (IApplicationLogListener[])listeners.toArray();
	}
	
	/**
	 * Methode fireMessage
	 *
	 * @param Le niveau
	 * @param Le Message
	 */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
