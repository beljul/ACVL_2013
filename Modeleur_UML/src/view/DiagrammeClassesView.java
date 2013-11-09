package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.Classe;
import model.Classifieur;
import model.DiagrammeClasses;
import controller.ClassifieurController;
import controller.DiagrammeClassesController;

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
		JMenu mnClasse = new JMenu("Classe");
		menuBar.add(mnClasse);
		
		JMenuItem mntmAjouterClasse = new JMenuItem("Ajouter classe");
		mntmAjouterClasse.addActionListener(this.controleur);
		mnClasse.add(mntmAjouterClasse);
		JMenuItem mntmModifierClasse = new JMenuItem("Modifier classe");
		mntmModifierClasse.addActionListener(this.controleur);
		mnClasse.add(mntmModifierClasse);
		JMenuItem mntmSupprimerClasse = new JMenuItem("Supprimer classe");
		mntmSupprimerClasse.addActionListener(this.controleur);
		mnClasse.add(mntmSupprimerClasse);

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
		selection = null;
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
	
}
