package controller;

import java.util.Set;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.Type;
import model.Visibilite;
import view.ClassifieurView;

public class ClassifieurController {
	private Classifieur modele;
	private ClassifieurView vue;
	
	public ClassifieurController(ClassifieurView classeView, Classifieur c) {
		super();
		this.modele = c;
		this.vue = classeView;
	}

	public String getClasseNom() {
		return modele.getNom();
	}

	public void setClasseNom(String name) {
		this.modele.setNom(name);
	}
	
	public void updateView() {
		vue.repaint();
	}

	public void ajouterAttribut(Visibilite visibilite, Type type, String nom) {
		Classe c = (Classe) modele;
		c.ajouterAttribut(visibilite, type, nom);
		this.updateView();
	}

	public void supprimetAttributs(Set<Attribut> attributsToDelete) {
		Classe c = (Classe) modele;
		for (Attribut attribut : attributsToDelete) {
			c.supprimerAttribut(attribut);
		}
		this.updateView();
		
	}
	
	
}
