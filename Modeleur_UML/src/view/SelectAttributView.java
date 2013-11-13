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
import model.DiagrammeClasses;
import model.Methode;
import model.Visibilite;
import controller.ClassifieurController;

public class SelectAttributView {
	private Classe selection;
	private DiagrammeClasses diagClasses;
	
	public SelectAttributView(Classe c, DiagrammeClasses dc) {
		this.selection = c;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		ButtonGroup group = new ButtonGroup();
		Set<JRadioButton> radioButtons = new HashSet<JRadioButton>();
		for (Attribut att : selection.getAttributs()) {
			JRadioButton rb = new JRadioButton(att.toString());
			radioButtons.add(rb);
			group.add(rb);
			panel.add(rb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Sélection d'un attribut",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			int i = 0;
		    Enumeration<AbstractButton> e = group.getElements();
			while (e.hasMoreElements()) {
				AbstractButton b = e.nextElement();
				if (b.isSelected()) break;
				i++;
			}
	//			controler.ajouterParametre(selection.getMethodes().toArray()[i]);
				new ModifyAttributView(selection, diagClasses, (Attribut)selection.getAttributs().toArray()[i]);
        } else {
        	// Nothing
        }
	}
}
