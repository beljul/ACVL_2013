package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;

import controller.LienAgregationController;
import controller.LienAssociationSimpleController;
import model.Agregation;
import model.AssociationSimple;
import model.Classe;
import model.LinkPosOnClass;
import model.Multiplicite;

public class LienAgregationView extends JComponent {

	private Agregation modele;
	private LienAgregationController controleur;
	
	public LienAgregationView(Agregation l) {
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
		this.controleur = new LienAgregationController(this, l);
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
		int[] xPoints = new int[4];
		int[] yPoints = new int[4];
		int x1 = (int)modele.getP1().getX();
		int y1 = (int)modele.getP1().getY();
		int x2 = (int)modele.getP2().getX();
		int y2 = (int)modele.getP2().getY();
		xPoints[0] = x1;
		yPoints[0] = y1;
		int largeur = 10;
		int hauteur = 20;
		switch (mults[0].getPosLink()) {
		case TOP:
			xPoints[1] = x1 - largeur;
			yPoints[1] = y1 - largeur;
			xPoints[2] = x1;
			yPoints[2] = y1 - hauteur;
			xPoints[3] = x1 + largeur;
			yPoints[3] = y1 - largeur;
			break;
		case BOTTOM:
			xPoints[1] = x1 + largeur;
			yPoints[1] = y1 + largeur;
			xPoints[2] = x1;
			yPoints[2] = y1 + hauteur;
			xPoints[3] = x1 - largeur;
			yPoints[3] = y1 + largeur;
			break;
		case LEFT:
			xPoints[1] = x1 - largeur;
			yPoints[1] = y1 + largeur;
			xPoints[2] = x1 - hauteur;
			yPoints[2] = y1;
			xPoints[3] = x1 - largeur;
			yPoints[3] = y1 - largeur;
			break;
		case RIGHT:
			xPoints[1] = x1 + largeur;
			yPoints[1] = y1 - largeur;
			xPoints[2] = x1 + hauteur;
			yPoints[2] = y1;
			xPoints[3] = x1 + largeur;
			yPoints[3] = y1 + largeur;
			break;
		default:
			break;
		}
		for (int j : xPoints) {
			System.out.println(j);
		}
		for (int j : yPoints) {
			System.out.println(j);
		}
		g.drawPolygon(xPoints, yPoints, 4);
		
//		g.drawLine((int)modele.getP1().getX(), (int)modele.getP1().getY(), 
//				(int)modele.getP2().getX(), (int)modele.getP2().getY());
		g.drawLine(x2, y2, xPoints[2], yPoints[2]);
	    this.setVisible(true);
	}
	
	public Agregation getModele() {
		return modele;
	}

	public void setModele(Agregation modele) {
		this.modele = modele;
	}

	public LienAgregationController getControleur() {
		return controleur;
	}

	public void setControleur(LienAgregationController controleur) {
		this.controleur = controleur;
	}

}
