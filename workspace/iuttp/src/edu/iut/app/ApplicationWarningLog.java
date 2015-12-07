package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La classe ApplicationWarningLog.
 */
public class ApplicationWarningLog extends AbstractApplicationLog {

	/**
	 * Crée une nouvelle application warning log.
	 */
	public ApplicationWarningLog() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see edu.iut.app.AbstractApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().warning(this.message);
		super.fireMessage("[WARNING]", this.message);
	}
}
