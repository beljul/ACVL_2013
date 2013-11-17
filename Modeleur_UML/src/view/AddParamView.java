package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Visibilite;
import controller.ClassifieurController;

public class AddParamView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public AddParamView(Classifieur classifieur, DiagrammeClasses dc, Methode methode) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		ArrayList<model.Type> types = new ArrayList<model.Type>();
		for (model.Type t : diagClasses.getEnv().getTypesEnv()) {
			types.add(t);
		}
		JComboBox<String> comboTypes = new JComboBox(types.toArray());
		panel.add(new JLabel("Sélectionner type : "));
		panel.add(comboTypes);
        JTextField fieldParam = new JTextField("monParam");
		panel.add(new JLabel("Nom du paramètre: "));
		panel.add(fieldParam);
		int result = JOptionPane.showConfirmDialog(null, panel, "Ajout d'un paramètre",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			controler.ajouterParametre(types.get(comboTypes.getSelectedIndex()), fieldParam.getText(), methode);
        } else {
        	// Nothing
        }
	}
}
