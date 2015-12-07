package edu.iut.app;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La Classe de CriterePersonne.
 */
public class CriterePersonne implements CritereExam<Person> {

	/* (non-Javadoc)
	 * @see edu.iut.app.CritereExam#meetCreterira(java.util.ArrayList, java.lang.Object)
	 */
	@Override
	public ArrayList<ExamEvent> meetCreterira(ArrayList<ExamEvent> exams, Person critere) {
		ArrayList<ExamEvent> criteredExam = new ArrayList<ExamEvent>();
		for(ExamEvent exam : exams){
			if(exam.getStudent() == (critere)){
				criteredExam.add(exam);
			}
		}
		return criteredExam;
	}

}
