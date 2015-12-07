package edu.iut.exceptions;

// TODO: Auto-generated Javadoc
/**
 * La Classe IUTException.
 */
public class IUTException extends Exception {
	
	/**
	 * Crée une nouvelle IUT exception.
	 */
	public IUTException() {
		super();
		edu.iut.app.ApplicationSession.instance().getExceptionLogger().severe("empty");
	}
	
	/**
	 * Crée une nouvelle IUT exception.
	 *
	 * @param e la nouvelle exception
	 */
	public IUTException(IUTException e) {
		super (e);
		edu.iut.app.ApplicationSession.instance().getExceptionLogger().severe(e.getMessage());
	}
	
	/**
	 * Crée une nouvelle IUT exception.
	 *
	 * @param message le message
	 */
	public IUTException(String message) {
		super(message);
		edu.iut.app.ApplicationSession.instance().getExceptionLogger().severe(message);
	}
	
}
