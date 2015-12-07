package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.iut.app.Person;
import edu.iut.gui.widget.agenda.EditExamEvent;

// TODO: Auto-generated Javadoc
/**
 * La classe JuryFrame.
 */
public class JuryFrame extends JFrame{
	
	/** The me. */
	private JuryFrame me;
	
	/** The list. */
	private JComboBox<Person> list;
	
	/** The list model document. */
	private DefaultComboBoxModel<Person> listModelDocument;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/**
	 * Crée une nouvelle fenêtre listant les jury.
	 *
	 * @param jury le jury
	 * @param panelEvent un panel event
	 */
	public JuryFrame(ArrayList<Person> jury,EditExamEvent panelEvent){
		this.setTitle("Liste des juristes");		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		contentPane.setPreferredSize(new Dimension (200, 70));
		this.setContentPane(contentPane);				
		me = this;
		listModelDocument = new DefaultComboBoxModel<Person>();
		list = new JComboBox<Person>(listModelDocument);
		
		for (Person x : jury){
			listModelDocument.addElement(x);
		}
		
		add(list);
		JButton buttonConfirm = new JButton("Ajouter");
		buttonConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelEvent.addJury(jury.get(list.getSelectedIndex()));
				me.dispose();
			}			
		});
		add(buttonConfirm);
		this.pack();
	}
}
