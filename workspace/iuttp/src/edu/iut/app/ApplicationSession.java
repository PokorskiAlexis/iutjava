package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession {
	
	// Exercice 1 : GÃ©rer l'internationation
	protected ResourceBundle  resourceBundle;
	protected Locale locale;
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;
	//salut 21
	/*Qu'est ce qu'un singleton ? : static */
	private static ApplicationSession session = null;
	private ApplicationSession() {
		/* Definir US comme locale par dÃ©faut */
		//Locale.setDefault(Locale.US);
		//Pour gérer l’internationalisation il faut laisser utiliser la valeur par défaut de la machine : Locale.getDefault()
		setLocale(Locale.getDefault());
		sessionGuiLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);				
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = Logger.getLogger("IUTException");
		sessionExceptionLogger.setLevel(Level.ALL);		

	}
	
	
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		/* rÃ©cupÃ©rer les resources ResourceBundle.getBundle("edu.iut.resources.strings.res") */
		/*Internationalisation FR et US*/
		if(locale.equals(Locale.FRANCE))
			resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res_fr");	
		else if(locale.equals(Locale.US))
			resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res");
		else //Langue non gérer, on met l'anglais
			resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res");

					
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
