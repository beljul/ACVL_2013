package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.AddAttributView;
import view.AddMethodeView;
import view.DeleteAttributView;
import view.DiagrammeClassesView;
import model.Classe;
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
			if (vue.getSelection() != null) {
				modele.supprimerClasse(vue.getSelection());
			}
			else {
				vue.showError("Impossible de supprimer une classe, classe non sélectionnée.");
			}
		}
		else if (action == "Ajouter attribut") {
			if (vue.getSelection() != null) {
				if (vue.getSelection().canHaveAttribut()) {
					new AddAttributView((Classe)vue.getSelection(), modele);
//					vue.showAddAttribut();
					vue.setSelection(null);
				}
				else
					vue.showError("Impossible d'ajouter un attribut à une interface.");
			}
			else {
				vue.showError("Impossible d'ajouter un attribut, classe non sélectionnée.");
			}
				
		}
		else if (action == "Modifier attribut") {
			
		}
		else if (action == "Supprimer attribut(s)") {
			if (vue.getSelection() != null) {
				if (vue.getSelection().canHaveAttribut()) {
					new DeleteAttributView((Classe)vue.getSelection(), modele);
//					vue.showDeleteAttribut();
					vue.setSelection(null);
				}
				else
					vue.showError("Impossible de supprimer un attribut à une interface.");
			}
			else {
				vue.showError("Impossible de supprimer un attribut, classe non sélectionnée.");
			}
		}
		else if (action == "Ajouter méthode") {
			if (vue.getSelection() != null) {
//				vue.showAddMethode();
				new AddMethodeView((Classe)vue.getSelection(), modele);
				vue.setSelection(null);
			}
			else {
				vue.showError("Impossible d'ajouter une méthode, classe non sélectionnée.");
			}
		}
		
	}

}
