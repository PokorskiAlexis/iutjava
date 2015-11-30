package edu.iut.app;

import java.util.Date;
import java.util.ArrayList;

public class CritereDate implements CritereExam<Date> {


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
