package model;

public class Float extends TypeDeBase {
	private static Float instance = new Float();

	// Singleton constructeur priv�
	private Float() {}
	
	public static Float getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "float";
	}
}
