package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La Classe ApplicationInfoLog.
 */
public class ApplicationInfoLog extends AbstractApplicationLog {

	/**
	 * Crée une nouvelle application info log.
	 */
	public ApplicationInfoLog() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see edu.iut.app.AbstractApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().info(this.message);
        super.fireMessage("[INFO]", this.message);
	}

}
