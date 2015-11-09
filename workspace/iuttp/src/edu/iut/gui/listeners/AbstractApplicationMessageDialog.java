package edu.iut.gui.listeners;

import edu.iut.app.IApplicationLogListener;

public abstract class AbstractApplicationMessageDialog implements IApplicationLogListener {

	String level,message;
	@Override
	public void newMessage(String level, String message) {
	 /* TP1 : CODE A FOURNIR */
		this.level=level;
		this.message=message;
	}
	public void newMessage(String message){
		this.message=message;
		showMessage(this.level,this.message);
	}
	
	/* TP1 ajouter une méthode abstraite showMessage */
	protected abstract void showMessage(String level, String message);
}
