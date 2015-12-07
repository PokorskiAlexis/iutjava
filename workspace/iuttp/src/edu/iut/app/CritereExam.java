package edu.iut.app;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La classe Interface de CritereExam.
 *
 * @param <T> the generic type
 */
public interface CritereExam <T> {
	

	public ArrayList<ExamEvent> meetCreterira(ArrayList<ExamEvent> exams, T critere);
}
