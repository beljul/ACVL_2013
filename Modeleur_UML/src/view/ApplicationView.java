package view;

import controller.DiagrammeClassesController;
import controller.ApplicationController;
import model.DiagrammeClasses;
import model.Application;

public class ApplicationView {
	private ApplicationController controleur;
	private Application modele;
	
	public ApplicationView(Application modele) {
		this.modele = modele;
		this.controleur = new ApplicationController(this, modele);  
		
		for(DiagrammeClasses dc : modele.getDiagsClasses()) {
			new DiagrammeClassesView(dc);
		}
			
	}

}
