package model;

public class Attribut {
	private Identifieur identifieur;
	private String valeur;
	private boolean estCalcule;
	
	private Visibilite visibilite;
	
	public Attribut(Visibilite visibilite, Type type, String nom) {
		identifieur = new Identifieur(type, nom);
		this.visibilite = visibilite;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public boolean isEstCalcule() {
		return estCalcule;
	}
	public void setEstCalcule(boolean estCalcule) {
		this.estCalcule = estCalcule;
	}
	public Visibilite getVisibilite() {
		return visibilite;
	}
	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}
	
	public Identifieur getIdentifieur() {
		return identifieur;
	}
	public void setIdentifieur(Identifieur identifieur) {
		this.identifieur = identifieur;
	}
	@Override
	public String toString() {
		return this.visibilite.getMotif() + " " + this.identifieur.toString();
	}
}
