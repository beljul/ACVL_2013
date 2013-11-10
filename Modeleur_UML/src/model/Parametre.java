package model;

public class Parametre {
	private Identifieur identifieur;

	public Parametre(String nom, Type type) {
		super();
		this.identifieur = new Identifieur(type, nom);
	}

	public Identifieur getIdentifieur() {
		return identifieur;
	}

	public void setIdentifieur(Identifieur identifieur) {
		this.identifieur = identifieur;
	}

	@Override
	public String toString() {
		return identifieur.toString();
	}
	
	
	
}
