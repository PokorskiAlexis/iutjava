package edu.iut.gui.widget.agenda;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.iut.gui.listeners.DayPanelListener;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.gui.widget.agenda.WeekPanel.WeekDayNames;

public class DayPanel extends EventPanel {

	public DayPanel(ActiveView activeView,WeekDayNames weekDayNames,Object daynum) {
		super(activeView);
		switch (activeView) {
		case DAY_VIEW:
		case WEEK_VIEW:
			GridLayout daysLayout;
			switch(weekDayNames) {
			case EMPTYDAY:
				daysLayout = new GridLayout(24,1);
				this.setLayout(daysLayout);
				break;
			default:
				daysLayout = new GridLayout(25,1);
				this.setLayout(daysLayout);
				this.add(new JLabel(weekDayNames.toString()));
			}
						
			for (int hi = 0;hi<24;hi++) {
				JPanel hour = new JPanel();
				hour.add(new JLabel(new Integer(hi).toString()));
				this.add(hour);
			}
			break;
		case MONTH_VIEW:
			JPanel hour = new JPanel();
			hour.setLayout((new BoxLayout(hour, BoxLayout.Y_AXIS)));
			hour.add(new JLabel(Integer.toString((int)daynum)));
			DayPanelListener d1 = null ;
			JLabelEvent l1 = new JLabelEvent(null);
			l1.addMouseListener(new DayPanelListener(l1.getExamEvent()));
			JLabelEvent l2 = new JLabelEvent(null);
			l2.addMouseListener(new DayPanelListener(l2.getExamEvent()));
			JLabelEvent l3 = new JLabelEvent(null);
			l3.addMouseListener(new DayPanelListener(l3.getExamEvent()));
			JLabelEvent l4 = new JLabelEvent(null);
			l4.addMouseListener(new DayPanelListener(l4.getExamEvent()));
			JLabelEvent l5 = new JLabelEvent(null);
			l5.addMouseListener(new DayPanelListener(l5.getExamEvent()));
			JLabelEvent l6 = new JLabelEvent(null);
			l6.addMouseListener(new DayPanelListener(l6.getExamEvent()));

			hour.add(l1);
			hour.add(l2);
			hour.add(l3);
			hour.add(l4);
			hour.add(l5);
			hour.add(l6);
			this.add(hour);
			
		}
	}
	
	protected void setupUIDayView() {
		
	}
	protected void setupUIWeekView() {
		
	}
	protected void setupUIMonthView() {
		
	}


}
