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

import model.Agregation;
import model.AssociationSimple;
import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import model.LienMultiple;
import model.LinkPosOnClass;
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
		mntmModifierClasse.addActionListener(this.controleur);
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
		
		JMenu mntmTraitementMethodes = new JMenu("Traitement m�thodes");
		mnClasse.add(mntmTraitementMethodes);
		JMenuItem mntmAjouterMethode = new JMenuItem("Ajouter m�thode");
		mntmAjouterMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmAjouterMethode);
		JMenuItem mntmModifierMethode = new JMenuItem("Modifier m�thode");
		mntmModifierMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmModifierMethode);
		JMenuItem mntmSupprimerMethode = new JMenuItem("Supprimer m�thode(s)");
		mntmSupprimerMethode.addActionListener(this.controleur);
		mntmTraitementMethodes.add(mntmSupprimerMethode);
		
		JMenu mntmTraitementParametres = new JMenu("Traitement param�tres");
		mntmTraitementMethodes.add(mntmTraitementParametres);
		JMenuItem mntmAjouterParam = new JMenuItem("Ajouter param�tre");
		mntmAjouterParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmAjouterParam);
		JMenuItem mntmModifierParam = new JMenuItem("Modifier param�tre");
		mntmModifierParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmModifierParam);
		JMenuItem mntmSupprimerParam = new JMenuItem("Supprimer param�tre(s)");
		mntmSupprimerParam.addActionListener(this.controleur);
		mntmTraitementParametres.add(mntmSupprimerParam);
		
		JMenu mnLien = new JMenu("Traitement lien");
		menuBar.add(mnLien);
		JMenu mntmLienBinaire = new JMenu("Liens binaire");
		mnLien.add(mntmLienBinaire);
		JMenuItem mntmAjouterAssociationSimple = new JMenuItem("Ajouter lien d'association simple");
		mntmAjouterAssociationSimple.addActionListener(this.controleur);
		mntmLienBinaire.add(mntmAjouterAssociationSimple);
		JMenuItem mntmAjouterAgregation = new JMenuItem("Ajouter lien d'agr�gation");
		mntmAjouterAgregation.addActionListener(this.controleur);
		mntmLienBinaire.add(mntmAjouterAgregation);
		JMenuItem mntmModifierLien= new JMenuItem("Modifier multiplicit�s/r�les");
		mntmModifierLien.addActionListener(this.controleur);
		mnLien.add(mntmModifierLien);
		JMenuItem mntmSupprimerLien= new JMenuItem("Supprimer lien(s)");
		mntmSupprimerLien.addActionListener(this.controleur);
		mnLien.add(mntmSupprimerLien);
		
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
	

	public void ajouterLienAgregation(Agregation a) {
		LienAgregationView l = new LienAgregationView(a);
		a.setView(l);
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
		if(!lien.isCompo())
			frame.remove(((AssociationSimple)lien).getView());
		else
			frame.remove(((Agregation)lien).getView());
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
                    if(e.getX() - 10 > c.getX() && e.getX() - 10 < c.getX() + c.getWidth()
                                    && e.getY() - 50 > c.getY() && e.getY() - 50 < c.getY() + c.getHeight() ) {
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
			System.out.println("x= " + c.getX() + "; y= "+ c.getY());
			System.out.println("xSouris= " + (e.getX()-10) + "; ySouris= "+ (e.getY()-50));
			System.out.println("Largeur= " + c.getWidth() + "; Hauteur= " + c.getHeight());
			if(e.getX() - 10 > c.getX() && e.getX() - 10 < c.getX() + c.getWidth()
					&& e.getY() - 50 > c.getY() && e.getY() - 50  < c.getY() + c.getHeight() ) {
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
			Point pInit = new Point(xInit, yInit);
			Point pCur = new Point(e.getX(), e.getY());
			selection.setX(e.getX());
			selection.setY(e.getY());
			if(selection.canHaveAttribut()) {
				Classe c = (Classe)selection;
				for (Multiplicite mult : c.getMultiplicites()) {
					Point p = new Point();

					if(mult.getpMult().getX() == mult.getLien().getP1().getX() && mult.getpMult().getY() == mult.getLien().getP1().getY()
							&& mult.getClasse().getNom().equals(c.getNom())) {
						switch (mult.getPosLink()) {
						case BOTTOM:
							p = new Point(e.getX() + c.getWidth()/2, e.getY() + c.getHeight());
							break;
						case TOP:
							p = new Point(e.getX() + c.getWidth()/2, e.getY());
							break;
						case LEFT:
							p = new Point(e.getX(), e.getY() + c.getHeight()/2);
							break;
						case RIGHT:
							p = new Point(e.getX() + c.getWidth(), e.getY() + c.getHeight()/2);
							break;
						default:
							break;
						}
						mult.getLien().setP1(p);
					}
					else {
						switch (mult.getPosLink()) {
						case BOTTOM:
							p = new Point(e.getX() + c.getWidth()/2, e.getY() + c.getHeight());
							break;
						case TOP:
							p = new Point(e.getX() + c.getWidth()/2, e.getY());
							break;
						case LEFT:
							p = new Point(e.getX(), e.getY() + c.getHeight()/2);
							break;
						case RIGHT:
							p = new Point(e.getX() + c.getWidth(), e.getY() + c.getHeight()/2);
							break;
						default:
						break;
						}
						mult.getLien().setP2(p);				
					}
					mult.setpMult(p);
					for (Multiplicite multi : mult.getLien().getMultiplicites()) {
						multi.getClasse().getView().getControleur().updateView();
					}
					if(!mult.getLien().isCompo())
						((AssociationSimple)mult.getLien()).getView().getControleur().updateView();
					else
						((Agregation)mult.getLien()).getView().getControleur().updateView();
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
