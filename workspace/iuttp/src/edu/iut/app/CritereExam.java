package edu.iut.app;

import java.util.ArrayList;

public interface CritereExam <T> {
	public ArrayList<ExamEvent> meetCreterira(ArrayList<ExamEvent> exams, T critere);
}
