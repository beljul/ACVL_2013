package controller;

import java.util.Set;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.Methode;
import model.Parametre;
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

	public void ajouterMethode(Visibilite visibilite, Type type, String nom,
			boolean isAbstract, boolean isStatic) {
		modele.ajouterMethode(visibilite, type, nom, isAbstract, isStatic);
		this.updateView();	
	}

	public void supprimerMethodes(Set<Methode> methodesToDelete) {
		for (Methode methode : methodesToDelete) {
			modele.supprimerMethode(methode);
		}
		this.updateView();
	}

	public void ajouterParametre(Type type, String nom, Methode methode) {
		modele.ajouterParametre(type, nom, methode);
		this.updateView();
	}

	public void supprimerParametres(Set<Parametre> paramsToDelete, Methode methode) {
		for (Parametre param : paramsToDelete) {
			modele.supprimerParam(param, methode);
		}
		this.updateView();
	}
	
}
