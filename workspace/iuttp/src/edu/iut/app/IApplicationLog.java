package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * L'interface IApplicationLog.
 */
public interface IApplicationLog {
	
	/**
	 * Modifier le message
	 *
	 * @param message le nouveau message
	 */
	public void setMessage(String message);
	
	/**
	 * Obtenir le message
	 *
	 * @return le message
	 */
	public String getMessage();
	
	/**
	 * Ajouter au listener 
	 *
	 * @param listener le listener d'IApplicationLogListener
	 */
	public void addListener(IApplicationLogListener listener);
	
	/**
	 * Obtenir l'applicationLogListeners
	 *
	 * @return l'application log listeners
	 */
	public IApplicationLogListener[] getApplicationLogListeners();
}
