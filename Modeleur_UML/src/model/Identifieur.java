package model;

public class Identifieur {
	private String nom;
	private Type type;
	
	public Identifieur(Type type, String nom) {
		this.type = type;
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
