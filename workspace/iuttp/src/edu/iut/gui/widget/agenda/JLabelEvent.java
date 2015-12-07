package edu.iut.gui.widget.agenda;

import javax.swing.JLabel;

import edu.iut.app.ExamEvent;

// TODO: Auto-generated Javadoc
/**
 * La classe JLabelEvent.
 */
public class JLabelEvent extends JLabel{
	
	/** L'examEvent. */
	ExamEvent ee;
	
	/**
	 * Crée un JLabelEvent.
	 *
	 * @param ee l'examEvent
	 */
	JLabelEvent(ExamEvent ee){
		this.ee = ee;
	}
	
	/**
	 * Obtenir l'examEvent
	 *
	 * @return l'exam event
	 */
	public ExamEvent getExamEvent(){
		return ee;
	}
}
