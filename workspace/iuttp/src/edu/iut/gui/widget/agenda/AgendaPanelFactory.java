package edu.iut.gui.widget.agenda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.iut.gui.widget.agenda.WeekPanel.WeekDayNames;

// TODO: Auto-generated Javadoc
/**
 * La classe AgendaPanelFactory.
 */
public class AgendaPanelFactory {

	/**
	 * l'enumeration des vues
	 */
	public enum ActiveView{
		
		/** La vue par mois. */
		MONTH_VIEW("Month View"),
		
		/** La vue par semaine. */
		WEEK_VIEW("Week View"),
		
		/** La vue par joue. */
		DAY_VIEW("Day View");
		
		private String activeView;
		
		/**
		 * Crée une nouveau vue active
		 *
		 * @param activeView la vue active
		 */
		ActiveView(String activeView) {
			this.activeView = activeView;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return activeView;
		}		
	}
	
	/**
	 * Crée un nouvel agenda panel factory.
	 */
	public AgendaPanelFactory() {
	}
	
	/**
	 * Obtenir la vue de l'agenda
	 *
	 * @param activeView la vue active
	 * @return la vue de l'agenda
	 */
	public JPanel getAgendaView(ActiveView activeView) {
		JPanel agendaView = null;
		switch (activeView) {
			case MONTH_VIEW:
				MonthPanel monthPanel = new MonthPanel();
				agendaView = monthPanel;
				break;
			case WEEK_VIEW:
				WeekPanel weekPanel = new WeekPanel();
				agendaView = weekPanel;
				break;
			case DAY_VIEW:
				DayPanel dayPanel = new DayPanel(activeView,WeekDayNames.EMPTYDAY,null);
				agendaView = dayPanel;
				break;
			default:
				break;				
		}
		return agendaView;
	}

}
