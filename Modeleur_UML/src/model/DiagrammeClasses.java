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
	
	public DiagrammeClasses() {
		super();
		this.classifieurs = new HashSet<Classifieur>();
	}
	
	public void ajouterClasse() {
		Classe c = new Classe(false);
		classifieurs.add(c);
	    view.ajouterClass(c);
	}
	
	public void modifierClasse(Classe c) {
		System.out.println("Modif de la classe : " + c.getNom());
	}
	
	public void supprimerClasse(Classe c) {
		System.out.println("Suppression de la classe : " + c.getNom());
	}
	
	public Set<Classifieur> getClassifieurs () {
		return this.classifieurs;
	}
	public static void main(String args[])
    {
        DiagrammeClasses modele = new DiagrammeClasses();
		view = new DiagrammeClassesView(modele);
    }
	
}
