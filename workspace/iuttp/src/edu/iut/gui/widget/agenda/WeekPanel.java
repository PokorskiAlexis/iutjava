package edu.iut.gui.widget.agenda;

import java.awt.GridLayout;
import javax.swing.JPanel;


import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.app.ApplicationSession;

// TODO: Auto-generated Javadoc
/**
 * La Classe WeekPanel.
 */
public class WeekPanel extends EventPanel {

	/**
	 * L'enumeration WeekDayNames.
	 */
	public enum WeekDayNames {
		
		/** Jour vide. */
		EMPTYDAY("",""),
		
		/** Le lundi. */
		MONDAY(ApplicationSession.instance().getString("monday"),ApplicationSession.instance().getString("mon")),
		
		/** Le mardi. */
		TUESDAY(ApplicationSession.instance().getString("tuesday"),ApplicationSession.instance().getString("tue")),
		
		/** Le mercredi. */
		WEDNESDAY(ApplicationSession.instance().getString("wednesday"),ApplicationSession.instance().getString("wed")),
		
		/** Le jeudi . */
		THURSDAY(ApplicationSession.instance().getString("thursday"),ApplicationSession.instance().getString("thu")),
		
		/** Le vendredi. */
		FRIDAY(ApplicationSession.instance().getString("friday"),ApplicationSession.instance().getString("fri")),
		
		/** le samedi. */
		SATURDAY(ApplicationSession.instance().getString("saturday"),ApplicationSession.instance().getString("sat")),
		
		/** Le dimanche. */
		SUNDAY(ApplicationSession.instance().getString("sunday"),ApplicationSession.instance().getString("sun"));
		
		/** le nom. */
		private String name;
		
		/** The short name. */
		private String shortName;
		
		/**
		 * Crée un nouveau nom de jours.
		 *
		 * @param name le nom
		 * @param shortName le nom raccourci
		 */
		WeekDayNames(String name,String shortName) {
			this.name = name;
			this.shortName = shortName;
		}
		
		/**
		 * Obtenir le nom raccourci.
		 *
		 * @return le nom raccourci
		 */
		public String getShortName() {
			return shortName;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return name;
		}
	}
	
	/**
	 * Crée le panel des semaines.
	 */
	public WeekPanel() {
		super(ActiveView.WEEK_VIEW);
		GridLayout daysOfWeekLayout = new GridLayout(1,7);		
		this.setLayout(daysOfWeekLayout);
		for (int di = 0;di<7;di++)	{
			this.add(new DayPanel(ActiveView.WEEK_VIEW,WeekDayNames.values()[di+1],null));
		}
	}
}
