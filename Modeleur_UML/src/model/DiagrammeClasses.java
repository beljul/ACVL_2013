package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import view.ClassifieurView;
import view.DiagrammeClassesView;

public class DiagrammeClasses {
	private Set<Classifieur> classifieurs;
	private static DiagrammeClassesView view;
	private Environnement env;

	public DiagrammeClasses(Environnement environnement) {
		super();
		this.classifieurs = new HashSet<Classifieur>();
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
		classifieurs.add(c);
	    view.ajouterClass(c);
	}
	
	public void modifierClasse(Classe c) {
		System.out.println("Modif de la classe : " + c.getNom());
	}
	
	public void supprimerClasse(Classifieur classifieur) {
		classifieurs.remove(classifieur);
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
	
}
