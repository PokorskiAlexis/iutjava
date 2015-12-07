package edu.iut.app;

import java.util.Date;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La Classe de CritereDate.
 */
public class CritereDate implements CritereExam<Date> {


	/* (non-Javadoc)
	 * @see edu.iut.app.CritereExam#meetCreterira(java.util.ArrayList, java.lang.Object)
	 */
	@Override
	public ArrayList<ExamEvent> meetCreterira(ArrayList<ExamEvent> exams, Date critere) {
		ArrayList<ExamEvent> criteredExam = new ArrayList<ExamEvent>();
		for(ExamEvent exam : exams){
			if(exam.getExamDate().equals(critere)){
				criteredExam.add(exam);
			}
		}
		return criteredExam;
	}
}
