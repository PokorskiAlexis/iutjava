package edu.iut.app;

import java.util.ArrayList;

public interface IApplicationLog {
	/** TP1 : Créérr les méthodes :
	 - setMessage
	  - getMessage
	  - addListener
	  - getApplicationLogListeners();
	*/
	void setMessage(String message);
	String getMessage();
	void addListener(IApplicationLogListener listener);
	ArrayList<IApplicationLogListener> getApplicationLogListeners();

}
