package controller;

import view.DiagrammeClassesView;
import view.ApplicationView;
import model.DiagrammeClasses;
import model.Application;

public class ApplicationController {

	private ApplicationView vue;
	private Application modele;
	
	public ApplicationController(ApplicationView environnementView,
			Application modele) {
		this.vue = environnementView;
		this.modele = modele;
	}

}
