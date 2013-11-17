package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Multiplicite;
import model.Visibilite;
import controller.ClassifieurController;

public class ModifyMultiplicites {
	private DiagrammeClasses diagClasses;
	
	public ModifyMultiplicites(Classifieur c1, Classifieur c2, Multiplicite m1, Multiplicite m2) {

		ClassifieurController controler1 = new ClassifieurController(c1.getView(), c1);
		ClassifieurController controler2 = new ClassifieurController(c2.getView(), c2);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		panel.add(new JLabel("Modifier la multiplicité de : " + c1.toString() + " : " + m1.toString()));
		JTextField fieldM11 = new JTextField(m1.getBorneInf(), 1);
		panel.add(new JLabel("Modifier la borne inf : "));
		panel.add(fieldM11);
		JTextField fieldM12 = new JTextField(m1.getBorneSup(), 1);
		panel.add(new JLabel("Modifier la borne sup : "));
		panel.add(fieldM12);
		JTextField fieldM13 = new JTextField(m1.getRole());
		panel.add(new JLabel("Modifier le role : "));
		panel.add(fieldM13);
		
		panel.add(new JLabel("Modifier la multiplicité de : " + c2.toString() + " : " + m2.toString()));
		JTextField fieldM21 = new JTextField(m2.getBorneInf(), 1);
		panel.add(new JLabel("Modifier la borne inf : "));
		panel.add(fieldM21);
		JTextField fieldM22 = new JTextField(m2.getBorneSup(), 1);
		panel.add(new JLabel("Modifier la borne sup : "));
		panel.add(fieldM22);
		JTextField fieldM23 = new JTextField(m2.getRole());
		panel.add(new JLabel("Modifier le role : "));
		panel.add(fieldM23);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Modifier multiplicetes/roles",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			controler1.modifierMultiplicite(fieldM11.getText(), fieldM12.getText(), fieldM13.getText(), m1);
			controler2.modifierMultiplicite(fieldM21.getText(), fieldM22.getText(), fieldM23.getText(), m2);
        } else {
        	// Nothing
        }
	}
}
