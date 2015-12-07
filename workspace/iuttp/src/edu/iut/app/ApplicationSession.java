package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * La Classe ApplicationSession.
 */
public class ApplicationSession {
	
	/** The resource bundle. */
	protected ResourceBundle resourceBundle;
	
	/** The locale. */
	protected Locale locale;
	
	/** The session gui logger. */
	protected Logger sessionGuiLogger;
	
	/** The session exception logger. */
	protected Logger sessionExceptionLogger;
	
	/** The months. */
	protected String[] months;
	
	/** The days. */
	protected String[] days;


	/** The session. */
	private static ApplicationSession session = null;
	
	/**
	 * Crée une nouvelle application session.
	 */
	private ApplicationSession() {
		locale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.res");
		sessionGuiLogger = Logger.getLogger("IUTTrain");
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = Logger.getLogger("IUTException");
		sessionExceptionLogger.setLevel(Level.ALL);
		
		days = new String[7];
		days[0] = getString("monday"); days[1] =  getString("tuesday"); days[2] =  getString("wednesday");
		days[3] = getString("thursday");   days[4] =  getString("friday"); days[5] =  getString("saturday");
		days[6] = getString("sunday"); 
		
		months = new String[12];
		months[0] = getString("january"); months[1] =  getString("february"); months[2] =  getString("march");
		months[3] = getString("april");   months[4] =  getString("may");      months[5] =  getString("june");
		months[6] = getString("july"); months[7] =  getString("august"); months[8] =  getString("september");
		months[9] = getString("october"); months[10] =  getString("november"); months[11] =  getString("december");
		
		
	}
	
	
	/**
	 * Crée une instance(Session) d'applicationSession
	 *
	 * @return Une instance
	 */
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	/**
	 * Récupere le GUILogger.
	 *
	 * @return Le GUI logger
	 */
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	
	/**
	 * Recupere l'exception du logger.
	 *
	 * @return L'exception du logger
	 */
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	/**
	 * Modifie la variable Locale
	 *
	 * @param locale une variable de type Locale
	 */
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res");
	}
	
	/**
	 * Retourne la chaine de caractère d'une clé
	 *
	 * @param Clé de type String
	 * @return La chaine de caractère
	 */
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * Obtenir les jours
	 *
	 * @return les jours
	 */
	public String[] getDays() {
		return days;
	}
	
	/**
	 * Obtenir les mois.
	 *
	 * @return les mois
	 */
	public String[] getMonths() {
		return months;
	}
	
	
}
