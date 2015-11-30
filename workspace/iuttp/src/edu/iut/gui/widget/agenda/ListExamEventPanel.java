package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.iut.app.Agenda;
import edu.iut.app.ExamEvent;

public class ListExamEventPanel extends JPanel{

	Agenda examEvents;	

	public ListExamEventPanel(Agenda examEvents){
		
		this.examEvents = examEvents;
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel editPanel= new JPanel();
		editPanel.setPreferredSize(new Dimension(400,400));
			
		BoxLayout layout = new BoxLayout (panel,BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		JScrollPane scrollPane = new JScrollPane(panel);
		this.add(scrollPane,BorderLayout.WEST);		
		this.add(editPanel,BorderLayout.CENTER);		
		JLabel tmpLabel;
		
		for(ExamEvent event : examEvents){
			tmpLabel= new JLabel(event.getStudent().getLastname());
			tmpLabel.setPreferredSize(new Dimension(150,30));
			panel.add(tmpLabel);
		}
	}
}
