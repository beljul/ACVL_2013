package controller;

import model.Classe;
import model.Classifieur;
import view.ClassifieurView;

public class ClassifieurController {
	private Classifieur classe;
	private ClassifieurView classeView;
	
	public ClassifieurController(ClassifieurView classeView, Classifieur c) {
		super();
		this.classe = c;
		this.classeView = classeView;
	}

	public String getClasseNom() {
		return classe.getNom();
	}

	public void setClasseNom(String name) {
		this.classe.setNom(name);
	}
	
	public void updateView() {
		classeView.repaint();
	}
	
	
}
