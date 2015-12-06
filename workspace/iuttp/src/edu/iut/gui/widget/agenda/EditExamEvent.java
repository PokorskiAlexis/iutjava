package edu.iut.gui.widget.agenda;

import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import edu.iut.app.ApplicationSession;

public class EditExamEvent extends JPanel{
	JComboBox<String> month;
	JSpinner spinnerYear ;
	JComboBox <String> day;
	public EditExamEvent(){
		this.setLayout( new BoxLayout (this,BoxLayout.Y_AXIS));
		SpinnerNumberModel modelYear = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 2010, 2020, 1);		 
		spinnerYear = new JSpinner(modelYear);
		this.add(spinnerYear);
		
		month = new JComboBox<String>(ApplicationSession.instance().getMonths());
		month.setSelectedIndex( Calendar.getInstance().get(Calendar.MONTH));
		day = new JComboBox<String> (ApplicationSession.instance().getDays());
		int dayTMP  = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-2;
		day.setSelectedIndex( (dayTMP)<0 ? 6 : (dayTMP));
		this.add(month);
		this.add(day);
	}
}
