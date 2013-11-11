package view;

import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

import model.AssociationSimple;
import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.LienMultiple;
import model.Multiplicite;
import model.Visibilite;
import controller.ClassifieurController;
import controller.DiagrammeClassesController;

@SuppressWarnings("serial")
public class DiagrammeClassesView extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
	private DiagrammeClassesController controleur;
	private DiagrammeClasses modele;
	private Classifieur selection;
	private Classifieur secondSelection;
	private JFrame frame;
	private int nbElems = 0;
	private boolean ctrlIsPressed;
	private static final int CTRL = 17;
	
	public DiagrammeClassesView(DiagrammeClasses modele) {
		this.modele = modele;
		this.controleur = new DiagrammeClassesController(this, modele);  
		ctrlIsPressed = false;
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
		
		JMenu mnLien = new JMenu("Traitement lien");
		menuBar.add(mnLien);
		JMenu mntmLienAssociationSimple = new JMenu("Lien d'association simple");
		mnLien.add(mntmLienAssociationSimple);
		JMenuItem mntmAjouterAssociationSimple = new JMenuItem("Ajouter lien d'association simple");
		mntmAjouterAssociationSimple.addActionListener(this.controleur);
		mntmLienAssociationSimple.add(mntmAjouterAssociationSimple);
		
        setTitle("Modeleur UML");
        frame.pack();
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setExtendedState(this.MAXIMIZED_BOTH);
        frame.setVisible(true);
	    frame.addMouseListener(this);
	    frame.addMouseMotionListener(this);
	    frame.addKeyListener(this);

	}
	
	
	public void ajouterClass(Classe c) {
		ClassifieurView v = new ClassifieurView(c, nbElems);
		c.setView(v);
		frame.add(v);
		frame.setVisible(true);
		++nbElems;
	}
	

	public void ajouterLienAssociationSimple(AssociationSimple as) {
		LienAssociationSimpleView l = new LienAssociationSimpleView(as);
		as.setView(l);
		frame.add(l);
		frame.setVisible(true);		
	}
	
	public void supprimerClass(Classifieur classifieur) {
		frame.remove(classifieur.getView());
		frame.repaint();
		frame.setVisible(true);
		--nbElems;
	}

	public void supprimerLien(LienMultiple lien) {
		frame.remove(lien.getView());
		frame.repaint();
		frame.setVisible(true);	
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {
            for (Classifieur c : modele.getClassifieurs()) {
//                    System.out.println(e.getX() + " > " + c.getX());
//                    System.out.println(e.getY() + " > " + c.getY());
//                    System.out.println(c.getHeight());
//                    System.out.println(c.getWidth());
//                    System.out.println(e.getX() + " < " + c.getX()+c.getWidth());
//                    System.out.println(e.getY() + " < " + c.getY()+c.getHeight());
                    if(e.getX() > c.getX() && e.getX() < c.getX() + c.getWidth()
                                    && e.getY() > c.getY() && e.getY() < c.getY() + c.getHeight() ) {
                            if(selection!=null)
                            	selection.setColor(Color.red);
                            if(secondSelection!=null)
                            	secondSelection.setColor(Color.red);
                            c.getView().getControleur().updateView();
                            break;
                    }
                    
                    else {
                            if(selection!=null)
                            	selection.setColor(Color.black);
                            if(secondSelection!=null)
                            	secondSelection.setColor(Color.black);
                            c.getView().getControleur().updateView();
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
			if(e.getX() > c.getX() && e.getX() < c.getX() + c.getWidth()
					&& e.getY() > c.getY() && e.getY() < c.getY() + c.getHeight() ) {
				if(!ctrlIsPressed) {
					selection = c;
					secondSelection = null;
				}
				else {
					if(selection == null && secondSelection == null) {
						selection = c;
					}
					else if (selection != null && secondSelection == null) {
						if(!selection.equals(c))
							secondSelection = c;
					}
					else {
						if(!selection.equals(c))
							selection = c;
					}
				}
				c.getView().getControleur().updateView();
				break;
			}

			else {
				if(!ctrlIsPressed) {
					selection = null;
					secondSelection = null;
				}
				c.getView().getControleur().updateView();
			}
			
		}		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		selection = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (selection != null) {
			int xInit = selection.getX();
			int yInit = selection.getY();
			selection.setX(e.getX());
			selection.setY(e.getY());
			if(selection.canHaveAttribut()) {
				Classe c = (Classe)selection;
				for (Multiplicite mult : c.getMultiplicites()) {
					if(xInit == mult.getLien().getP1().getX() && yInit == mult.getLien().getP1().getY())
						mult.getLien().setP1(new Point(e.getX(), e.getY()));
					else
						mult.getLien().setP2(new Point(e.getX(), e.getY()));
				}
			}
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

	public Classifieur getSecondSelection() {
		return secondSelection;
	}

	public void setSecondSelection(Classifieur secondSelection) {
		this.secondSelection = secondSelection;
	}


	public void showError(String s) {
		JOptionPane.showMessageDialog(this, s, "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == CTRL) {
			ctrlIsPressed = true;	
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		ctrlIsPressed = false;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
