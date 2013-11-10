package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Type;
import model.Visibilite;
import controller.ClassifieurController;

public class AddMethodeView extends JComponent {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
//	private JPanel panel;
	
	public AddMethodeView(Classifieur classifieur, DiagrammeClasses dc) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		ArrayList<model.Type> types = new ArrayList<model.Type>();
		for (model.Type t : diagClasses.getEnv().getTypesEnv()) {
			types.add(t);
		}
		types.add(Methode.VOID);
		
		JComboBox<String> comboTypes = new JComboBox(types.toArray());
		JComboBox<String> comboVisib = new JComboBox(Visibilite.values());
		panel.add(new JLabel("Sélectionner type de retour : "));
		panel.add(comboTypes);
		panel.add(new JLabel("Sélectionner visibilité : "));
		panel.add(comboVisib);
        JTextField fieldMeth = new JTextField("maMethode");
		panel.add(new JLabel("Nom de la méthode : "));
		panel.add(fieldMeth);
		JCheckBox isAbstract = new JCheckBox("est abstraite");
		JCheckBox isStatic = new JCheckBox("est statique");
		panel.add(isAbstract);
		panel.add(isStatic);
//		JButton addParam = new JButton("Ajouter un paramètre");
//		panel.add(addParam);
//		AddParamController paramControler = new AddParamController(this, panel, selection, diagClasses);
//		addParam.addActionListener(paramControler);
		int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter une méthode",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
				controler.ajouterMethode(Visibilite.values()[comboVisib.getSelectedIndex()], 
						types.get(comboTypes.getSelectedIndex()),
						fieldMeth.getText(), isAbstract.isSelected(), isStatic.isSelected());
        } else {
        	// Nothing
        }
	}

}
