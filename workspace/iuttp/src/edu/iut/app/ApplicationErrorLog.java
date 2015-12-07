package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La Classe ApplicationErrorLog.
 */
public class ApplicationErrorLog extends AbstractApplicationLog {

	/**
	 * Instancie une nouvelle application error log
	 */
	public ApplicationErrorLog() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see edu.iut.app.AbstractApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().severe(this.message);
		super.fireMessage("[ERROR]", this.message);
	}


}
