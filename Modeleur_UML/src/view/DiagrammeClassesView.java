package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.Visibilite;
import controller.ClassifieurController;
import controller.DiagrammeClassesController;

@SuppressWarnings("serial")
public class DiagrammeClassesView extends JFrame implements MouseListener, MouseMotionListener {
	private DiagrammeClassesController controleur;
	private DiagrammeClasses modele;
	private Classifieur selection;
	private JFrame frame;
	private int nbElems = 0;
	
	public DiagrammeClassesView(DiagrammeClasses modele) {
		this.modele = modele;
		this.controleur = new DiagrammeClassesController(this, modele);  

        frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnClasse = new JMenu("Traitement classe");
		menuBar.add(mnClasse);
		JMenuItem mntmAjouterClasse = new JMenuItem("Ajouter classe");
		mntmAjouterClasse.addActionListener(this.controleur);
		mnClasse.add(mntmAjouterClasse);
		JMenuItem mntmModifierClasse = new JMenuItem("Modifier classe");
		mnClasse.add(mntmModifierClasse);
		JMenuItem mntmSupprimerClasse = new JMenuItem("Supprimer classe");
		mntmSupprimerClasse.addActionListener(this.controleur);
		mnClasse.add(mntmSupprimerClasse);

		JMenu mntmTraitementAttributs = new JMenu("Traitement attributs");
		mnClasse.add(mntmTraitementAttributs);
		JMenuItem mntmAjouterAttribut = new JMenuItem("Ajouter attribut");
		mntmAjouterAttribut.addActionListener(this.controleur);
		mntmTraitementAttributs.add(mntmAjouterAttribut);
		JMenuItem mntmModifierAttribut = new JMenuItem("Modifier attribut");
		mntmModifierAttribut.addActionListener(this.controleur);
		mntmTraitementAttributs.add(mntmModifierAttribut);
		JMenuItem mntmSupprimerAttribut = new JMenuItem("Supprimer attribut(s)");
		mntmSupprimerAttribut.addActionListener(this.controleur);
		mntmTraitementAttributs.add(mntmSupprimerAttribut);
		
		JMenu mntmTraitementMethodes = new JMenu("Traitement méthodes");
		mnClasse.add(mntmTraitementMethodes);
		JMenuItem mntmAjouterMethode = new JMenuItem("Ajouter méthode");
		mntmAjouterMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmAjouterMethode);
		JMenuItem mntmModifierMethode = new JMenuItem("Modifier méthode");
		mntmModifierMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmModifierMethode);
		JMenuItem mntmSupprimerMethode = new JMenuItem("Supprimer méthode(s)");
		mntmSupprimerMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmSupprimerMethode);
		
		JMenu mntmTraitementParametres = new JMenu("Traitement paramètres");
		mntmTraitementMethodes.add(mntmTraitementParametres);
		JMenuItem mntmAjouterParam = new JMenuItem("Ajouter paramètre");
		mntmAjouterParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmAjouterParam);
		JMenuItem mntmModifierParam = new JMenuItem("Modifier paramètre");
		mntmModifierParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmModifierParam);
		JMenuItem mntmSupprimerParam = new JMenuItem("Supprimer paramètre(s)");
		mntmSupprimerParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmSupprimerParam);
		
        setTitle("Modeleur UML");
        frame.setVisible(true);
	    frame.addMouseListener(this);
	    frame.addMouseMotionListener(this);

	}
	
	
	public void ajouterClass(Classe c) {
		ClassifieurView v = new ClassifieurView(c, nbElems);
		c.setView(v);
		frame.add(v);
		frame.setVisible(true);
		++nbElems;
	}
	
	public void supprimerClass(Classifieur classifieur) {
		frame.remove(classifieur.getView());
		frame.repaint();
		frame.setVisible(true);
		--nbElems;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Classifieur c : modele.getClassifieurs()) {
//			System.out.println(e.getX() + " > " + c.getX());
//			System.out.println(e.getY() + " > " + c.getY());
//			System.out.println(c.getHeight());
//			System.out.println(c.getWidth());
//			System.out.println(e.getX() + " < " + c.getX()+c.getWidth());
//			System.out.println(e.getY() + " < " + c.getY()+c.getHeight());
			if(e.getX() > c.getX() && e.getX() < c.getX() + c.getWidth()
					&& e.getY() > c.getY() && e.getY() < c.getY() + c.getHeight() ) {
				c.setColor(Color.red);
				c.getView().getControleur().updateView();
//				e.consume();
				break;
			}
			
			else {
				c.setColor(Color.black);
				c.getView().getControleur().updateView();
//				e.consume();
			}
			frame.repaint();
			frame.setVisible(true);
		}		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		for (Classifieur c : modele.getClassifieurs()) {
//			System.out.println(e.getX() + " > " + c.getX());
//			System.out.println(e.getY() + " > " + c.getY());
//			System.out.println(c.getHeight());
//			System.out.println(c.getWidth());
//			System.out.println(e.getX() + " < " + c.getX()+c.getWidth());
//			System.out.println(e.getY() + " < " + c.getY()+c.getHeight());
			if(e.getX() > c.getX() && e.getX() < c.getX() + c.getWidth()
					&& e.getY() > c.getY() && e.getY() < c.getY() + c.getHeight() ) {
				c.setColor(Color.red);
				selection = c;
				c.getView().getControleur().updateView();
//				e.consume();
				break;
			}
//			
//			else {
//				c.setColor(Color.black);
//				c.getView().getControleur().updateView();
////				e.consume();
//			}
//			frame.repaint();
//			frame.setVisible(true);
			
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		selection = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (selection != null) {
			selection.setX(e.getX());
			selection.setY(e.getY());
			selection.getView().getControleur().updateView();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Classifieur getSelection() {
		return selection;
	}


	public void setSelection(Classifieur selection) {
		this.selection = selection;
	}


	public void showError(String s) {
		JOptionPane.showMessageDialog(this, s, "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
	}

//	public void showAddAttribut() {
//		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
//		JPanel panel = new JPanel(new GridLayout(0, 1));
//		
//		ArrayList<model.Type> types = new ArrayList<model.Type>();
//		for (model.Type t : modele.getEnv().getTypesEnv()) {
//			types.add(t);
//		}
//		JComboBox<String> comboTypes = new JComboBox(types.toArray());
//		JComboBox<String> comboVisib = new JComboBox(Visibilite.values());
//		panel.add(new JLabel("Sélectionner type : "));
//		panel.add(comboTypes);
//		panel.add(new JLabel("Sélectionner visibilité : "));
//		panel.add(comboVisib);
//        JTextField fieldAtt = new JTextField("monAttribut");
//		panel.add(new JLabel("Nom de l'attribut : "));
//		panel.add(fieldAtt);
//		int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un attribut",
//	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//		if (result == JOptionPane.OK_OPTION) {
//			controler.ajouterAttribut(Visibilite.values()[comboVisib.getSelectedIndex()], 
//					types.get(comboTypes.getSelectedIndex()), fieldAtt.getText());
//        } else {
//        	// Nothing
//        }
//	}


//	public void showDeleteAttribut() {
//		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
//		JPanel panel = new JPanel(new GridLayout(0, 1));
//		
//		Classe c = (Classe) selection;
//		Set<JCheckBox> checkbox = new HashSet<JCheckBox>();
//		for (Attribut att : c.getAttributs()) {
//			JCheckBox cb = new JCheckBox(att.toString());
//			checkbox.add(cb);
//			panel.add(cb);
//		}
//		int result = JOptionPane.showConfirmDialog(null, panel, "Suppression d'attributs",
//	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//		if (result == JOptionPane.OK_OPTION) {
//			int i = 0;
//			Set<Attribut> attributsToDelete = new HashSet<Attribut>();
//			for (JCheckBox jCheckBox : checkbox) {
//				if (jCheckBox.isSelected()) {
//					attributsToDelete.add((Attribut) c.getAttributs().toArray()[i]);
//				}
//				i++;
//			}
//			controler.supprimetAttributs(attributsToDelete);
//        } else {
//        	// Nothing
//        }
//	}


//	public void showAddMethode() {
//		ClassifieurController controler = new ClassifieurController(selection.getView(), selection);
//		JPanel panel = new JPanel(new GridLayout(0, 1));
//		
//		ArrayList<model.Type> types = new ArrayList<model.Type>();
//		for (model.Type t : modele.getEnv().getTypesEnv()) {
//			types.add(t);
//		}
//		JComboBox<String> comboTypes = new JComboBox(types.toArray());
//		JComboBox<String> comboVisib = new JComboBox(Visibilite.values());
//		comboTypes.setToolTipText("");
//		panel.add(new JLabel("Sélectionner type de retour : "));
//		panel.add(comboTypes);
//		panel.add(new JLabel("Sélectionner visibilité : "));
//		panel.add(comboVisib);
//        JTextField fieldAtt = new JTextField("maMethode");
//		panel.add(new JLabel("Nom de la méthode : "));
//		panel.add(fieldAtt);
//		JCheckBox isAbstract = new JCheckBox("est abstraite");
//		JCheckBox isStatic = new JCheckBox("est statique");
//		panel.add(isAbstract);
//		panel.add(isStatic);
//		JButton addParam = new JButton("Ajouter un paramètre");
//		panel.add(addParam);
////		addParam.addActionListener(this);
//		int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter une méthode",
//	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//		if (result == JOptionPane.OK_OPTION) {
//			
//        } else {
//        	// Nothing
//        }
//		
//	}
	
}
