package model;

public class MyString extends TypeDeBase {
	private static MyString instance = new MyString();

	// Singleton constructeur privé
	private MyString() {}
	
	public static MyString getInstance() {
		return instance;
	}

	@Override
	public String getNom() {
		return "string";
	}
}
