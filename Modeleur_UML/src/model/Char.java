package model;

public class Char extends TypeDeBase {
	private static Char instance = new Char();

	// Singleton constructeur privé
	private Char() {}
	
	public static Char getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "char";
	}
}
