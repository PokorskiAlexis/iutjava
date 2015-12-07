package edu.iut.gui.widget.agenda;

import javax.swing.JLabel;

import edu.iut.app.ExamEvent;

public class JLabelEvent extends JLabel{
	
	ExamEvent ee;
	JLabelEvent(ExamEvent ee){
		this.ee = ee;
	}
	public ExamEvent getExamEvent(){
		return ee;
	}
}
