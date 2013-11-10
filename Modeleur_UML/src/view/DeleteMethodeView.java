package view;

import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import controller.ClassifieurController;

public class DeleteMethodeView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public DeleteMethodeView(Classifieur classifieur, DiagrammeClasses dc) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		Set<JCheckBox> checkbox = new HashSet<JCheckBox>();
		for (Methode meth : selection.getMethodes()) {
			JCheckBox cb = new JCheckBox(meth.toString());
			checkbox.add(cb);
			panel.add(cb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Suppression d'attributs",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			int i = 0;
			Set<Methode> methodesToDelete = new HashSet<Methode>();
			for (JCheckBox jCheckBox : checkbox) {
				if (jCheckBox.isSelected()) {
					methodesToDelete.add((Methode) classifieur.getMethodes().toArray()[i]);
				}
				i++;
			}
			controler.supprimerMethodes(methodesToDelete);
        } else {
        	// Nothing
        }
	}
}
