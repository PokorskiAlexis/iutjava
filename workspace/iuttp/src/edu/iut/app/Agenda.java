package edu.iut.app;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * La Classe Agenda
 */
public class Agenda extends LinkedList<ExamEvent>/* EX2: COLLECTION d'ExamEvent */ {

	/** La session. */
	private static Agenda session = null;
	
	/**
	 * Initialisation
	 */
	private Agenda() {		
	}
	
	/**
	 * Ajoute � la suite des ExamEvent l'examevent pass� en paramettre
	 *
	 * @param examEvent un ExamEvent
	 */
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
	/**
	 * Cr�e une instance(session) d'agenda
	 *
	 * @return une session
	 */
	static public Agenda instance() {
		if (session == null) {			
			session = new Agenda();
		}
		return session;
	}
	
	
}
