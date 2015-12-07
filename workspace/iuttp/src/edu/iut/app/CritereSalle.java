package edu.iut.app;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La classe de CritereSalle.
 */
public class CritereSalle implements CritereExam<Classroom> {

	/* (non-Javadoc)
	 * @see edu.iut.app.CritereExam#meetCreterira(java.util.ArrayList, java.lang.Object)
	 */
	@Override
	public ArrayList<ExamEvent> meetCreterira(ArrayList<ExamEvent> exams, Classroom critere) {
		ArrayList<ExamEvent> criteredExam = new ArrayList<ExamEvent>();
		for(ExamEvent exam : exams){
			if(exam.getClassroom() == (critere)){
				criteredExam.add(exam);
			}
		}
		return criteredExam;
	}

}
