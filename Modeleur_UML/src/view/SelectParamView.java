package view;

import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Parametre;
import controller.ClassifieurController;

public class SelectParamView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public SelectParamView(Classifieur classifieur, DiagrammeClasses dc, Methode methode) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		ButtonGroup group = new ButtonGroup();
		Set<JRadioButton> radioButtons = new HashSet<JRadioButton>();
		for (Parametre param : methode.getParametres()) {
			JRadioButton rb = new JRadioButton(param.toString());
			radioButtons.add(rb);
			group.add(rb);
			panel.add(rb);
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Sélection d'une paramètre",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			int i = 0;
		    Enumeration<AbstractButton> e = group.getElements();
			while (e.hasMoreElements()) {
				AbstractButton b = e.nextElement();
				if (b.isSelected()) break;
				i++;
			}
			new ModifyParamView(classifieur, dc, methode, (Parametre)methode.getParametres().toArray()[i]);
			
        } else {
        	// Nothing
        }
	}
}
