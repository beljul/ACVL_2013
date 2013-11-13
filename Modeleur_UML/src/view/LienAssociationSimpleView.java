package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import model.AssociationSimple;
import model.Attribut;
import model.Classe;
import model.Classifieur;
import model.Lien;
import model.LinkPosOnClass;
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
		ArrayList<Classe> classes = new ArrayList<Classe>();
		for (Multiplicite mult : l.getMultiplicites()) {
			classes.add(mult.getClasse());
		}
		ArrayList<Point> points1 = new ArrayList<Point>();
		ArrayList<Point> points2 = new ArrayList<Point>();

		Classe c1 = (Classe)classes.toArray()[0];
		Classe c2 = (Classe)classes.toArray()[1];

		// milieu haut
		points1.add(new Point(c1.getX() + c1.getWidth()/2, c1.getY()));
		points2.add(new Point(c2.getX() + c2.getWidth()/2, c2.getY()));

		// milieu bas
		points1.add(new Point(c1.getX() + c1.getWidth()/2, c1.getY() + c1.getHeight()));
		points2.add(new Point(c2.getX() + c2.getWidth()/2, c2.getY() + c2.getHeight()));
		
		// milieu gauche
		points1.add(new Point(c1.getX(), c1.getY() + c1.getHeight()/2));
		points2.add(new Point(c2.getX(), c2.getY() + c2.getHeight()/2));
		
		// milieu droite
		points1.add(new Point(c1.getX() + c1.getWidth(), c1.getY() + c1.getHeight()/2));
		points2.add(new Point(c2.getX() + c2.getWidth(), c2.getY() + c2.getHeight()/2));
		
		double dist = 9999999;
		int i = 0;
		Point point1 = new Point();
		Point point2 = new Point();
		for (Point p1 : points1) {
			for (Point p2 : points2) {
				if(dist > p1.distance(p2)) {
					dist = p1.distance(p2);
					point1 = p1;
					point2 = p2;
				}
			}
		}
		
		Multiplicite mult1 = (Multiplicite)(modele.getMultiplicites().toArray()[0]);
		switch (points1.indexOf(point1)) {
		case 0:
			mult1.setPosLink(LinkPosOnClass.TOP);
			break;
		case 1:
			mult1.setPosLink(LinkPosOnClass.BOTTOM);
			break;
		case 2:
			mult1.setPosLink(LinkPosOnClass.LEFT);
			break;
		case 3:
			mult1.setPosLink(LinkPosOnClass.RIGHT);
			break;
		default:
			break;
		}
		
		Multiplicite mult2 = (Multiplicite)(modele.getMultiplicites().toArray()[1]);
		switch (points2.indexOf(point2)) {
		case 0:
			mult2.setPosLink(LinkPosOnClass.TOP);
			break;
		case 1:
			mult2.setPosLink(LinkPosOnClass.BOTTOM);
			break;
		case 2:
			mult2.setPosLink(LinkPosOnClass.LEFT);
			break;
		case 3:
			mult2.setPosLink(LinkPosOnClass.RIGHT);
			break;
		default:
			break;
		}
		mult1.setpMult(point1);
		mult2.setpMult(point2);
		modele.setP1(point1);
		modele.setP2(point2);
		this.controleur = new LienAssociationSimpleController(this, l);
	}

	public void paintComponent(Graphics g){
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
