package edu.iut.gui.widget.agenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import edu.iut.app.Agenda;
import edu.iut.app.ApplicationSession;
import edu.iut.app.Classroom;
import edu.iut.app.Document;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.gui.frames.SchedulerFrame;

// TODO: Auto-generated Javadoc
/**
 * La classe EditExamEvent.
 */
public class EditExamEvent extends JPanel{
    
    /** The button ajout jury. */
    private JButton buttonAjoutJury;
    
    /** The button supp jury. */
    private JButton buttonSuppJury;
    
    /** The button supp doc. */
    private JButton buttonSuppDoc;
    
    /** The button ajout doc. */
    private JButton buttonAjoutDoc;
    
    /** The button confirm modifs. */
    private JButton buttonConfirmModifs;
    
    /** The button supprimer event. */
    private JButton buttonSupprimerEvent;
    
    /** The combo box date mois. */
    private JComboBox<String> comboBoxDateMois;
    
    /** The combo box date jours. */
    private JComboBox<String> comboBoxDateJours;
    
    /** The label jury. */
    private JLabel labelJury;
    
    /** The label document. */
    private JLabel labelDocument;
    
    /** The label date. */
    private JLabel labelDate;
    
    /** The label eleve. */
    private JLabel labelEleve;
    
    /** The label salle. */
    private JLabel labelSalle;
    
    /** The spinner annee. */
    private JSpinner spinnerAnnee;
    
    /** The spinner heure. */
    private JSpinner spinnerHeure;
    
    /** The spinner jour. */
    private JSpinner spinnerJour;
    
    /** The list documents. */
    private JList<Document> listDocuments;
    
    /** The list jury. */
    private JList<Person> listJury;
    
    /** The list model document. */
    private DefaultListModel<Document> listModelDocument;
    
    /** The list model jury. */
    private DefaultListModel<Person> listModelJury;
    
	/** The list eleve. */
	private JComboBox<Person> listEleve;
	
	/** The list model eleve. */
	private DefaultComboBoxModel<Person> listModelEleve;
	
    /** The text field nom eleve. */
    private JTextField textFieldNomEleve;
    
    /** The text field salle. */
    private JTextField textFieldSalle;
 
    /** The scrollpane jury. */
    private JScrollPane scrollpaneJury;
    
    /** The scrollpane docs. */
    private JScrollPane scrollpaneDocs;
    
    /** The me. */
    private EditExamEvent me;
    
    /** The new event. */
    private boolean newEvent = false;
    
    /** The current exam event. */
    private ExamEvent currentExamEvent;
    
    /**
     * Crée un nouveau edits the exam event.
     */
    public EditExamEvent(){
    	me = this;
    }

	/**
	 * Initialise le panel de modification d'examevent.
	 *
	 * @param currentExamEvent L'examEvent actuel
	 */
	@SuppressWarnings("unchecked")
	public void initEditPanel(ExamEvent currentExamEvent){
		if(currentExamEvent!=null){
			this.currentExamEvent = currentExamEvent;
			newEvent=false;
		}else{
			this.currentExamEvent = new ExamEvent();
			newEvent=true;
		}
		scrollpaneJury = new JScrollPane();
		scrollpaneDocs = new JScrollPane();
		labelEleve = new JLabel();
	    textFieldNomEleve = new JTextField();
        comboBoxDateMois = new JComboBox<>(ApplicationSession.instance().getMonths());
        comboBoxDateJours = new JComboBox<>(ApplicationSession.instance().getDays());        
		SpinnerNumberModel modelYear = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 2010, 2020, 1);		
		SpinnerNumberModel modelHeure = new SpinnerNumberModel(12, 0, 23, 1);		
		SpinnerNumberModel modelJour = new SpinnerNumberModel(1, 1, 31, 1);		
		spinnerHeure= new JSpinner(modelHeure);	 
		spinnerAnnee= new JSpinner(modelYear);	 
		spinnerJour= new JSpinner(modelJour);	 
		
