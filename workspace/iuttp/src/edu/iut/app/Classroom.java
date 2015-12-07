package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La Classe Classroom.
 */
public class Classroom {
	
	/**
	 * Cr�e une nouvelle classroom.
	 */
	public Classroom() {
		classRoomNumber="not affected";
	}
	
	/**
	 * Cr�e une nouvelle classroom avec un numero.
	 *
	 * @param classRoomNumber le num�ro de la class (String)
	 */
	public Classroom(String classRoomNumber) {
		/* EX2: AFFECTATION */;
		this.classRoomNumber = classRoomNumber;
	}
	
	/**
	 * Changer le num�ro de la classe.
	 *
	 * @param number the nouveau numero de la classe
	 */
	public void setClassroomNumber(String number) {
		/* EX2: AFFECTATION */;
		classRoomNumber = number;
	}
	
	/**
	 * Obtenir le num�ro de la classe.
	 *
	 * @return Le num�ro de la classe
	 */
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
	
	/** Le numero de la classe. */
	protected String classRoomNumber;
}
