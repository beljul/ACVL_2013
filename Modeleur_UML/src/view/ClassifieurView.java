package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import controller.ClassifieurController;
import model.Classe;
import model.Classifieur;
import model.Attribut;
import model.Methode;
import model.Visibilite;


public class ClassifieurView extends JComponent {

	private Classifieur modele;
	private ClassifieurController controleur;
	
	public Classifieur getModele() {
		return modele;
	}

	public void setModele(Classifieur modele) {
		this.modele = modele;
	}

	public ClassifieurController getControleur() {
		return controleur;
	}

	public void setControleur(ClassifieurController controleur) {
		this.controleur = controleur;
	}

	private int nbElems;
	
	public ClassifieurView(Classifieur c, int nbElems) {
		this.modele = c;
		this.nbElems = nbElems;
		int nbChars = modele.getNom().length();
		modele.setX(20+50*nbElems);
		modele.setY(20+50*nbElems);
		modele.setHeight(100);
		modele.setWidth(10*nbChars);
		controleur = new ClassifieurController(this, c);
	}

	public void paintComponent(Graphics g){
//		super.paintComponent(g);
	    g.drawString(modele.getNom(), modele.getX() + (modele.getWidth()/4), modele.getY()+12);
    	int i = 1;
	    if(modele.canHaveAttribut()) {
	    	Classe c = (Classe)modele;
	    	if (c.getAttributs() != null)
			    for (Attribut att : c.getAttributs()) {
					g.drawString(att.toString(), modele.getX() + 2, modele.getY() + 12*(++i));
				}
	    }
	    for(Methode meth : modele.getMethodes()) {
	    	g.drawString(meth.toString(), modele.getX() + 2, modele.getY() + 12*(++i));
	    }
		g.setColor(modele.getColor());
	    g.drawRect(modele.getX(), modele.getY(), modele.getWidth(), modele.getHeight());
	    modele.setColor(Color.black);
	    this.setVisible(true);
	}
	
}