		labelJury = new JLabel();
        buttonAjoutJury = new JButton();
        buttonSuppJury = new JButton();
        
        labelDocument = new JLabel();
        buttonSuppDoc = new JButton();
        buttonAjoutDoc = new JButton();
        
		listModelDocument = new DefaultListModel<Document>();
		listModelJury = new DefaultListModel<Person>();
		listDocuments = new JList<Document>(listModelDocument);
		listJury = new JList<Person>(listModelJury);
        
        labelDate = new JLabel();
        
        labelSalle = new JLabel();
        textFieldSalle = new JTextField();
       
        buttonConfirmModifs = new JButton();       
        buttonSupprimerEvent = new JButton();

        setLayout(null);
        
        scrollpaneJury.setViewportView(listJury);
        scrollpaneJury.setBounds(30, 140, 150, 60);
        this.add(scrollpaneJury);

        buttonAjoutJury.setText(ApplicationSession.instance().getString("add"));
        buttonAjoutJury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 JFrame tmpFrame = new edu.iut.gui.frames.JuryFrame(SchedulerFrame.me.personsJury,me);
				 tmpFrame.setVisible(true);		 
			}			
		});
              
        buttonAjoutJury.setBounds(180, 170, 120, 20);
        this.add(buttonAjoutJury);       
        
        buttonSuppJury.setText(ApplicationSession.instance().getString("remove"));
        buttonSuppJury.setBounds(180, 140, 120,20);
        buttonSuppJury.addActionListener(new ActionListener() {
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				if(me.listJury.getSelectedIndex() != -1)
  					me.listModelJury.remove(me.listJury.getSelectedIndex());
  				
  			}			
  		});
               
        this.add(buttonSuppJury);

        labelJury.setText(ApplicationSession.instance().getString("jury"));
        labelJury.setBounds(30, 120, 60, 20);
        this.add(labelJury);               
        
        
        scrollpaneDocs.setViewportView(listDocuments);
        scrollpaneDocs.setBounds(30, 240, 150, 60);
        this.add(scrollpaneDocs);

        labelDocument.setText(ApplicationSession.instance().getString("docs"));
        labelDocument.setBounds(30, 220, 120, 20);
        this.add(labelDocument);

        comboBoxDateMois.setBounds(30, 90, 100, 20);
        this.add(comboBoxDateMois); 
        
        spinnerJour.setBounds(130, 90, 50, 20);
        this.add(spinnerJour);
        
        spinnerAnnee.setBounds(180, 90, 50, 20);
        this.add(spinnerAnnee);
        
        spinnerHeure.setBounds(250, 90, 50, 20);
        this.add(spinnerHeure);

        labelDate.setText(ApplicationSession.instance().getString("date"));
        labelDate.setBounds(30, 70, 120, 20);
        this.add(labelDate);       

        buttonSuppDoc.setText(ApplicationSession.instance().getString("remove"));
        buttonSuppDoc.setBounds(180, 240, 120, 20);
        buttonSuppDoc.addActionListener(new ActionListener() {
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				if(me.listDocuments.getSelectedIndex() != -1)
  					me.listModelDocument.remove(me.listDocuments.getSelectedIndex());
  			}			
  		});
        this.add(buttonSuppDoc);

        buttonAjoutDoc.setText(ApplicationSession.instance().getString("add"));
        buttonAjoutDoc.setBounds(180, 270, 120, 20);
        buttonAjoutDoc.addActionListener(new ActionListener() {
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  		        String chemin;
  		        JFileChooser chooser = new JFileChooser();
	  		     int returnVal = chooser.showOpenDialog(null);
	  		     if(returnVal == JFileChooser.APPROVE_OPTION) {
	  		    	  addDocument(chooser.getSelectedFile().getAbsolutePath());	  	

  		        }
  				
  			}			
  		});
        this.add(buttonAjoutDoc);

        labelEleve.setText(ApplicationSession.instance().getString("student"));
        labelEleve.setBounds(30, 20, 120,20);        
        this.add(labelEleve);     
        
        
	
		listModelEleve = new DefaultComboBoxModel<Person>();
		listEleve = new JComboBox<Person>(listModelEleve);    
		listEleve.setBounds(30, 40, 150, 20);        
		this.add(listEleve);
        

        buttonConfirmModifs.setText(ApplicationSession.instance().getString("confirEdit"));
        buttonConfirmModifs.setBounds(30, 380, 250, 20);    
        buttonConfirmModifs.addActionListener(new ActionListener() {
   			@Override
   			public void actionPerformed(ActionEvent arg0) {  				
   				confirModif();   				
   			}			
   		});
        this.add(buttonConfirmModifs);
        
        labelSalle.setText(ApplicationSession.instance().getString("classroom"));
        labelSalle.setBounds(30, 320, 120, 10);   
        this.add(labelSalle);        
        
        textFieldSalle.setText(this.currentExamEvent.getClassroom().getClassRoomNumber());
        textFieldSalle.setBounds(30, 340, 130, 20);   
        this.add(textFieldSalle);

        buttonSupprimerEvent.setText(ApplicationSession.instance().getString("remove"));
        buttonSupprimerEvent.setBounds(30, 410, 250, 20);
        buttonSupprimerEvent.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent arg0) {  				
    				Agenda.instance().remove(currentExamEvent);
    			}			
    		});
        this.add(buttonSupprimerEvent);
            initDocs();
	        initDate();
	        initJury();           
	        initNomEleve();   	
	}
	
	/**
	 * Bouton Confirmation des modification.
	 */
	public void confirModif(){
		
		
		try{	
			currentExamEvent.setStudent((Person) listEleve.getSelectedItem());
			currentExamEvent.setClassroom(new Classroom(textFieldSalle.getText()));
			currentExamEvent.getDocuments().clear();
			for(int i=0;i<listModelDocument.size();i++){
				currentExamEvent.getDocuments().add(listModelDocument.getElementAt(i));
			}
			currentExamEvent.getJury().clear();
			for(int i=0;i<listModelJury.size();i++){
				currentExamEvent.getJury().add(listModelJury.getElementAt(i));
			}
			System.out.println("");
			currentExamEvent.setExamDate(new Date((int)spinnerAnnee.getValue(),comboBoxDateMois.getSelectedIndex(),(int)spinnerJour.getValue(),(int)spinnerHeure.getValue(),0));
			if(newEvent){
				newEvent=false;
				Agenda.instance().add(currentExamEvent);
			}
		}catch(Exception e){
			System.out.println("Erreur");
		}
		
	}
    
    /**
     * Initialise la date.
     */
    public void initDate(){
    	spinnerJour.setValue(currentExamEvent.getExamDate().getDate());
    	spinnerHeure.setValue(currentExamEvent.getExamDate().getHours());
    	spinnerAnnee.setValue(currentExamEvent.getExamDate().getYear());
    }
    
    /**
     * Initialise le jury.
     */
    public void initJury(){        
    	for (Person x : currentExamEvent.getJury()){
    		listModelJury.addElement(x);
    	}
    }
    
    /**
     * Initialise les eleves.
     */
    public void initNomEleve(){
		for (Person x : SchedulerFrame.me.eleves){
			listModelEleve.addElement(x);
		}
		listModelEleve.setSelectedItem(currentExamEvent.getStudent());
    }
    
    /**
     * Initialise les documents.
     */
    public void initDocs(){
        
    	for (Document x : currentExamEvent.getDocuments()){
    		listModelDocument.addElement(x);
    	}
    }

	/**
	 * Ajoute un jury
	 *
	 * @param p le jury(personne)
	 */
	public void addJury(Person p) {		
		listModelJury.addElement(p);		
	}
	
	/**
	 * Ajoute un documents
	 *
	 * @param s une chaine de caractère(PATH)
	 */
	public void addDocument(String s){
		listModelDocument.addElement(new Document(s));
	}
	
}

    