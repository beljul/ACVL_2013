package model;

public class Double extends TypeDeBase {
	private static Double instance = new Double();

	// Singleton constructeur priv�
	private Double() {}
	
	public static Double getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "double";
	}
}
