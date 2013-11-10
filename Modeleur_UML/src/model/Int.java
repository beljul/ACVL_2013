package model;

public class Int extends TypeDeBase {
	private static Int instance = new Int();

	// Singleton constructeur privé
	private Int() {}
	
	public static Int getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "int";
	}
}
