package model;

public class Long extends TypeDeBase {
	private static Long instance = new Long();

	// Singleton constructeur privé
	private Long() {}
	
	public static Long getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "long";
	}
}
