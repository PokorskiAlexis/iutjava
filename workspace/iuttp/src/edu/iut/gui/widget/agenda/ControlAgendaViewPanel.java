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

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
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
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
