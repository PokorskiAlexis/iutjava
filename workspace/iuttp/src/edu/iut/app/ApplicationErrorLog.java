package edu.iut.app;

public class ApplicationErrorLog extends AbstractApplicationLog {

	/** Ajouter un tableau ou profiter de l'héritage ? :  Profiter de l'heritage*/
	public ApplicationErrorLog() {
		super();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[ERROR]", this.message);
	}

	@Override
	public void addListener(IApplicationLogListener listener) {
		// TODO Auto-generated method stub
		
	}

}
