package model;

import java.awt.Color;

import view.ClassifieurView;

public abstract class Classifieur {
	private ClassifieurView view;

	boolean isAbstract;
	private String nom;
	private int x;
	private int y;
	private int height;
	private int width;
	private Color color = Color.black;
	
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
}
