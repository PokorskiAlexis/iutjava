package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;

import edu.iut.app.Agenda;
import edu.iut.app.ApplicationSession;
import edu.iut.app.Classroom;
import edu.iut.app.Document;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.EditExamEvent;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.tools.IUTScheduler;


// TODO: Auto-generated Javadoc
/**
 * La classe SchedulerFrame.
 */
public class SchedulerFrame extends JFrame {
	
	/** Liste des personnes du jury. */
	public ArrayList<Person> personsJury;
	
	/** Liste d'eleve. */
	public ArrayList<Person> eleves;
	
	/** Un splitpanel. */
	JSplitPane splitPane2;
	
	/** Un splitpanel. */
	JSplitPane splitPane;
	
	/** Un JPanel. */
	JPanel contentPane;
	
	/** Un layout. */
	CardLayout layerLayout;
	
	/** Un AgendaPanelFactory */
	AgendaPanelFactory agendaPanelFactory;	
	
	/** Le panel des vues par jours */
	JPanel dayView;
	
	/** Le panel des vues par semaines. */
	JPanel weekView;
	
	/** Le panel des vues par mois. */
	JPanel monthView;
	
	/** Un EditExamEvent. */
	public EditExamEvent editEvent;
	
	/** Le bar menu */
	JMenuBar menuBar = new JMenuBar();
	
	/** Le bouton file. */
	JMenu file = new JMenu("File");
	
	/** Le bouton modifier. */
	JMenu edit = new JMenu("Edit");
	
	/** Le bouton Aide. */
	JMenu help = new JMenu("Help");
	
	/** The me. */
	public static SchedulerFrame me;
	
	/**
	 * Initialisation des tests.
	 */
	public void initTest(){
		//Quelques données ajoutées pour démonstration
		personsJury = new ArrayList<Person>();
		personsJury.add(new Person(Person.PersonFunction.JURY,"Jury1","Jury1lastname","Jury1@u-psud.fr","0607080901"));
		personsJury.add(new Person(Person.PersonFunction.JURY,"Jury2","Jury2lastname","Jury2@u-psud.fr","0607080901"));
		personsJury.add(new Person(Person.PersonFunction.JURY,"Jury3","Jury3lastname","Jury3@u-psud.fr","0607080901"));
		personsJury.add(new Person(Person.PersonFunction.JURY,"Jury4","Jury4lastname","Jury4@u-psud.fr","0607080901"));
		eleves = new ArrayList<Person>();
		eleves.add(new Person(Person.PersonFunction.STUDENT,"Eleve1","Eleve1lastname","eleve1@u-psud.fr","0607080901"));
		eleves.add(new Person(Person.PersonFunction.STUDENT,"Eleve2","Eleve2lastname","eleve2@u-psud.fr","0607080901"));
		eleves.add(new Person(Person.PersonFunction.STUDENT,"Eleve3","Eleve3lastname","eleve3@u-psud.fr","0607080901"));
		eleves.add(new Person(Person.PersonFunction.STUDENT,"Eleve4","Eleve4lastname","eleve4@u-psud.fr","0607080901"));
	
	}
	
	/**
	 * Test.
	 */
	public void test(){
		initNewEditExam();
		//Test avec un exam existant, et un exam null (un nouveau)
		/*ExamEvent ee = new ExamEvent();
		ee.setClassroom(new Classroom("12B"));
		ee.setStudent(eleves.get(2));
		Date test;
		ee.setExamDate(new Date(2015,12-1,06-1));
		ArrayList<Person> jury = new ArrayList<Person>();
		ArrayList<Document> docs = new ArrayList<Document>();
		jury.add(personsJury.get(1));
		jury.add(personsJury.get(2));
		ee.setJury(jury);
		docs.add(new Document("c:\\doc.txt"));
		docs.add(new Document("c:\\doc2.txt"));
		ee.setDocuments(docs);
		editEvent.initEditPanel(ee);
		*/
		editEvent.initEditPanel(null);
	}
	
	/**
	 * Setup ui.
	 */
	protected void setupUI() {
		initTest();
		JScrollPane paneEdit = new JScrollPane();
		me = this;
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
	
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
		
		this.splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,contentPane,null);				
		this.splitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, splitPane2);
		
		this.setContentPane(splitPane);

		
		Calendar cal = new GregorianCalendar();
		System.out.println(cal.getTime());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenu menu2;
		JMenuItem menuItem;
		
		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
		menu = new JMenu(ApplicationSession.instance().getString("file"));
		menuItem= new JMenuItem(ApplicationSession.instance().getString("load"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalité n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("save"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalité n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("quit"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalité n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuBar.add(menu);
		
		menu = new JMenu(ApplicationSession.instance().getString("edit"));
		menuItem= new JMenuItem("Add ExamEvent (test)");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				test();
			}			
		});
		menu.add(menuItem);
		menu2 = new JMenu(ApplicationSession.instance().getString("view"));
		menuItem= new JMenuItem(ApplicationSession.instance().getString("month"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name());
			}			
		});

		menu2.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("week"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name());
			}			
		});

		menu2.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("day"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane, ActiveView.DAY_VIEW.name());
			}			
		});

		menu2.add(menuItem);
		menu.add(menu2);
		menuBar.add(menu);
		
		menu = new JMenu(ApplicationSession.instance().getString("help"));
		menuItem= new JMenuItem(ApplicationSession.instance().getString("display"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalité n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("about"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalité n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		layerLayout.next(contentPane);
		this.pack();
		
	}

	/**
	 * Initialisation d'un edit exam.
	 *
	 * @return the edits un EditExamEvent
	 */
	public EditExamEvent initNewEditExam(){
		this.editEvent = new EditExamEvent();
		this.editEvent.setPreferredSize(new Dimension(350,500));
		splitPane2.setRightComponent(this.editEvent);
		this.pack();
		return this.editEvent;
	}
	
	/**
	 * Crée une nouvelle fenetre d'agenda
	 */
	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}
	
	/**
	 * Crée une nouvelle fenetre d'agenda.
	 *
	 * @param title un titre
	 */
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	
}
