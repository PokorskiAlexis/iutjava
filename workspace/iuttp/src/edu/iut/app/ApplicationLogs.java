package edu.iut.app;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * La Classe ApplicationLogs.
 */
public class ApplicationLogs extends ArrayList<IApplicationLog> {

	/**
	 * Crée une nouvelle application logs.
	 */
	public ApplicationLogs() {		
	}
	
	/**
	 * Crée une liste d'erreur d'applicationLog
	 *
	 * @return La liste d'erreur
	 */
	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationErrorLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	
	/**
	 * Crée une liste de warning d'applicationLog
	 *
	 * @return La liste de warning
	 */
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationWarningLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	
	/**
	 * Crée une liste des informations d'applicationLog
	 *
	 * @return La liste des informations
	 */
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationInfoLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	

}
