package model;

import java.util.HashSet;
import java.util.Set;

public class Classe extends Classifieur {

	private static int nb = 0;
	private Set<Attribut> attributs;
	private Set<Multiplicite> multiplicites;
	
	public Classe(boolean isAbstract) {
		super();
		++nb;
		attributs = new HashSet<Attribut>();
		multiplicites = new HashSet<Multiplicite>();
		this.setNom((isAbstract) ? "Default Abstract Class" : "Default Class" + nb);
	}
	
	public Set<Attribut> getAttributs() {
		return attributs;
	}
	
	public void ajouterAttribut(Visibilite visibilite, Type type, String nom) {
		Attribut att = new Attribut(visibilite, type, nom);
		this.attributs.add(att);
	}

	public void modifierAttribut(Visibilite visibilite, Type type, String nom, Attribut att) {
		att.setIdentifieur(new Identifieur(type, nom));
		att.setVisibilite(visibilite);
	}
	
	public void supprimerAttribut(Attribut attribut) {
		this.attributs.remove(attribut);
		--nb;
	}
	
	@Override
	public boolean canHaveAttribut() {
		return true;
	}
	
	public Set<Multiplicite> getMultiplicites() {
		return multiplicites;
	}

	public void supprimerMultiplicites(Set<Multiplicite> multToDelete) {
		for (Multiplicite m : multToDelete) {
			multiplicites.remove(m);
		}
		
	}
}
