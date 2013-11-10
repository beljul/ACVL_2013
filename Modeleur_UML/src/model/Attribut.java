package model;

public class Attribut extends Identifieur {
	private String valeur;
	private boolean estCalcule;
	
	private Visibilite visibilite;
	
	public Attribut(Visibilite visibilite, Type type, String nom) {
		super(type, nom);
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
	
	@Override
	public String toString() {
		return this.getVisibilite().getMotif() + " "+ this.getNom() + " : " + this.getType();
	}
}
