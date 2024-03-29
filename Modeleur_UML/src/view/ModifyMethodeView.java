package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Visibilite;
import controller.ClassifieurController;

public class ModifyMethodeView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
//	private JPanel panel;
	
	public ModifyMethodeView(Classifieur classifieur, DiagrammeClasses dc, Methode methode) {
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
		panel.add(new JLabel("Modifier type de retour : " + methode.getReturnType()));
		panel.add(comboTypes);
		panel.add(new JLabel("Modifier la visibilit� : " + methode.getVisibilite()));
		panel.add(comboVisib);
        JTextField fieldMeth = new JTextField(methode.getNom());
		panel.add(new JLabel("Nouveau nom de la m�thode : "));
		panel.add(fieldMeth);
		JCheckBox isAbstract = new JCheckBox("est abstraite");
		JCheckBox isStatic = new JCheckBox("est statique");
		isAbstract.setSelected(methode.isAbstract());
		isStatic.setSelected(methode.isStatic());
		panel.add(isAbstract);
		panel.add(isStatic);
		int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter une m�thode",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
				controler.modifierMethode(Visibilite.values()[comboVisib.getSelectedIndex()], 
						types.get(comboTypes.getSelectedIndex()),
						fieldMeth.getText(), isAbstract.isSelected(), isStatic.isSelected(), methode);
        } else {
        	// Nothing
        }
	}
}
