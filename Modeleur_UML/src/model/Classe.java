package model;

public class Classe extends Classifieur {

	private static int nb = 0;
	
	public Classe(boolean isAbstract) {
		super();
		++nb;
		this.setNom((isAbstract) ? "Default Abstract Class" : "Default Class" + nb);
	}
	
}
