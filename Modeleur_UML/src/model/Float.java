package model;

public class Float extends TypeDeBase {
	private static Float instance = new Float();

	// Singleton constructeur privé
	private Float() {}
	
	public static Float getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "float";
	}
}
