package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import view.ClassifieurView;

public abstract class Classifieur extends Type {
	private ClassifieurView view;
	private Set<Methode> methodes;
	boolean isAbstract;
	private String nom;
	private int x;
	private int y;
	private int height;
	private int width;
	private Color color = Color.black;
	
	
	public Classifieur() {
		super();
		this.methodes = new HashSet<Methode>();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ClassifieurView getView() {
		return view;
	}

	public void setView(ClassifieurView view) {
		this.view = view;
	}
	
	public abstract boolean canHaveAttribut();

	
	public Set<Methode> getMethodes() {
		return methodes;
	}

	public void setMethodes(Set<Methode> methodes) {
		this.methodes = methodes;
	}

	public void ajouterMethode(Visibilite visibilite, Type type, String nom,
			boolean isAbstract, boolean isStatic) {
		Methode m = new Methode(new HashSet<Parametre>(), nom, isStatic, isAbstract, visibilite, type);
		this.methodes.add(m);
	}

	public void supprimerMethode(Methode methode) {
		this.methodes.remove(methode);
	}

	public void ajouterParametre(Type type, String nom, Methode methode) {
		methode.ajouterParametre(type, nom);
	}

	public void supprimerParam(Parametre param, Methode methode) {
		methode.supprimerParametre(param);
	}

}
