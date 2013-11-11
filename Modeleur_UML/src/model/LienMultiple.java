package model;

import java.util.HashSet;
import java.util.Set;

import view.LienAssociationSimpleView;

public abstract class LienMultiple extends Lien {
	Set<Multiplicite> multiplicites;
	private String nomRelation;
	private LienAssociationSimpleView view;

	public LienMultiple(){
		super();
		multiplicites = new HashSet<Multiplicite>();
	}
	
	public LienMultiple(String nom) {
		super();
		this.nomRelation = nom;
		multiplicites = new HashSet<Multiplicite>();
	}

	public Set<Multiplicite> getMultiplicites() {
		return multiplicites;
	}
	
	public LienAssociationSimpleView getView() {
		return view;
	}

	public void setView(LienAssociationSimpleView view) {
		this.view = view;
	}

	@Override
	public String toString() {
		String str = "Lien entre ";
		for (Multiplicite mult : this.multiplicites) {
			str += mult.getClasse().toString() + " et ";
		}
		str = str.substring(0, str.length()-4);
		if (this.nomRelation != null) {
			str += " : " + this.nomRelation;
		}
		return str;
	}
	
	
}
