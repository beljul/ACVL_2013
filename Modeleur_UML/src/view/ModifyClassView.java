package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Visibilite;
import controller.ClassifieurController;

public class ModifyClassView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public ModifyClassView(Classifieur c, DiagrammeClasses dc) {
		this.selection = c;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
        JTextField fieldName = new JTextField(c.getNom());
		panel.add(new JLabel("Nouveau nom de la classe : "));
		panel.add(fieldName);
		int result = JOptionPane.showConfirmDialog(null, panel, "Modifier " + c.toString(),
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			controler.modifierClasse(fieldName.getText());
        } else {
        	// Nothing
        }
	}
}
