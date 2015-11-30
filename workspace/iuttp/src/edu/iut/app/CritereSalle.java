package edu.iut.app;

import java.util.ArrayList;

public class CritereSalle implements CritereExam<Classroom> {

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
