package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

// TODO: Auto-generated Javadoc
/**
 * La classe ControlAgendaViewPanel.
 */
public class ControlAgendaViewPanel extends JPanel {

	/** L'agenda view layout. */
	CardLayout agendaViewLayout;
	
	/** Le panel courant. */
	JPanel contentPane;
	
	/** L'annee selectionn�e. */
	int selectedYear;
	
	/** Le mois selectionn�. */
	int selectedMonth;
	
	/** Le jour selectionn�. */
	int selectedDay;
	
	/**
	 * Cr�e un nouveau control agenda view panel.
	 *
	 * @param layerLayout le layout utilis�(CardLayout)
	 * @param contentPane le panel courant
	 */
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		JPanel dateSelectPanel = new JPanel();
		dateSelectPanel.setLayout(new BoxLayout(dateSelectPanel, BoxLayout.PAGE_AXIS));
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		/** Menu gauche **/		
		SpinnerNumberModel modelYear = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 2010, 2020, 1);		 
		JSpinner spinnerYear = new JSpinner(modelYear);
		
		JComboBox <String> month = new JComboBox<String>(ApplicationSession.instance().getMonths());
		month.setSelectedIndex( Calendar.getInstance().get(Calendar.MONTH));
		JComboBox <String> day = new JComboBox<String> (ApplicationSession.instance().getDays());
		int dayTMP  = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-2;
		day.setSelectedIndex( (dayTMP)<0 ? 6 : (dayTMP));

		dateSelectPanel.add(spinnerYear);
		dateSelectPanel.add(month);
		dateSelectPanel.add(day);
		this.add(dateSelectPanel,BorderLayout.CENTER);
	}
	
	/**
	 * Obtenir l'ann�e.
	 *
	 * @return l'ann�e
	 */
	public int getYear() {
		return selectedYear;
	}
	
	/**
	 * Obtenir le mois
	 *
	 * @return le mois
	 */
	public int getMonth() {
		return selectedMonth;
	}
	
	/**
	 * Obtenir le jour
	 *
	 * @return Le jour
	 */
	public int getDay() {
		return selectedDay;
	}
	
}
