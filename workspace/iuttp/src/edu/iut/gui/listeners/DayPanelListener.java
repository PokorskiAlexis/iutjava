package edu.iut.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import edu.iut.app.ExamEvent;
import edu.iut.gui.frames.SchedulerFrame;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving dayPanel events.
 * The class that is interested in processing a dayPanel
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDayPanelListener<code> method. When
 * the dayPanel event occurs, that object's appropriate
 * method is invoked.
 *
 * @see DayPanelEvent
 */
public class DayPanelListener implements MouseListener  {

	/** L'ExamEvent. */
	ExamEvent ee;
	
	/**
	 * Crée un nouvelle day panel listener.
	 *
	 * @param ee L'ExamEvent 
	 */
	public DayPanelListener(ExamEvent ee){
		this.ee=ee;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("test");
		SchedulerFrame.me.editEvent.initEditPanel(this.ee);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
