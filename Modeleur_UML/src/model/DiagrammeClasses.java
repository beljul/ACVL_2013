package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import view.ClassifieurView;
import view.DiagrammeClassesView;

public class DiagrammeClasses {
	private Set<Classifieur> classifieurs;
	private Set<Lien> liens;
	private static DiagrammeClassesView view;
	private Environnement env;

	public DiagrammeClasses(Environnement environnement) {
		super();
		this.classifieurs = new HashSet<Classifieur>();
		this.liens = new HashSet<Lien>();
		this.env = environnement;
	}
	
	public static DiagrammeClassesView getView() {
		return view;
	}

	public static void setView(DiagrammeClassesView view) {
		DiagrammeClasses.view = view;
	}
	
	public void ajouterClasse() {
		Classe c = new Classe(false);
		this.classifieurs.add(c);
		env.addTypesEnv(c);
	    view.ajouterClass(c);
	}
	
	public void modifierClasse(Classe c) {
		System.out.println("Modif de la classe : " + c.getNom());
	}
	
	public void supprimerClasse(Classifieur classifieur) {
		if (classifieur.canHaveAttribut()) {
			Classe c = (Classe) classifieur;
			for (Multiplicite mult : c.getMultiplicites()) {
				this.liens.remove(mult.getLien());
				view.supprimerLien(mult.getLien());
			}
		}
		this.classifieurs.remove(classifieur);
		view.supprimerClass(classifieur);
	}
	
	public Set<Classifieur> getClassifieurs () {
		return this.classifieurs;
	}
	
	public Environnement getEnv() {
		return env;
	}

	public void setEnv(Environnement env) {
		this.env = env;
	}

	public Set<Lien> getLiens() {
		return liens;
	}

	public void ajouterLienAssociationSimple(Classifieur selection,
			Classifieur secondSelection) {
		AssociationSimple as = new AssociationSimple((Classe)selection, (Classe)secondSelection);
		liens.add(as);
		view.ajouterLienAssociationSimple(as);
	}
	
	
}
