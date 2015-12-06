package edu.iut.app;

import java.util.LinkedList;

public class Agenda extends LinkedList<ExamEvent>/* EX2: COLLECTION d'ExamEvent */ {

	private static Agenda session = null;
	private Agenda() {		
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
	static public Agenda instance() {
		if (session == null) {			
			session = new Agenda();
		}
		return session;
	}
	
	
}
