package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classifieur;
import model.DiagrammeClasses;
import model.Methode;
import model.Parametre;
import controller.ClassifieurController;

public class ModifyParamView {
	private Classifieur selection;
	private DiagrammeClasses diagClasses;
	
	public ModifyParamView(Classifieur classifieur, DiagrammeClasses dc, Methode m, Parametre param) {
		this.selection = classifieur;
		this.diagClasses = dc;
		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		ArrayList<model.Type> types = new ArrayList<model.Type>();
		for (model.Type t : diagClasses.getEnv().getTypesEnv()) {
			types.add(t);
		}
		JComboBox<String> comboTypes = new JComboBox(types.toArray());
		panel.add(new JLabel("Modifier type : " + param.getIdentifieur().getType()));
		panel.add(comboTypes);
        JTextField fieldParam = new JTextField(param.getIdentifieur().getNom());
		panel.add(new JLabel("Nouveau nom du paramètre : "));
		panel.add(fieldParam);
		int result = JOptionPane.showConfirmDialog(null, panel, "Modification du paramètre",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			controler.modifierParametre(types.get(comboTypes.getSelectedIndex()), fieldParam.getText(), m, param);
        } else {
        	// Nothing
        }
	}
}
