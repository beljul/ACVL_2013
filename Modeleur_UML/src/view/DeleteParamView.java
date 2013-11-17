package view;

import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ClassifieurController;
import model.Attribut;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Parametre;

public class DeleteParamView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public DeleteParamView(Classifieur selection,
			DiagrammeClasses diagClasses, Methode methode) {
		this.selection = selection;
		this.diagClasses = diagClasses;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		Set<JCheckBox> checkbox = new HashSet<JCheckBox>();
		for (Parametre param : methode.getParametres()) {
			JCheckBox cb = new JCheckBox(param.toString());
			checkbox.add(cb);
			panel.add(cb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Sélection d'une méthode",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			int i = 0;
			Set<Parametre> paramsToDelete = new HashSet<Parametre>();
			for (JCheckBox jCheckBox : checkbox) {
				if (jCheckBox.isSelected()) {
					paramsToDelete.add((Parametre) methode.getParametres().toArray()[i]);
				}
				i++;
			}
			controler.supprimerParametres(paramsToDelete, methode);
        } else {
        	// Nothing
        }
	}

}
