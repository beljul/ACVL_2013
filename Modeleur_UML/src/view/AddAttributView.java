package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classe;
import model.DiagrammeClasses;
import model.Visibilite;
import controller.ClassifieurController;

public class AddAttributView {

	private Classe selection;
	private DiagrammeClasses diagClasses;
	
	public AddAttributView(Classe c, DiagrammeClasses dc) {
		this.selection = c;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		ArrayList<model.Type> types = new ArrayList<model.Type>();
		for (model.Type t : diagClasses.getEnv().getTypesEnv()) {
			types.add(t);
		}
		JComboBox<String> comboTypes = new JComboBox(types.toArray());
		JComboBox<String> comboVisib = new JComboBox(Visibilite.values());
		panel.add(new JLabel("Sélectionner type : "));
		panel.add(comboTypes);
		panel.add(new JLabel("Sélectionner visibilité : "));
		panel.add(comboVisib);
        JTextField fieldAtt = new JTextField("monAttribut");
		panel.add(new JLabel("Nom de l'attribut : "));
		panel.add(fieldAtt);
		int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un attribut",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			controler.ajouterAttribut(Visibilite.values()[comboVisib.getSelectedIndex()], 
					types.get(comboTypes.getSelectedIndex()), fieldAtt.getText());
        } else {
        	// Nothing
        }
	}

}
