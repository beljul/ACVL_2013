package controller;

import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import view.ModifyMultiplicites;

import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.LienMultiple;
import model.Multiplicite;

public class SelectLinkView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public SelectLinkView(Classifieur classifieur, Classifieur classifieur2, DiagrammeClasses dc) {
		this.selection = classifieur;
		this.diagClasses = dc;
		DiagrammeClassesController controlerDC = new DiagrammeClassesController(dc.getView(), dc);
		ClassifieurController controlerC1 = new ClassifieurController(classifieur.getView(), classifieur);
		ClassifieurController controlerC2 = new ClassifieurController(classifieur2.getView(), classifieur2);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		Classe c1 = (Classe) selection;
		Classe c2 = (Classe) classifieur2;


		Set<LienMultiple> links = new HashSet<LienMultiple>();
		Set<Multiplicite> mults1 = new HashSet<Multiplicite>();
		Set<Multiplicite> mults2 = new HashSet<Multiplicite>();

		ButtonGroup group = new ButtonGroup();
		for (Multiplicite mult1 : c1.getMultiplicites()) {
			for (Multiplicite mult2 : c2.getMultiplicites()) {
				if(mult1.getLien().equals(mult2.getLien())) {
					links.add(mult1.getLien());
					mults1.add(mult1);
					mults2.add(mult2);
					JRadioButton rb = new JRadioButton(mult1.getLien().toString());
					group.add(rb);
					panel.add(rb);
				}
			}

		}

		int result = JOptionPane.showConfirmDialog(null, panel, "Suppression de liens",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
//			Set<LienMultiple> linksToDelete = new HashSet<LienMultiple>();
//			Set<Multiplicite> multToDelete1 = new HashSet<Multiplicite>();
//			Set<Multiplicite> multToDelete2 = new HashSet<Multiplicite>();
			int i = 0;
		    Enumeration<AbstractButton> e = group.getElements();
			while (e.hasMoreElements()) {
				AbstractButton b = e.nextElement();
				if (b.isSelected()) break;
				i++;
			}
//			controlerDC.supprimerLiens(linksToDelete);
			new ModifyMultiplicites(classifieur, classifieur2, (Multiplicite)mults1.toArray()[i], (Multiplicite)mults2.toArray()[i]);
//			controlerC1.modifierMultiplicite((Multiplicite)mults1.toArray()[i]);
//			controlerC2.modifierMultiplicite((Multiplicite)mults2.toArray()[i]);
        } else {
        	// Nothing
        }
	}
}
