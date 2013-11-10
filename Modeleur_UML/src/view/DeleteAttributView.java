package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Attribut;
import model.Classe;
import model.DiagrammeClasses;
import model.Visibilite;
import controller.ClassifieurController;

public class DeleteAttributView {
	private Classe selection;
	private DiagrammeClasses diagClasses;
	
	public DeleteAttributView(Classe c, DiagrammeClasses dc) {
		this.selection = c;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		Classe cl = (Classe) selection;
		Set<JCheckBox> checkbox = new HashSet<JCheckBox>();
		for (Attribut att : cl.getAttributs()) {
			JCheckBox cb = new JCheckBox(att.toString());
			checkbox.add(cb);
			panel.add(cb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Suppression d'attributs",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			int i = 0;
			Set<Attribut> attributsToDelete = new HashSet<Attribut>();
			for (JCheckBox jCheckBox : checkbox) {
				if (jCheckBox.isSelected()) {
					attributsToDelete.add((Attribut) c.getAttributs().toArray()[i]);
				}
				i++;
			}
			controler.supprimetAttributs(attributsToDelete);
        } else {
        	// Nothing
        }
	}
}
