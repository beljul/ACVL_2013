package model;

public class Bool extends TypeDeBase {
	private static Bool instance = new Bool();

	// Singleton constructeur privé
	private Bool() {}
	
	public static Bool getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "boolean";
	}
}
