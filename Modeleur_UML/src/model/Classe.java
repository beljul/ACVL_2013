package model;

import java.util.HashSet;
import java.util.Set;

public class Classe extends Classifieur {

	private static int nb = 0;
	private Set<Attribut> attributs;

	public Classe(boolean isAbstract) {
		super();
		++nb;
		attributs = new HashSet<Attribut>();
		this.setNom((isAbstract) ? "Default Abstract Class" : "Default Class" + nb);
	}
	
	public Set<Attribut> getAttributs() {
		return attributs;
	}
	
	public void ajouterAttribut(Visibilite visibilite, Type type, String nom) {
		Attribut att = new Attribut(visibilite, type, nom);
		this.attributs.add(att);
	}

	public void supprimerAttribut(Attribut attribut) {
		this.attributs.remove(attribut);
		--nb;
	}
	
	@Override
	public boolean canHaveAttribut() {
		return true;
	}
}
