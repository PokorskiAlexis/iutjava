package edu.iut.app;

import java.util.ArrayList;

public class CriterePersonne implements CritereExam<Person> {

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
