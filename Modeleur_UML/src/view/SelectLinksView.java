package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.LienMultiple;
import model.Methode;
import model.Multiplicite;
import model.Visibilite;
import controller.ClassifieurController;
import controller.DiagrammeClassesController;

public class SelectLinksView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public SelectLinksView(Classifieur classifieur, Classifieur classifieur2, DiagrammeClasses dc) {
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

		Set<JCheckBox> checkbox = new HashSet<JCheckBox>();
		for (Multiplicite mult1 : c1.getMultiplicites()) {
			for (Multiplicite mult2 : c2.getMultiplicites()) {
				if(mult1.getLien().equals(mult2.getLien())) {
//					if(!linksToDelete.contains(mult1.getLien())) {
//						linksToDelete.add(mult1.getLien());
//						multToDelete1.add(mult1);
//						multToDelete2.add(mult2);
//					}
					links.add(mult1.getLien());
					mults1.add(mult1);
					mults2.add(mult2);
					JCheckBox cb = new JCheckBox(mult1.getLien().toString());
					checkbox.add(cb);
					panel.add(cb);
				}
			}

		}

		int result = JOptionPane.showConfirmDialog(null, panel, "Suppression de liens",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			Set<LienMultiple> linksToDelete = new HashSet<LienMultiple>();
			Set<Multiplicite> multToDelete1 = new HashSet<Multiplicite>();
			Set<Multiplicite> multToDelete2 = new HashSet<Multiplicite>();
			int i = 0;
			for (JCheckBox jCheckBox : checkbox) {
				if (jCheckBox.isSelected() && !linksToDelete.contains((LienMultiple)links.toArray()[i])) {
					linksToDelete.add((LienMultiple)(links.toArray()[i]));
					multToDelete1.add((Multiplicite)mults1.toArray()[i]);
					multToDelete2.add((Multiplicite)mults2.toArray()[i]);
				}
				i++;
			}
			controlerDC.supprimerLiens(linksToDelete);
			controlerC1.supprimerMultiplicites(multToDelete1);
			controlerC2.supprimerMultiplicites(multToDelete2);
        } else {
        	// Nothing
        }
	}
}
