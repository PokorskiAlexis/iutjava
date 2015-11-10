package edu.iut.app;

import java.util.ArrayList;


public class ApplicationLogs extends ArrayList<IApplicationLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ApplicationLogs() {		
	}
	
	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog filteredLogs_i : this) {
			if(filteredLogs_i instanceof ApplicationErrorLog){
				filteredLogs.add(filteredLogs_i);
			}
		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog filteredLogs_i : this) {
			if(filteredLogs_i instanceof ApplicationWarningLog){
				filteredLogs.add(filteredLogs_i);
			}
		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog filteredLogs_i : this) {
			if(filteredLogs_i instanceof ApplicationInfoLog){
				filteredLogs.add(filteredLogs_i);
			}
		}
		return filteredLogs;
	}
	

}
