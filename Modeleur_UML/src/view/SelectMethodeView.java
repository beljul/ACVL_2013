package view;

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
import javax.swing.JRadioButtonMenuItem;

import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import controller.ClassifieurController;

public class SelectMethodeView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public SelectMethodeView(Classifieur classifieur, DiagrammeClasses dc, boolean isAdding) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		ButtonGroup group = new ButtonGroup();
		Set<JRadioButton> radioButtons = new HashSet<JRadioButton>();
		for (Methode meth : selection.getMethodes()) {
			JRadioButton rb = new JRadioButton(meth.toString());
			radioButtons.add(rb);
			group.add(rb);
			panel.add(rb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Sélection d'une méthode",
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
			if(isAdding) {
				new AjouterParamView(selection, diagClasses, (Methode)selection.getMethodes().toArray()[i]);
			}
			else { // Deleting
				new SupprimerParamView(selection, diagClasses, (Methode)selection.getMethodes().toArray()[i]);
			}
        } else {
        	// Nothing
        }
	}
}
