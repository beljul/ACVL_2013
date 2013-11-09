package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DiagrammeClassesView;
import model.DiagrammeClasses;

public class DiagrammeClassesController implements  ActionListener {
	
	private DiagrammeClassesView vue;
	private DiagrammeClasses modele;

	public DiagrammeClassesController(DiagrammeClassesView modeleurView, DiagrammeClasses modele) {
		this.vue = modeleurView;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action == "Ajouter classe") {
			modele.ajouterClasse();
		}
		else if (action == "Modifier classe") {
		}
		else if (action == "Supprimer classe") {
		}
		
	}

}
