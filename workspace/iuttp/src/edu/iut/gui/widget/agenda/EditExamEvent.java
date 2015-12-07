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

public class EditExamEvent extends JPanel{
    private JButton buttonAjoutJury;
    private JButton buttonSuppJury;
    private JButton buttonSuppDoc;
    private JButton buttonAjoutDoc;
    private JButton buttonConfirmModifs;
    private JButton buttonSupprimerEvent;
    private JComboBox<String> comboBoxDateMois;
    private JComboBox<String> comboBoxDateJours;
    private JLabel labelJury;
    private JLabel labelDocument;
    private JLabel labelDate;
    private JLabel labelEleve;
    private JLabel labelSalle;
    private JSpinner spinnerAnnee;
    private JSpinner spinnerHeure;
    private JSpinner spinnerJour;
    private JList<Document> listDocuments;
    private JList<Person> listJury;
    private DefaultListModel<Document> listModelDocument;
    private DefaultListModel<Person> listModelJury;
    
	private JComboBox<Person> listEleve;
	private DefaultComboBoxModel<Person> listModelEleve;
	
    private JTextField textFieldNomEleve;
    private JTextField textFieldSalle;
 
    private JScrollPane scrollpaneJury;
    private JScrollPane scrollpaneDocs;
    private EditExamEvent me;
    private boolean newEvent = false;
    private ExamEvent currentExamEvent;
    public EditExamEvent(){
    	me = this;
    }

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
    public void initDate(){
    	spinnerJour.setValue(currentExamEvent.getExamDate().getDate());
    	spinnerHeure.setValue(currentExamEvent.getExamDate().getHours());
    	spinnerAnnee.setValue(currentExamEvent.getExamDate().getYear());
    }
    public void initJury(){        
    	for (Person x : currentExamEvent.getJury()){
    		listModelJury.addElement(x);
    	}
    }
    public void initNomEleve(){
		for (Person x : SchedulerFrame.me.eleves){
			listModelEleve.addElement(x);
		}
		listModelEleve.setSelectedItem(currentExamEvent.getStudent());
    }
    public void initDocs(){
        
    	for (Document x : currentExamEvent.getDocuments()){
    		listModelDocument.addElement(x);
    	}
    }

	public void addJury(Person p) {		
		listModelJury.addElement(p);		
	}
	public void addDocument(String s){
		listModelDocument.addElement(new Document(s));
	}
	
}

    