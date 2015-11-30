package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
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
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;

import edu.iut.app.Agenda;
import edu.iut.app.ApplicationSession;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.gui.widget.agenda.ListExamEventPanel;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	JMenu help = new JMenu("Help");
	SchedulerFrame me;
	protected void setupUI() {
		
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
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
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
				JOptionPane.showMessageDialog(me, "Cette fonctionnalit� n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("save"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalit� n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("quit"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalit� n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuBar.add(menu);
		
		menu = new JMenu(ApplicationSession.instance().getString("edit"));
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
				//JOptionPane.showMessageDialog(me, "Cette fonctionnalit� n'est encore disponible.");
				  JFrame fenetre = new JFrame();
	                
				    //D�finit un titre pour notre fen�tre
				    fenetre.setTitle("Ma premi�re fen�tre Java");
				    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
				    fenetre.setSize(200	, 400);
				    //Nous demandons maintenant � notre objet de se positionner au centre
				    fenetre.setLocationRelativeTo(null);
				    //Termine le processus lorsqu'on clique sur la croix rouge
				    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    Agenda tmpagenda = new Agenda();
				    ExamEvent examtmp = new ExamEvent();
				    examtmp.setStudent(new Person(null, "", "GrossePute", "", ""));
				    
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);tmpagenda.add(examtmp);
				    
				    
				    fenetre.setContentPane(new ListExamEventPanel(tmpagenda));
				    //Et enfin, la rendre visible        
				    fenetre.setVisible(true);
			}			
		});

		menu.add(menuItem);
		menuItem= new JMenuItem(ApplicationSession.instance().getString("about"));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(me, "Cette fonctionnalit� n'est encore disponible.");
			}			
		});

		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
	}
	
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
