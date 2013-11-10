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
import view.DeleteMethodeView;
import view.DiagrammeClassesView;
import view.SelectMethodeView;
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
				vue.showError("Impossible de supprimer une classe, classe non s�lectionn�e.");
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
					vue.showError("Impossible d'ajouter un attribut � une interface.");
			}
			else {
				vue.showError("Impossible d'ajouter un attribut, classe non s�lectionn�e.");
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
					vue.showError("Impossible de supprimer un attribut � une interface.");
			}
			else {
				vue.showError("Impossible de supprimer un attribut, classe non s�lectionn�e.");
			}
		}
		else if (action == "Ajouter m�thode") {
			if (vue.getSelection() != null) {
//				vue.showAddMethode();
				new AddMethodeView(vue.getSelection(), modele);
				vue.setSelection(null);
			}
			else {
				vue.showError("Impossible d'ajouter une m�thode, classe non s�lectionn�e.");
			}
		}
		else if (action == "Supprimer m�thode(s)") {
			if (vue.getSelection() != null) {
				new DeleteMethodeView(vue.getSelection(), modele);
				vue.setSelection(null);			
			}
			else {
				vue.showError("Impossible de supprimer une m�thode, classe non s�lectionn�e.");
			}
		}
		else if (action == "Ajouter param�tre") {
			if (vue.getSelection() != null) {
				if (!vue.getSelection().getMethodes().isEmpty()) {
					new SelectMethodeView(vue.getSelection(), modele, true);
					vue.setSelection(null);
				}
				else {
					vue.showError("Impossible d'ajouter un param�tre, aucune m�thode existante");
				}
			}
			else {
				vue.showError("Impossible d'ajouter un param�tre, classe non s�lectionn�e.");
			}
		}
		else if (action == "Supprimer param�tre(s)") {
			if (vue.getSelection() != null) {
				if (!vue.getSelection().getMethodes().isEmpty()) {
					new SelectMethodeView(vue.getSelection(), modele, false);
					vue.setSelection(null);
				}
				else {
					vue.showError("Impossible de supprimer un param�tre, aucune m�thode existante");
				}
			}
			else {
				vue.showError("Impossible de supprimer un param�tre, classe non s�lectionn�e.");
			}
		}
		
		
	}

}
