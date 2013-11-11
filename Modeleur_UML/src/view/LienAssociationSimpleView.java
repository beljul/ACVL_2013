package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import model.AssociationSimple;
import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.Lien;
import model.Methode;
import model.Multiplicite;
import controller.ClassifieurController;
import controller.LienAssociationSimpleController;



public class LienAssociationSimpleView extends JComponent {
	private AssociationSimple modele;
	private LienAssociationSimpleController controleur;
	
	public AssociationSimple getModele() {
		return modele;
	}

	public void setModele(AssociationSimple modele) {
		this.modele = modele;
	}

	public LienAssociationSimpleController getControleur() {
		return controleur;
	}

	public void setControleur(LienAssociationSimpleController controleur) {
		this.controleur = controleur;
	}

	
	public LienAssociationSimpleView(AssociationSimple l) {
		this.modele = l;
		Set<Classe> classes = new HashSet<Classe>();
		for (Multiplicite mult : l.getMultiplicites()) {
			classes.add(mult.getClasse());
		}
		modele.setP1(new Point(((Classe)classes.toArray()[0]).getX(), ((Classe)classes.toArray()[0]).getY()));
		modele.setP2(new Point(((Classe)classes.toArray()[1]).getX(), ((Classe)classes.toArray()[1]).getY()));
		this.controleur = new LienAssociationSimpleController(this, l);
	}

	public void paintComponent(Graphics g){
//		super.paintComponent(g);
		g.setColor(Color.black);
		Multiplicite[] mults = new Multiplicite[2];
		int i = 0;
		for (Multiplicite mult : modele.getMultiplicites()) {
			mults[i++] = mult;
		}
		g.drawString(mults[0].toString(),(int)modele.getP1().getX(), (int)modele.getP1().getY());
		g.drawString(mults[1].toString(),(int)modele.getP2().getX(), (int)modele.getP2().getY());
		g.drawLine((int)modele.getP1().getX(), (int)modele.getP1().getY(), 
				(int)modele.getP2().getX(), (int)modele.getP2().getY());
	    this.setVisible(true);
	}
}
