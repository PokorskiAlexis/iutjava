package edu.iut.app;

// TODO: Auto-generated Javadoc
/**
 * La Classe Classroom.
 */
public class Classroom {
	
	/**
	 * Crée une nouvelle classroom.
	 */
	public Classroom() {
		classRoomNumber="not affected";
	}
	
	/**
	 * Crée une nouvelle classroom avec un numero.
	 *
	 * @param classRoomNumber le numéro de la class (String)
	 */
	public Classroom(String classRoomNumber) {
		/* EX2: AFFECTATION */;
		this.classRoomNumber = classRoomNumber;
	}
	
	/**
	 * Changer le numéro de la classe.
	 *
	 * @param number the nouveau numero de la classe
	 */
	public void setClassroomNumber(String number) {
		/* EX2: AFFECTATION */;
		classRoomNumber = number;
	}
	
	/**
	 * Obtenir le numéro de la classe.
	 *
	 * @return Le numéro de la classe
	 */
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
	
	/** Le numero de la classe. */
	protected String classRoomNumber;
}
