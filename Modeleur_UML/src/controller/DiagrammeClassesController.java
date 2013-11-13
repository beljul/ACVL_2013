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
import view.SelectAttributView;
import view.ModifyClassView;
import view.SelectLinksView;
import view.SelectMethodeView;
import model.Classe;
import model.DiagrammeClasses;
import model.LienMultiple;

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
			if (vue.getSelection() != null) {
				new ModifyClassView(vue.getSelection(), modele);
			}
			else {
				vue.showError("Impossible de modifier une classe, classe non sélectionnée.");
			}
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
			if (vue.getSelection() != null) {
				if (vue.getSelection().canHaveAttribut()) {
					new SelectAttributView((Classe)vue.getSelection(), modele);
					vue.setSelection(null);
				}
				else
					vue.showError("Impossible de modifier un attribut à une interface.");
			}
			else {
				vue.showError("Impossible de modifier un attribut, classe non sélectionnée.");
			}
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
		else if (action == "Modifier méthode") {
			if (vue.getSelection() != null) {
					new SelectMethodeView(vue.getSelection(), modele, false, true);
					vue.setSelection(null);
			}
			else {
				vue.showError("Impossible de modifier une méthode, classe non sélectionnée.");
			}
		}
		else if (action == "Ajouter méthode") {
			if (vue.getSelection() != null) {
//				vue.showAddMethode();
				new AddMethodeView(vue.getSelection(), modele);
				vue.setSelection(null);
			}
			else {
				vue.showError("Impossible d'ajouter une méthode, classe non sélectionnée.");
			}
		}
		else if (action == "Supprimer méthode(s)") {
			if (vue.getSelection() != null) {
				new DeleteMethodeView(vue.getSelection(), modele);
				vue.setSelection(null);			
			}
			else {
				vue.showError("Impossible de supprimer une méthode, classe non sélectionnée.");
			}
		}
		else if (action == "Ajouter paramètre") {
			if (vue.getSelection() != null) {
				if (!vue.getSelection().getMethodes().isEmpty()) {
					new SelectMethodeView(vue.getSelection(), modele, true, false);
					vue.setSelection(null);
				}
				else {
					vue.showError("Impossible d'ajouter un paramètre, aucune méthode existante");
				}
			}
			else {
				vue.showError("Impossible d'ajouter un paramètre, classe non sélectionnée.");
			}
		}
		else if (action == "Modifier paramètre") {
			if (vue.getSelection() != null) {
				if (!vue.getSelection().getMethodes().isEmpty()) {
					new SelectMethodeView(vue.getSelection(), modele, true, true);
					vue.setSelection(null);
				}
				else {
					vue.showError("Impossible de supprimer un paramètre, aucune méthode existante");
				}
			}
			else {
				vue.showError("Impossible de supprimer un paramètre, classe non sélectionnée.");
			}
		}
		else if (action == "Supprimer paramètre(s)") {
			if (vue.getSelection() != null) {
				if (!vue.getSelection().getMethodes().isEmpty()) {
					new SelectMethodeView(vue.getSelection(), modele, false, false);
					vue.setSelection(null);
				}
				else {
					vue.showError("Impossible de supprimer un paramètre, aucune méthode existante");
				}
			}
			else {
				vue.showError("Impossible de supprimer un paramètre, classe non sélectionnée.");
			}
		}
		else if (action == "Ajouter lien d'association simple") {
			if(vue.getSelection() != null && vue.getSecondSelection() != null) {
				if(vue.getSelection().canHaveAttribut() && vue.getSecondSelection().canHaveAttribut())
					modele.ajouterLienAssociationSimple(vue.getSelection(), vue.getSecondSelection());
				else
					vue.showError("Impossible d'ajouter un lien, ceci n'est ou ne sont pas des classes.");
			}
			else {
				vue.showError("Impossible d'ajouter un lien, vous devez sélectionner deux classes.");
			}
		}
		else if (action == "Modifier multiplicités/rôles") {
			if(vue.getSelection() != null) {
				if(vue.getSelection().canHaveAttribut() && vue.getSecondSelection().canHaveAttribut())
					new SelectLinkView(vue.getSelection(), vue.getSecondSelection(), modele);
				else
					vue.showError("Impossible de modifier les multiplicités/rôles, ceci n'est ou ne sont pas des classes.");
			}
			else {
				vue.showError("Impossible de modifier les multiplicités/rôles, vous devez sélectionner deux classes.");
			}
		}
		else if (action == "Supprimer lien(s)") {
			if(vue.getSelection() != null && vue.getSecondSelection() != null) {
				if(vue.getSelection().canHaveAttribut() && vue.getSecondSelection().canHaveAttribut())
					new SelectLinksView(vue.getSelection(), vue.getSecondSelection(), modele);
				else
					vue.showError("Impossible de supprimer des lien(s), ceci n'est ou ne sont pas des classes.");
			}
			else {
				vue.showError("Impossible de supprimer des lien(s), vous devez sélectionner deux classes.");
			}
		}
		
		
	}

	public void supprimerLiens(Set<LienMultiple> linksToDelete) {
		modele.supprimerLiens(linksToDelete);
	}

}
